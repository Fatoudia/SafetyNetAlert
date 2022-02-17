package com.formation.safetyNets2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.formation.safetyNets2.model.Firestation;
import com.formation.safetyNets2.repository.FirestationCRUDInterface;
import com.formation.safetyNets2.utile.DataParserJson;

@Service
public class FirestationServiceImpl implements FirestationCRUDInterface {
	
	@Override
	public List<Firestation> readEntities() {
		return DataParserJson.listeFirestations;
	}

	@Override
	public List<Firestation> createEntity(Firestation nouvelle) {
		DataParserJson.listeFirestations.add(nouvelle);
//		if (DataParserJson.listeFirestations.add(nouvelle) == true) {
//			System.out.println("create ok!");
//		}
		return DataParserJson.listeFirestations;
	}

	@Override
	public Firestation selectEntity(String adresse) {
		Firestation caserne = new Firestation();
		for (Firestation fs : DataParserJson.listeFirestations) {
			if (fs.getAddress().equals(adresse)) {
				caserne = fs;
			}
		}
		return caserne;
	}

	@Override
	public void updateEntity(Firestation caserne) {
		Firestation fs = selectEntity(caserne.getAddress());
		fs.setStation(caserne.getStation());

		System.out.println("update ok!");
	}

	@Override
	public void deleteEntity(Firestation caserne) {
		Firestation fs = selectEntity(caserne.getAddress());
		DataParserJson.listeFirestations.remove(fs);
		System.out.println("delete ok!");
	}
}