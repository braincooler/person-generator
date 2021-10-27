package de.braincooler.persongenerator.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import de.braincooler.persongenerator.model.AddressDto;

@Entity
@Table(name = "address")
public class AddressEntity {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String street;
	private String number;
	private String zipcode;
	private String city;
	
	public AddressEntity() {	}

	public AddressEntity(AddressDto address) {
		this.street = address.getStreet();
		this.number = address.getNumber();
		this.zipcode = address.getZipcode();
		this.city = address.getCity();
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
