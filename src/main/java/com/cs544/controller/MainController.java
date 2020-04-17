package com.cs544.controller;

import com.cs544.dao.PersonRepository;
import com.cs544.domain.Person;
import com.cs544.domain.PersonRole;
import com.cs544.domain.Role;
import com.cs544.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class MainController {
     //   static int emailId=1;
    @Autowired
    PersonRepository personRepository;
    @GetMapping(value = "/")
    public List<Person> main(){
        return personRepository.findAll();
       }
    @GetMapping(value = "/users/init")
    public String init(){
     //   emailId++;
        List<PersonRole> roles= Arrays.asList(new PersonRole(Role.ADMIN),new PersonRole(Role.STUDENT));
        personRepository.save(new Person("user1@gmail.com","1234",
                "fasil","girma",roles
               ));
        return "success";
      //  return personRepository.findAll();
    }
    @PostMapping(value = "/users")
    public Person users(@RequestBody Person user){
        return personRepository.save(user);
    }
    @DeleteMapping(value="/users/delete")
        public ResponseEntity.BodyBuilder deleteUser(){
        personRepository.deleteAll();
        return ResponseEntity.status(200);
    }
    @GetMapping(value="/users/{id}")
    public Person findById(@PathVariable(value="id") String email){

        return personRepository.findByEmail(email).orElseThrow(()->new ResourceNotFoundException("not found", "email",email));
    }
}
