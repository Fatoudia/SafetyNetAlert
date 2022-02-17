package com.formation.safetyNets2.repository;

import java.util.List;

import com.formation.safetyNets2.model.Firestation;

public interface FirestationCRUDInterface {
	public List<Firestation> readEntities();
	public List<Firestation> createEntity(Firestation nouvelle);
	public Firestation selectEntity(String adresse);
	public void updateEntity(Firestation firestation);
	public void deleteEntity(Firestation firestation);
}
