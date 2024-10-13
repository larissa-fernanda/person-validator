package fatec.lg;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PersonDAOTest {

    @Test
    public void testValidPerson() {
        Email email = new Email(1, "john.doe@example.com");
        ArrayList<Email> emails = new ArrayList<Email>();
        emails.add(email);
        Person person = new Person(1, "John Doe", 25, emails);
        PersonDAO personDAO = new PersonDAO();

        List<String> errors = personDAO.isValidToInclude(person);
        assertTrue(errors.isEmpty(), "Não deve haver erros para uma pessoa válida");
    }

    @Test
    public void testInvalidName() {
        Email email = new Email(1, "john.doe@example.com");
        ArrayList<Email> emails = new ArrayList<Email>();
        emails.add(email);
        Person person = new Person(1, "John", 25, emails);
        PersonDAO personDAO = new PersonDAO();

        List<String> errors = personDAO.isValidToInclude(person);
        assertTrue(errors.contains("O nome deve conter pelo menos duas partes e ser composto apenas por letras"), "Falha na validação do nome");
    }

    @Test
    public void testInvalidAge() {
        Email email = new Email(1, "john.doe@example.com");
        ArrayList<Email> emails = new ArrayList<Email>();
        emails.add(email);
        Person person = new Person(1, "John Doe", 300, emails);
        PersonDAO personDAO = new PersonDAO();

        List<String> errors = personDAO.isValidToInclude(person);
        assertTrue(errors.contains("A idade deve estar entre 1 e 200"), "Falha na validação da idade");
    }

    @Test
    public void testNoEmails() {
        ArrayList<Email> emails = new ArrayList<Email>();
        Person person = new Person(1, "John Doe", 25, emails);
        PersonDAO personDAO = new PersonDAO();

        List<String> errors = personDAO.isValidToInclude(person);
        assertTrue(errors.contains("Pelo menos um email deve estar associado à pessoa"), "Falha na validação de emails");
    }

    @Test
    public void testInvalidEmail() {
        Email email = new Email(1, "invalidemail.com");
        ArrayList<Email> emails = new ArrayList<Email>();
        emails.add(email);
        Person person = new Person(1, "John Doe", 25, emails);
        PersonDAO personDAO = new PersonDAO();

        List<String> errors = personDAO.isValidToInclude(person);
        assertTrue(errors.contains("O email deve estar no formato '_____@____._____'"), "Falha na validação do formato de email");
    }
}
