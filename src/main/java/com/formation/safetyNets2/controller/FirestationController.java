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

import com.formation.safetyNets2.model.Firestation;
import com.formation.safetyNets2.repository.FirestationCRUDInterface;

@RestController
@RequestMapping("/firestation")
public class FirestationController {
	@Autowired
	FirestationCRUDInterface fs;
	
	@GetMapping
	public List<Firestation> getList() {
		return this.fs.readEntities();
	}
	
	@PostMapping
    public List<Firestation> createStation(@RequestBody Firestation fs) {
		return this.fs.createEntity(fs);
	}
	
	@DeleteMapping
	public void deletePerson(@RequestBody Firestation fs) {
		this.fs.deleteEntity(fs);
	}
	
	@PutMapping
	public void updatePerson(@RequestBody Firestation fs) {
		this.fs.updateEntity(fs);
	}
}