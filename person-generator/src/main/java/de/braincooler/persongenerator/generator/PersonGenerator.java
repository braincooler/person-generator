package de.braincooler.persongenerator.generator;

import de.braincooler.persongenerator.controller.dto.AddressDto;
import de.braincooler.persongenerator.controller.dto.PersonDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.SecureRandom;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class PersonGenerator {
    private static final SecureRandom RANDOM = new SecureRandom();
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonGenerator.class);
    private static final int MAX_HOUSE_NUMBER = 100;

    @Value("files/nachnamen.txt")
    private String lastnameResource;

    @Value("files/plz-ort.txt")
    private String locationResource;

    @Value("files/vornamen_frau.txt")
    private String womanFirstnameResource;

    @Value("files/vornamen_mann.txt")
    private String manFirstnameResource;

    @Value("files/strassen.txt")
    private String streetResource;

    public PersonDto createPerson() {
        PersonDto personDto = new PersonDto();
        personDto.setFirstname(getRandomLine(lastnameResource));
        personDto.setLastname(RANDOM.nextBoolean() ?
                getRandomLine(manFirstnameResource) :
                getRandomLine(womanFirstnameResource));
        personDto.setAddress(createAddress());

        return personDto;
    }

    private AddressDto createAddress() {
        AddressDto address = new AddressDto();
        int houseNumber = (int) (Math.random() * (MAX_HOUSE_NUMBER - 1)) + 1;
        address.setNumber(String.valueOf(houseNumber));
        String cityAndZip = getRandomLine(locationResource);
        String[] cityAndZipArray = cityAndZip.split(" ");
        address.setZipcode(cityAndZipArray[0]);
        address.setCity(cityAndZipArray[1]);
        address.setStreet(getRandomLine(streetResource));
        return address;
    }

    private String getRandomLine(String resource) {
        String result = "";
        try {
            ClassLoader cl = this.getClass().getClassLoader();
            InputStream in = cl.getResourceAsStream(resource);
            BufferedReader br = new BufferedReader(new InputStreamReader(Objects.requireNonNull(in)));
            List<String> lines = br.lines()
                    .collect(Collectors.toList());
            result = lines.get(RANDOM.nextInt(lines.size()));
        } catch (Exception e) {
            LOGGER.error("Error on read file", e);
        }
        return result;
    }
}