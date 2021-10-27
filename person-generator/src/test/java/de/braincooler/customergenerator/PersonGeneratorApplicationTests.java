package de.braincooler.customergenerator;

import de.braincooler.persongenerator.generator.PersonGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = PersonGenerator.class)
public class PersonGeneratorApplicationTests {

    @Test
    public void contextLoads() { }
}