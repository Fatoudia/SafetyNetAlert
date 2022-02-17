package com.formation.safetyNets2.repository;

import java.util.List;

import com.formation.safetyNets2.model.Person;

public interface PersonCRUDInterface {
	public List<Person> readEntities();
	public List<Person> createEntity(Person nouvelle);
	public Person selectEntity(String firstName, String lastName);
	public void updateEntity(Person personne);
	public void deleteEntity(Person personne);
}