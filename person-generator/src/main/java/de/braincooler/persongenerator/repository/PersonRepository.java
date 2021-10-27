package de.braincooler.persongenerator.repository;

import de.braincooler.persongenerator.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> { }