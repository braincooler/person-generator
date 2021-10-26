package de.braincooler.persongenerator.generator;

import de.braincooler.persongenerator.model.Address;
import de.braincooler.persongenerator.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class PersonGenerator {

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

    private static final SecureRandom RANDOM = new SecureRandom();
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonGenerator.class);
    private static final int MAX_HOUSE_NUMBER = 100;

    public Person createPerson() {

        Person person = new Person();
        Address address = new Address();
        int houseNumber = (int) (Math.random() * (MAX_HOUSE_NUMBER - 1)) + 1;
        address.setNumber(String.valueOf(houseNumber));
        String cityAndZip = getRandomLine(locationResource);
        String cityAndZipArray[] = cityAndZip.split(" ");
        address.setZipcode(cityAndZipArray[0]);
        address.setCity(cityAndZipArray[1]);
        address.setStreet(getRandomLine(streetResource));
        person.setFirstname(getRandomLine(lastnameResource));
        // 50/50 male or female
        if (RANDOM.nextInt(1) == 1)
            person.setLastname(getRandomLine(manFirstnameResource));
        else
            person.setLastname(getRandomLine(womanFirstnameResource));
        person.setAddress(address);
        return person;
    }

    private String getRandomLine(String resource) {
        String result = "x x";
        try {
            String path1 = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath()  + "files/gegenstaende.txt";

            Path path = Paths.get(path1.substring(1));
            LOGGER.error("path: {}", path);

            Stream<String> lines = Files.lines(path);
            String data = lines.collect(Collectors.joining("\n"));
            lines.close();
            LOGGER.error(data);
        } catch (Exception e) {
            LOGGER.error("Error on read file", e);
        }
        return result;
    }
}
