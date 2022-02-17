package com.formation.safetyNets2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formation.safetyNets2.model.MedRecord;
import com.formation.safetyNets2.repository.MedRecordCRUDInterface;

@RestController
@RequestMapping("/medicalRecord")
public class MedRecordController {
	@Autowired
	MedRecordCRUDInterface mr;
	
	@GetMapping
	public List<MedRecord> getList() {
		return this.mr.readEntities();
	}
	
	@PostMapping
    public List<MedRecord> createPerson(@RequestBody MedRecord mr) {
		return this.mr.createEntity(mr);
	}
	
	@DeleteMapping
	public void deletePerson(@RequestBody MedRecord mr) {
		this.mr.deleteEntity(mr);
	}
	
	@PutMapping
	public void updatePerson(@RequestBody MedRecord mr) {
		this.mr.updateEntity(mr);
	}
}