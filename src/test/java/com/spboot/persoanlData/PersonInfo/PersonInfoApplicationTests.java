package com.spboot.persoanlData.PersonInfo;

import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.spboot.persoanlData.model.Person;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonInfoApplicationTests {

	 public static final String REST_SERVICE_URI = "http://localhost:8080/SpringBootRestApi/api";
	@Test
	public void contextLoads() {
	}
	
	 private static void createUser() {
	        System.out.println("Testing create User API----------");
	        RestTemplate restTemplate = new RestTemplate();
	        Person user = new Person("0","Sarah",51,134);
	        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/user/", user, Person.class);
	        System.out.println("Location : "+uri.toASCIIString());
	    }
	
	 private static void updateUser() {
	        System.out.println("Testing update User API----------");
	        RestTemplate restTemplate = new RestTemplate();
	        Person user  = new Person("1","Tomy",33, 70000);
	        restTemplate.put(REST_SERVICE_URI+"/user/1", user);
	        System.out.println(user);
	    }
	 
	    /* DELETE */
	    private static void deleteUser() {
	        System.out.println("Testing delete User API----------");
	        RestTemplate restTemplate = new RestTemplate();
	        restTemplate.delete(REST_SERVICE_URI+"/user/3");
	    }
	 

	    public static void main(String args[]){
	       
	        createUser();
	       
	        updateUser();
	        
	        deleteUser();
	      
	    }
}
