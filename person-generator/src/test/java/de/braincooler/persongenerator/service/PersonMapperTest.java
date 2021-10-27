package de.braincooler.persongenerator.service;

import de.braincooler.persongenerator.entity.AddressEntity;
import de.braincooler.persongenerator.entity.PersonEntity;
import de.braincooler.persongenerator.controller.dto.AddressDto;
import de.braincooler.persongenerator.controller.dto.PersonDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonMapperTest {
    private PersonMapper personMapper;

    @BeforeEach
    void setUp() {
        personMapper = new PersonMapperImpl();
    }

    @Test
    void testPersonDtoToPersonEntity() {
        PersonDto dto = getTestPersonDto();
        dto.setAddress(getTestAddressDto());

        PersonEntity result = personMapper.personDtoToPersonEntity(dto);

        assertAll(
                () -> assertEquals(dto.getFirstname(), result.getFirstname()),
                () -> assertEquals(dto.getLastname(), result.getLastname()),
                () -> assertEquals(dto.getId(), result.getId()),
                () -> assertNotNull(result.getAddress())
        );
    }

    @Test
    void testAddressToEntity() {
        AddressDto dto = getTestAddressDto();

        AddressEntity result = personMapper.addressToEntity(dto);

        assertAll(
                () -> assertEquals(dto.getCity(), result.getCity()),
                () -> assertEquals(dto.getStreet(), result.getStreet()),
                () -> assertEquals(dto.getNumber(), result.getNumber()),
                () -> assertEquals(dto.getZipcode(), result.getZipcode()),
                () -> assertEquals(dto.getId(), result.getId())
        );
    }

    private AddressDto getTestAddressDto() {
        AddressDto dto = new AddressDto();
        dto.setCity("Berlin");
        dto.setNumber("13");
        dto.setStreet("Milchstr.");
        dto.setZipcode("12681");
        dto.setId(2L);
        return dto;
    }

    private PersonDto getTestPersonDto() {
        PersonDto dto = new PersonDto();
        dto.setFirstname("firstname");
        dto.setLastname("lastname");
        dto.setId(1L);
        return dto;
    }
}