package de.braincooler.persongenerator.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import de.braincooler.persongenerator.model.Person;


@Entity
@Table (name = "person")
public class PersonEntity {
	
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstname;
	private String lastname;
	
	@ManyToOne @JoinColumn (name = "address")
	private AddressEntity address;
	
	public PersonEntity() {
	}

	public PersonEntity(Person person) {
		this.firstname = person.getFirstname();
		this.lastname = person.getLastname();
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddressEntity(AddressEntity address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "PersonEntity [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", address=" + address
				+ "]";
	}
}
