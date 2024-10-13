package fatec.lg;

import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PersonDAO {

    public void save(Person p){
        System.out.println("Salvando pessoa: " + p);
    }

    public List<String> isValidToInclude(Person p){
        return null;
    }

}
