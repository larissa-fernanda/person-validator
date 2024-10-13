package fatec.lg;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Email> emails = new ArrayList<Email>();

        Email email = new Email(1, "fulaninho.silva@email.com");
        emails.add(email);

        Person person = new Person(1, "Fulaninho Silva", 25, emails);
        PersonDAO personDAO = new PersonDAO();

        Email email2 = new Email(2, "fulaninhosilva.contato@email.com");
        person.addEmail(email2);

        personDAO.save(person);
    }
}