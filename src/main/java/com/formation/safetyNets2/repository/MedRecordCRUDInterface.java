package com.formation.safetyNets2.repository;

import java.util.List;

import com.formation.safetyNets2.model.MedRecord;

public interface MedRecordCRUDInterface {
	public List<MedRecord> readEntities();
	public List<MedRecord> createEntity(MedRecord nouvelle);
	public MedRecord selectEntity(String firstName, String lastName);
	public void updateEntity(MedRecord medRecord);
	public void deleteEntity(MedRecord medRecord);
}
