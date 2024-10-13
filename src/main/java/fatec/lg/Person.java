package fatec.lg;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Person {
    int id;
    String name;
    int age;
    List<Email> emails;

    public void addEmail(Email email) {
        emails.add(email);
    }
}
