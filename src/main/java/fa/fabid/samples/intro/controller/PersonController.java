package fa.fabid.samples.intro.controller;

import fa.fabid.samples.intro.domain.Person;
import fa.fabid.samples.intro.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    private PersonRepository personRepo;

    @GetMapping("/{id}")
    Person findById(@PathVariable("id")int id){
        System.out.println("id="+id);
        return personRepo.findById(id);
    }

    @PostMapping
    boolean add(@RequestBody Person p){
        return personRepo.add(p);
    }
    @GetMapping
    List<Person> findAll(){
        return personRepo.findAll();
    }
}
