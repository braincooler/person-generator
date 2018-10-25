package de.braincooler.persongenerator.model;

public class Person {
	
	private Long id;
	private String firstname;
	private String lastname;
	private Address address;
	
	public Person() {
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Customer [name=" + firstname + ", lastname=" + lastname + ", address=" + address + "]";
	}
}
