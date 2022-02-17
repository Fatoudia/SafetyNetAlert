package com.formation.safetyNets2.model;

import java.util.HashSet;
import java.util.Set;

public class MedRecord {
	private String firstName;
	private String lastName;
	private String birthdate;
	private Set<String> medications = new HashSet<>();
    private Set<String> allergies = new HashSet<>();

    
    
	public MedRecord() {
	}

	public MedRecord(Set<String> medications, Set<String> allergies) {
		this.medications = medications;
		this.allergies = allergies;
	}
	
	public MedRecord(String firstName, String lastName, String birthdate, Set<String> medications,
			Set<String> allergies) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.medications = medications;
		this.allergies = allergies;
	}

	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public Set<String> getMedications() {
		return medications;
	}

	public void setMedications(Set<String> medications) {
		this.medications = medications;
	}

	public Set<String> getAllergies() {
		return allergies;
	}

	public void setAllergies(Set<String> allergies) {
		this.allergies = allergies;
	}

	@Override
	public String toString() {
		return "Dossier medical de: " + firstName + " " + lastName + ", né(e) le: " + birthdate
				+ ", médication: " + medications + ", allergies connues: " + allergies + ";";
	}
}
