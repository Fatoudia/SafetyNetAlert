package com.formation.safetyNets2.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class FirestationTest {

	@Autowired
	private Firestation fs;
	
	@BeforeEach
	void setUp() throws Exception {
		fs.setStation(null);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetStation() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}
}
