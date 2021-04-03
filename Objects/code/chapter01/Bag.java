package chapter01;

public class Bag {
    private Long amount;
    private Invitation invitation;
    private Ticket ticket;

    public boolean hasInvitation(){
        // invitation을 가지고 있다면 참이다. (null이 아니면)
        return invitation != null;
    }

    public boolean hasTicket() {
        // ticket을 가지고 있다면 참이다. (null이 아니면)
        return ticket != null;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }

    // null을 사용하면 에러남... (당연이 null을 가리기는 파라메터가 없음)
    public Bag(Long amount) {
        this.amount = amount;
//        this(null, amount); ?? 책에서는 이러한 방식으로 쓰여있었음..
    }

    public Bag(Long amount, Invitation invitation) {
        this.amount = amount;
        this.invitation = invitation;
    }
}
