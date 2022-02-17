package com.formation.safetyNets2.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonTest {

	private Person p;
	
	@BeforeEach
	public void setUp() throws Exception {
		p = new Person();
		p.setFirstName("Miru");
		p.setLastName("POP");
		p.setAddress("mon adresse");
		p.setZip("93200");
		p.setCity("Saint-Denis");
		p.setPhone("1234567890");
		p.setEmail("adresse@mail.com");
	}

	@AfterEach
	public void tearDown() throws Exception {
		p = null;
	}

	@Test
	public void testPersonne() {
		assertNotNull(p, "L'objet n'a pas été instancié");
	}

	@Test
	public void testGetPrenom() {
		assertEquals("Miru", p.getFirstName(), "Prenom incorrect");
	}

	@Test
	public void testGetAdresse() {
		assertEquals("mon adresse", p.getAddress(), "Adresse incorrecte");
	}

	@Test
	public void testSetNom() {
		p.setLastName("POPESCU");
		assertEquals("POPESCU", p.getLastName(), "Nom incorrect");
	}

	@Test
	public void testToString() {
		assertNotNull(p.toString(), "La chaine n'a pas été créée");
	}
}
