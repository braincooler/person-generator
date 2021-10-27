package de.braincooler.persongenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import de.braincooler.persongenerator.model.PersonDto;
import de.braincooler.persongenerator.service.PersonService;

@Controller
@RequestMapping(value = "persons")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping(value = "person", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createPerson(){
		PersonDto personDto = personService.createPerson();
		return ResponseEntity.ok(personDto);
	}

	
	@DeleteMapping(value = "person/{id}")
	public ResponseEntity<?> deletePerson(@PathVariable Long id){
		personService.deletePerson(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
