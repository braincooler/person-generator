package de.braincooler.persongenerator.model;

public class Address {
	
	private Long id;
	private String zipcode;
	private String city;
	private String street;
	private String number;
	
	public String getZipcode() {
		return zipcode;
	}
	
	@Override
	public String toString() {
		return "Address [zipcode=" + zipcode + ", city=" + city + ", street=" + street + ", number=" + number + "]";
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
