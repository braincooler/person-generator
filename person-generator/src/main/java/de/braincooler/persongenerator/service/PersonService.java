package de.braincooler.persongenerator.service;

import de.braincooler.persongenerator.controller.dto.PersonDto;
import de.braincooler.persongenerator.entity.PersonEntity;
import de.braincooler.persongenerator.generator.PersonGenerator;
import de.braincooler.persongenerator.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;
    private final PersonGenerator personGenerator;
    private final PersonMapper personMapper;

    public PersonDto createPerson() {
        PersonDto personDto = personGenerator.createPerson();
        PersonEntity personEntity = personMapper.personDtoToPersonEntity(personDto);
        PersonEntity result = personRepository.save(personEntity);

        return personMapper.personEntityToDto(result);
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    public List<PersonDto> getPersons() {
        return personRepository.findAll().stream()
                .map(personMapper::personEntityToDto)
                .collect(Collectors.toList());
    }
}
