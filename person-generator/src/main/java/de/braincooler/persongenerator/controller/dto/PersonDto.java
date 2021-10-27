package de.braincooler.persongenerator.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PersonDto {
	private Long id;
	private String firstname;
	private String lastname;
	private AddressDto address;
}