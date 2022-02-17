package com.formation.safetyNets2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.formation.safetyNets2.model.Person;
import com.formation.safetyNets2.repository.PersonCRUDInterface;
import com.formation.safetyNets2.utile.DataParserJson;

@Service
public class PersonServiceImpl implements PersonCRUDInterface {

	/********************************************************************\
	*                METHODES POUR LES ENDPOINTS DU CRUD                 *
	\********************************************************************/
	
	@Override
	public List<Person> readEntities() {
		return DataParserJson.listePersonnes;
	}

	@Override
	public List<Person> createEntity(Person nouvelle) {
		DataParserJson.listePersonnes.add(nouvelle);
		if (DataParserJson.listePersonnes.add(nouvelle) == true) {
			System.out.println("create ok!");
		}
		return DataParserJson.listePersonnes;
	}

	@Override
	public void updateEntity(Person personne) {
		Person p = selectEntity(personne.getFirstName(), personne.getLastName());
		p.setAddress(personne.getAddress());
		p.setZip(personne.getZip());
		p.setCity(personne.getCity());
		p.setPhone(personne.getPhone());
		p.setEmail(personne.getEmail());

		System.out.println("update ok!");
	}

	@Override
	public void deleteEntity(Person personne) {
		Person p = selectEntity(personne.getFirstName(), personne.getLastName());
		DataParserJson.listePersonnes.remove(p);
		System.out.println("delete ok!");
	}

	@Override
	public Person selectEntity(String firstName, String lastName) {
		Person pers = new Person();
		for (Person p : DataParserJson.listePersonnes) {
			if (p.getFirstName().equals(firstName) && p.getLastName().equals(lastName)) {
				pers = p;
			}
		}
		return pers;
	}


			/********************************************************************\
			*             METHODES POUR LES URLs DEMANDES DANS LE TP             *
			\********************************************************************/
	
	

	//	http://localhost:8080/communityEmail?city=<city>    

	public static List<String> emailListByCity(String city) {
		List<String> emails = new ArrayList<>();

		for (Person p : DataParserJson.listePersonnes) {
			if (p.getCity().equals(city))
				emails.add(p.getEmail());
		}

		return emails;
	}
//	
//
//	public Persons getByFullName(String firstName, String lastName) {
//		Persons unePersonne = new Persons();
//
//		for (Persons p : DataJson.persons) {
//			if (p.getFirstName().equals(firstName) && p.getLastName().equals(lastName)) {
//				unePersonne.setFirstName(p.getFirstName());
//				unePersonne.setLastName(p.getLastName());
//				unePersonne.setAddress(p.getCity());
//				unePersonne.setZip(p.getZip());
//				unePersonne.setCity(p.getCity());
//				unePersonne.setPhone(p.getPhone());
//				unePersonne.setEmail(p.getEmail());
//			}
//		}
//		return unePersonne;
//	}

}
