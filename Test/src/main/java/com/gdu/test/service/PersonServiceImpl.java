package com.gdu.test.service;


import com.gdu.test.domain.Person;

public class PersonServiceImpl implements IPersonService {

	@Override
	public Person execute(Person person) {
		
		String name = person.getName();
		int age = person.getAge();
		
		return new Person(name, age);
	}

}
