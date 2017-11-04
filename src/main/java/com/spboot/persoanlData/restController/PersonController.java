package com.spboot.persoanlData.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.spboot.persoanlData.model.Person;
import com.spboot.persoanlData.services.PersonService;
import com.spboot.persoanlData.userException.PersonException;

@RestController
@RequestMapping("/api")
public class PersonController {
 

 
    @Autowired
    PersonService personService; //Service
    
    @Autowired
    Person person;
 
    
 
    // -------------------Create a User-------------------------------------------
 
    @RequestMapping(value = "/person/", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody Person person, UriComponentsBuilder ucBuilder) {
       
 
        if (personService.isUserExist(person)) {
           
            return new ResponseEntity<Object>(new PersonException(),HttpStatus.CONFLICT);
        }
        personService.saveUser(person);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(person.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
 
    // ------------------- Update a User ------------------------------------------------
 
    @RequestMapping(value = "/person/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@PathVariable("id") String id, @RequestBody Person person) {
        
 
        Person currentUser = personService.findById(id);
 
        if (currentUser == null) {
            
            return new ResponseEntity<Object>(new PersonException("Unable to upate. User with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
 
        currentUser.setPincode(person.getPincode());
        currentUser.setBirthDate(person.getBirthDate());
        
 
        personService.updateUser(currentUser);
        return new ResponseEntity<Person>(currentUser, HttpStatus.OK);
    }
 
    // ------------------- Delete a User-----------------------------------------
 
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") String id) {
        
        Person user = personService.findById(id);
        if (user == null) {
          
            return new ResponseEntity<Object>(new PersonException("Unable to delete. User with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        personService.deleteUserById(id);
        return new ResponseEntity<Person>(HttpStatus.NO_CONTENT);
    }
 
    
}