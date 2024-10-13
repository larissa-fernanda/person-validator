package fatec.lg;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PersonDAO {

    public void save(Person p){
        List<String> errors = isValidToInclude(p);

        if (!errors.isEmpty()) {
            System.out.println("Erros ao salvar pessoa: " + p.getName());
            for (String error : errors) {
                System.out.println(error);
            }
            return;
        }

        System.out.println("Salvando pessoa: " + p.getName());
    }

    public List<String> isValidToInclude(Person p){
        List<String> errors = new ArrayList<>();

        if (p.getName() == null || p.getName().trim().split(" ").length < 2 || !p.getName().matches("[a-zA-Z ]+")) {
            errors.add("O nome deve conter pelo menos duas partes e ser composto apenas por letras");
        }

        if (p.getAge() < 1 || p.getAge() > 200) {
            errors.add("A idade deve estar entre 1 e 200");
        }

        if (p.getEmails() == null || p.getEmails().isEmpty()) {
            errors.add("Pelo menos um email deve estar associado à pessoa");
        } else {
            for (Email email : p.getEmails()) {
                if (!email.getName().matches(".+@.+\\..+")) {
                    errors.add("O email deve estar no formato '_____@____._____'");
                }
            }
        }

        return errors;
    }
}
