package de.braincooler.persongenerator.generator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import de.braincooler.persongenerator.model.Address;
import de.braincooler.persongenerator.model.Person;

@Component
public class PersonGenerator {

	@Value("classpath:files/nachnamen.txt")
	private Resource lastnameResource;

	@Value("classpath:files/plz-ort.txt")
	private Resource locationResource;

	@Value("classpath:files/vornamen_frau.txt")
	private Resource womanFirstnameResource;

	@Value("classpath:files/vornamen_mann.txt")
	private Resource manFirstnameResource;

	@Value("classpath:files/strassen.txt")
	private Resource streetResource;

	private static final SecureRandom RANDOM = new SecureRandom();
	private static final Logger LOGGER = LoggerFactory.getLogger(PersonGenerator.class);
	private static final int MAX_HOUSE_NUMBER = 100;

	public Person createPerson() {
		try {
			FileInputStream stream = new FileInputStream(ClassLoader.getSystemResource("files/strassen.txt").getPath());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
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

	private String getRandomLine(Resource resource) {
		String result = "";
		try {
			String path = ClassLoader.getSystemResource("files/strassen.txt").getPath();
			LOGGER.error(path);
			//int lineCount = Math.toIntExact(Files.lines(path).count());
			// result = Files.lines(path).skip(RANDOM.nextInt(lineCount)).findFirst().get();
		} catch (Exception e) {
			LOGGER.error("Error on read file", e);
		}
		return result;
	}
}
