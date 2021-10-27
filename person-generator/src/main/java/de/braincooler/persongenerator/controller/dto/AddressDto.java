package de.braincooler.persongenerator.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AddressDto {
	private Long id;
	private String zipcode;
	private String city;
	private String street;
	private String number;
}