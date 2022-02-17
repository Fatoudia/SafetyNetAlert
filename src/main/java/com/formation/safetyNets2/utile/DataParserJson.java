package com.formation.safetyNets2.utile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.formation.safetyNets2.model.Firestation;
import com.formation.safetyNets2.model.MedRecord;
import com.formation.safetyNets2.model.Person;

@Component
public class DataParserJson {
	/********************************************************************\
	* Classe qui assure le parsing du fichier de données data.json
	* et sauvegarde le contenu dans 3 listes statiques, corréspondant
	* aux 3 blocs: "persons", "firestations" et "medicalrecords"
	\********************************************************************/
	
	@Value("${json.file.location}") // le chemin vers le fichier de données a été déclaré dans
									// applicatyion.properties

	// l'objet File va nous donner le chemin du fichier à lire (source)
	private File file;
	private static final Logger LOGGER = LogManager.getLogger(DataParserJson.class);

	// les 3 listes sont déclarés "static" pour permettre l'accès depuis toutes les autres classes
	public static List<Person> listePersonnes = new ArrayList<>();
	public static List<MedRecord> listeMedRecords = new ArrayList<>();
	public static List<Firestation> listeFirestations = new ArrayList<>();
	
	ObjectMapper mapper = new ObjectMapper();
	
	// @EventListener permet le remplissage des 3 listes dès le démarrage de l'application
	// Ainsi, on simule une "persistance" des données tant que l'application tourne
	
	@EventListener
	public void readPersons(ApplicationReadyEvent event) {
		try {
			JsonNode jsonNode = mapper.readTree(file);		// A FAIRE: trouver un moyen pour sortir en dehors des methodes le mappage des données (DRY)
			String arrayString = jsonNode.get("persons").toString();
			
			listePersonnes = mapper.readValue(arrayString, new TypeReference<List<Person>>() {});
//			listePersonnes = mapper.readValue(file, DataJson.class).getPersons();

			LOGGER.info("Liste personnes peuplée!");
		} catch (IOException e) {
			LOGGER.info("FAIL TO READ Liste personnes", e);
		}
	}

	@EventListener
	public void readMedRecords(ApplicationReadyEvent event) {
		try {
			JsonNode jsonNode = mapper.readTree(file);
			String arrayString = jsonNode.get("medicalrecords").toString();
			
			listeMedRecords = mapper.readValue(arrayString, new TypeReference<List<MedRecord>>() {});

			LOGGER.info("Liste dossiers médicaux peuplée!");
		} catch (IOException e) {
			LOGGER.info("FAIL TO READ Liste  dossiers médicaux", e);
		}
	}

	@EventListener
	public void readFirestations(ApplicationReadyEvent event) {
		try {
			JsonNode jsonNode = mapper.readTree(file);
			String arrayString = jsonNode.get("firestations").toString();
			
			listeFirestations = mapper.readValue(arrayString, new TypeReference<List<Firestation>>() {});

			LOGGER.info("Liste casernes peuplée!");
		} catch (IOException e) {
			LOGGER.info("FAIL TO READ Liste  casernes", e);
		}
	}
}