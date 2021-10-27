package de.braincooler.persongenerator.service;

import de.braincooler.persongenerator.entity.AddressEntity;
import de.braincooler.persongenerator.entity.PersonEntity;
import de.braincooler.persongenerator.controller.dto.AddressDto;
import de.braincooler.persongenerator.controller.dto.PersonDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonEntity personDtoToPersonEntity(PersonDto source);

    PersonDto personEntityToDto(PersonEntity source);

    AddressDto addressToDto(AddressEntity source);

    AddressEntity addressToEntity(AddressDto source);
}