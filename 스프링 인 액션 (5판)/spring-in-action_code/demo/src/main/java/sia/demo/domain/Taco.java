package sia.demo.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@ToString
public class Taco {


    @NotNull(message = "이름을 입력해주세요.")
    @Size(min = 3, max=10 , message = "이름은 3~10자 사이로 입력해주세요")
    private String name;

    @NotNull(message = "이메일을 입력해주세요.")
    @Email(message = "이메일 양식이 맞지않습니다.")
    private String email;

    private List<String> ingredients;
}
