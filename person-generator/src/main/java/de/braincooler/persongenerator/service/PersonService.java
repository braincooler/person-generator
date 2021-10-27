package de.braincooler.persongenerator.service;

import de.braincooler.persongenerator.model.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.braincooler.persongenerator.entity.AddressEntity;
import de.braincooler.persongenerator.entity.PersonEntity;
import de.braincooler.persongenerator.generator.PersonGenerator;
import de.braincooler.persongenerator.repository.AddressRepository;
import de.braincooler.persongenerator.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private PersonGenerator personGenerator;

	public PersonDto save(PersonDto personDto) {
		PersonEntity personEntity = new PersonEntity(personDto);
		return null;
	}

	public PersonDto createPerson() {
		PersonDto personDto = personGenerator.createPerson();
		PersonEntity personEntity = new PersonEntity(personDto);
		AddressEntity addressEntity = new AddressEntity(personDto.getAddress());
		personEntity.setAddressEntity(addressEntity);
		addressRepository.save(addressEntity);
		personRepository.save(personEntity);
		personDto.setId(personEntity.getId());
		personDto.getAddress().setId(addressEntity.getId());
		return personDto;
	}

	public void deletePerson(Long id) {
		personRepository.deleteById(id);		
	}
}
