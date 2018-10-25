package de.braincooler.persongenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import de.braincooler.persongenerator.model.Person;
import de.braincooler.persongenerator.service.PersonService;

@Controller
@RequestMapping(value = "persons")
public class PersonController {
	
	@Autowired private PersonService personService;
	
	@GetMapping(value = "person", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createPerson(){
		Person person = personService.createPerson();
		return ResponseEntity.ok(person);
	}
	
//	@PostMapping(value = "person", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<?> savePerson(@RequestBody Person person){
//		Person savedPerson = personService.save(person);
//		return ResponseEntity.status(HttpStatus.CREATED).body(savedPerson);
//	}
	
	@DeleteMapping(value = "person/{id}")
	public ResponseEntity<?> deletePerson(@PathVariable Long id){
		personService.deletePerson(id);
		return ResponseEntity.ok(null);
	}
}
