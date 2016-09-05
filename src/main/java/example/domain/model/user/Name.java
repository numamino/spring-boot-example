package example.domain.model.user;

import org.hibernate.validator.constraints.NotBlank;

public class Name {

    @NotBlank(message = "名前を入力してください。")
    String text;

    public Name(String text)  {
        this.text = text;
    }

    public Name() {
        this.text = "";
    }

    @Override
    public String toString() {
        return text;
    }
}
