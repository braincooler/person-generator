package de.braincooler.persongenerator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.braincooler.persongenerator.entity.AddressEntity;
import de.braincooler.persongenerator.entity.PersonEntity;
import de.braincooler.persongenerator.generator.PersonGenerator;
import de.braincooler.persongenerator.model.Person;
import de.braincooler.persongenerator.repository.AddressRepository;
import de.braincooler.persongenerator.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired PersonRepository personRepository;
	@Autowired AddressRepository addressRepository;
	@Autowired PersonGenerator personGenerator;

	public Person save(Person person) {
		PersonEntity personEntity = new PersonEntity(person);
		return null;
	}

	public Person createPerson() {
		Person person = personGenerator.createPerson();
		PersonEntity personEntity = new PersonEntity(person);
		AddressEntity addressEntity = new AddressEntity(person.getAddress());
		personEntity.setAddressEntity(addressEntity);
		addressRepository.save(addressEntity);
		personRepository.save(personEntity);
		person.setId(personEntity.getId());
		person.getAddress().setId(addressEntity.getId());
		return person;
	}

	public void deletePerson(Long id) {
		personRepository.deleteById(id);		
	}
}
