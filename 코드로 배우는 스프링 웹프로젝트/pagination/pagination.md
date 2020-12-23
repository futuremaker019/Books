### criteria

```java
@Getter
@Setter
@ToString
public class Criteria {
	
	private int pageNum;
	private int amount;
	
	private String type;
	private String keyword;
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public Criteria() {
		this(1, 20);
	}
	
	public String[] getTypeArr() {
		return type == null ? new String[] {}: type.split("");
	}
}
```
- 기본 정보
    - 페이지 번호
        - 보고자 하는 페이지를 지정한다.
    - 데이터 양
        - 한 페이지에 보여질 데이터를 정의한다.
    - 검색 기능
        - type
            - 검색 시, 작가, 책 제목, isbn으로 타입을 지정하여 검색을 한다.
        - keyword
            - 타입이 지정되었으면 검색할 내용을 작성한다.

<br><br>

### pageDto
```java
@Getter
@ToString
public class PageDTO {

	private int startPage;
	private int endPage;
	private boolean previous;
	private boolean next;
	
	private int total;
	private Criteria criteria;
	
	public PageDTO(Criteria criteria, int total) {
		
		this.criteria = criteria;
		this.total = total;
		
		this.endPage = (int) (Math.ceil(criteria.getPageNum() / 10.0)) * 10;
		this.startPage = this.endPage - 9;
		
		int realEndPage = (int) Math.ceil(total * 1.0 / criteria.getAmount());
		
		if (realEndPage < this.endPage) {
			this.endPage = realEndPage;
		}
		
		this.previous = this.startPage > 1;
		this.next = this.endPage < realEndPage;
	}
}
```

- 화면에 표시될 페이지의 번호를 나타내준다.
    - 기본 정보
        - startPage
            - 시작 페이지 번호는 끝 페이지 번호의 -9를 하여 구하는게 수월하다.
        - endPage
            - 현재의 페이지 번호/10을 한다. (현재 페이지 번호 1 / 10 = 0.1)
            - 나눠진 수의 ceiling (0.1 -> 1)
            - ceiling 된 수의 * 10 (1 * 10 -> 10)
            - 최종 수가 현재 페이지의 마지막 숫자가 된다.
        - previous
            - 페이지 11부터는 previous가 보여지도록 만들어주어야 한다.
            - 해당 필드는 jsp 페이지에서 이전페이지를 보여줄때 조건문으로 사용한다.
        - next
            - 페이지가 10개 이상이 될때 사용한다.
            - 해당 필드는 jsp 페이지에서 이후페이지를 보여줄때 조건문으로 사용한다.
        - totla
            - 데이터의 총개수는 마지막 페이지를 구하기 위해 사용한다. (realEndPage)
            - total * 1.0 / amount 
                - 1.0을 곱해주는 이유는 amount(한페이지에 보여지는 데이터수)를 나누어 나머지를 표시하여 ceiling에 이용하기 위함이다.
            - amount로 나누어진 값을 ceiling해주어야 나머지 데이터를 보여줄 수 있다.
            - ex) (123 * 1.0 / 10 --> 12.3) ceiling 할 경우 13, 결국 13페이지가 만들어져야 한다는 것을 명시한다.
        - criteria (페이지 번호, 데이터 갯수)
            - pageDto에 해당 페이지의 번호와 표시될 데이터 갯수를 넘겨준다.
            - criteria는 jsp페이지에서 받아줘야 한다.
                - 페이지 번호는 a tag로 만들어 클릭시 href 값이 들어가도록 만들어준다.
                - input을 이용하여 페이지번호와 amount를 form으로 전송해준다.


<br> 

```javascript
<section>
	<div class="row">
		<div class="col-lg-12">
			<ul class="pagination float-right">
            //
				<c:if test = "${pageMaker.previous }">
					<li class = "page-item previous">
						<a class="page-link" href = "${pageMaker.startPage - 1 }">Previous</a>
					</li>
				</c:if>
				
				<c:forEach var="number" begin="${pageMaker.startPage }" end = "${pageMaker.endPage }">
					<li class="page-item ${pageMaker.criteria.pageNum == number ? 'active' : '' }">
						<a class="page-link" href="${number }">${number }</a>				
					</li>
				</c:forEach>
				
				<c:if test="${pageMaker.next }">
					<li class="page-item next">
						<a class="page-link" href="${pageMaker.endPage + 1 }">Next</a>
					</li>
				</c:if>
			</ul>
		</div>
	</div>
</section>
<!-- end-pagination -->

<form id='actionForm' action="/board/list" method='get'>
    <input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum }'>
    <input type='hidden' name='amount' value='${pageMaker.cri.amount }'>
    <input type="hidden" name="type" value="${pageMaker.cri.type }">
    <input type="hidden" name="keyword" value="${pageMaker.cri.keyword }">
</form>
<!-- end-pagination -->

$(".paginate_button a").on("click", function(e) {
    e.preventDefault();
    
    actionForm.find("input[name='pageNum']").val($(this).attr("href"));
    actionForm.submit();
})
```
- pagination의 번호를 누르면 해당 a tag의 value값의 번호로 form이 submit되게 만들어준다.

```java
@GetMapping("/list")
public void list(Criteria cri, Model model) {
    model.addAttribute("list", boardService.getList(cri));
    
    int total = boardService.getTotal(cri);
    model.addAttribute("pageMaker", new PageDTO(cri, total));
}
```
- 서버에서는 2가지 일이 일어난다.
    - form 전송으로 받은 criteria를 boardService에 getList로 전달하여 rownum을 이용한 mapper로 부터 해당 페이지를 얻어온다.
    - pageMaker에 PageDto를 다시 보내준다. 페이지의 pagination에서는...
        - 받은 pageNum을 이용하여 pageDto는 페이지를 계산하여 전체 pagination을 다시 만들어 화면에 뿌려준다.
        - 페이지에서 전달된 criteria의 pageNum을 다시 jsp페이지에 전달하여 해당 pagination의 번호를 active로 만들어준다.
        