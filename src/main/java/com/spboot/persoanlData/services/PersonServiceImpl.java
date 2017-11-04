package com.spboot.persoanlData.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spboot.persoanlData.model.Person;



@Service("personService")
public class PersonServiceImpl implements PersonService{

	private static final String counter = new String();

	private static List<Person> users;

	static {
		users = populateDummyUsers();
	}

	private static List<Person> populateDummyUsers() {
		List<Person> users = new ArrayList<Person>();
		return users;
	}

	@Override
	
		public Person findById(String id) {
			for(Person user : users){
				if(user.getId() == id){
					return user;
				}
			}
			return null;
	}



	@Override
	public void saveUser(Person user) {
		user.setId(counter);
		users.add(user);
		
	}

	@Override
	public void updateUser(Person currentUser) {
		int index = users.indexOf(currentUser);
		users.set(index, currentUser);
		
	}

	@Override
	public void deleteUserById(String id) {
		for (Iterator<Person> iterator = users.iterator(); iterator.hasNext(); ) {
		    Person user = iterator.next();
		    if (user.getId() == id) {
		        iterator.remove();
		    }
		}
		
	}

	@Override
	public boolean isUserExist(Person person) {
		return findById(person.getfName())!=null;
		
	}

	
	
}
