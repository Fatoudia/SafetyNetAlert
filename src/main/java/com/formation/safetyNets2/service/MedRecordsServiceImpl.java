package com.formation.safetyNets2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.formation.safetyNets2.model.MedRecord;
import com.formation.safetyNets2.repository.MedRecordCRUDInterface;
import com.formation.safetyNets2.utile.DataParserJson;

@Service
public class MedRecordsServiceImpl implements MedRecordCRUDInterface {
	@Override
	public List<MedRecord> readEntities() {
		return DataParserJson.listeMedRecords;
	}

	@Override
	public List<MedRecord> createEntity(MedRecord nouvelle) {
		DataParserJson.listeMedRecords.add(nouvelle);
		System.out.println("create ok!");
		
		return DataParserJson.listeMedRecords;
	}

	@Override
	public MedRecord selectEntity(String firstName, String lastName) {
		MedRecord dossier = new MedRecord();
		for (MedRecord mr : DataParserJson.listeMedRecords) {
			if (mr.getFirstName().equals(firstName) && mr.getLastName().equals(lastName)) {
				dossier = mr;
			}
		}
		return dossier;
	}

	@Override
	public void updateEntity(MedRecord dossier) {
		MedRecord mr = selectEntity(dossier.getFirstName(), dossier.getLastName());
		mr.setAllergies(dossier.getAllergies());
		mr.setMedications(dossier.getMedications());
		mr.setBirthdate(dossier.getBirthdate());

		System.out.println("update ok!");
	}

	@Override
	public void deleteEntity(MedRecord dossier) {
		MedRecord mr = selectEntity(dossier.getFirstName(), dossier.getLastName());
		DataParserJson.listeMedRecords.remove(mr);
		System.out.println("delete ok!");
	}
}