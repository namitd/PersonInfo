package com.spboot.persoanlData.services;

import com.spboot.persoanlData.model.Person;


public interface PersonService {

	Person findById(String id);

	void saveUser(Person user);

	void updateUser(Person currentUser);

	void deleteUserById(String id);

	boolean isUserExist(Person person);

}
