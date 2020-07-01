package fa.fabid.samples.intro.repository;

import fa.fabid.samples.intro.domain.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonRepository {
    List<Person> persons= new ArrayList<>();

    public Person findById(int id){
        return persons.stream().filter(p->p.getId()==id).findAny().orElse(null);
    }

    public List<Person> findAll(){
        return persons;
    }

    public boolean deleteById(int id){
        return persons.removeIf(p->p.getId()==id);
    }

    public boolean add(Person p){
        return persons.add(p);
    }

    public boolean update(Person p){
        int ind=persons.indexOf(p);
        if(ind>-1){
            persons.set(ind,p);
            return true;
        }
        return false;
    }
}
