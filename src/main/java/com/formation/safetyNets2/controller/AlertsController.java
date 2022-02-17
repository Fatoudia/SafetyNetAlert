//package com.formation.safetyNets2.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.json.*;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.formation.safetyNets2.model.MedRecords;
//import com.formation.safetyNets2.model.Persons;
//import com.formation.safetyNets2.service.FirestationServiceImpl;
//import com.formation.safetyNets2.service.MedRecordsServiceImpl;
//import com.formation.safetyNets2.service.PersonServiceImpl;
//
//@RestController
//@RequestMapping
//
//public class AlertsController {
//
//	@Autowired
//	private PersonServiceImpl ps;
//	@Autowired
//	private FirestationServiceImpl fss;
//	@Autowired
//	private MedRecordsServiceImpl mrs;
//
////	http://localhost:8080/communityEmail?city=<city>
//	@GetMapping("/communityEmail")
//	public List<String> emailListByCity(@RequestParam String city) {
//		return this.ps.emailListByCity(city);
//	}
//
////	http://localhost:8080/phoneAlert?firestation=<firestation_number>
//	@GetMapping("/phoneAlert")
//
//	public List<String> phoneNbrsByStation(@RequestParam String firestation) {
//		List<String> telephonesParAdresse = new ArrayList<>();
//		for (String adresse : fss.getAdressesByStation(firestation)) {
//			for (Persons p : ps.getList()) {
//				if (p.getAddress().equals(adresse)) {
//					telephonesParAdresse.add(p.getPhone());
//				}
//			}
//		}
//		return telephonesParAdresse;
//	}
//
////	http://localhost:8080/personInfo?firstName=<firstName>&lastName=<lastName>
//// pb: consigne mal formulée?
//// soit il y a 1 seul paramètre = "lastName" => on retourne liste de toutes les personnes portant le même nom
//// soit il y a 2 paramètres => on retourne une personne unique
//	@GetMapping("/personInfo")
//	public JSONObject getPersonsInfoPlusMedRecord(@RequestParam String firstName, @RequestParam String lastName) {
//		JSONObject personInfo = new JSONObject();
//		Persons p = ps.getByFullName(firstName, lastName);
//		MedRecords mr = mrs.getByFullName(firstName, lastName);
////		for (MedRecords mr : mrs.getList()) {
////			if (mr.getFirstName().equals(p.getFirstName()) && mr.getLastName().equals(p.getLastName())) {
////
////			}
//		personInfo.put("lastName:", p.getLastName());
//		personInfo.put("address:", p.getAddress());
//		personInfo.put("email:", p.getEmail());
////		personInfo.put("medication:", mr.getMedications());
////		personInfo.put("medication:", mr.getAllergies());
//		
//		return personInfo;
//		}
//
////		for (MedRecords mr : mrs.getList()) {
////			for (Persons p : ps.getList()) {
////				if (mr.getFirstName().equals(p.getFirstName())
////						&& mr.getLastName().equals(p.getLastName())) {
////					combined.add(p.getFirstName());
////					combined.add(p.getLastName());
////					combined.add(p.getAddress());
////					combined.add(p.getEmail());
////					
////					combined.add(mr.getMedications());
////					combined.add(mr.getAllergies());
////				}
////			}
////		}
////		return combined;
////	}
//
////	@GetMapping("/firestation")
////	public List<Persons> getPersonsByFirestationNbr(@RequestParam String station) {
////		List<Persons> personnesParStation = new ArrayList<>();
////		return personnesParStation;
////	}
//
//	/****************************************************
//	 * \ METHODES UTILITAIRES * \
//	 ****************************************************/
//
////	public List<String> addressesByStationNumber (String stationNbr) {
////		List<String> adressesParCaserne = new ArrayList<>();
////		for (Firestations fs : DataJson.getFirestations()) {
////			if (fs.getStation().equals(stationNbr))
////				adressesParCaserne.add(fs.getAddress());
////		}
////		return adressesParCaserne;
////	}
//
////	private String getMedicalRecord(String firstName, String lastName) {
////		Set<Object> medRec = new HashSet<>();
//////		Persons p = new Persons();
////		
////		for(MedRecords medRecord: DataJson.getMedicalrecords()) {
////			if (medRecord.getFirstName().equals(firstName)
////					&& medRecord.getLastName().equals(lastName)) {
////				for (Persons p : DataJson.getPersons()) {
////					if(p.getFirstName().equals(firstName)
////						&& p.getLastName().equals(lastName)) {
////							medRec.add(p);
////							medRec.add(medRecord);
////						}
////				}
////			}
////		}
////		return medRec.toString();
////	}
////	public String getBirthDate() {
////		return this.getMedicalRecord().getBirthdate();
////	}
//
////	public int getAge() {
////		
////		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/d/yyyy");
////		LocalDate today = LocalDate.now();
////		LocalDate birthDate = LocalDate.parse(this.getBirthDate(), formatter);
////		Period age = Period.between(birthDate, today);
////		
////		return age.getYears();
////	}
//}
