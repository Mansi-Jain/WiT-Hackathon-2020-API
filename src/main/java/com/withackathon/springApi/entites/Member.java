package com.withackathon.springApi.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "member_information")
public class Member {

	private String uniqueId;
	private String firstName;
	private String lastName;
	private String contactNumber;
	private String address;
	private String numberOfDependants;
	private String password;

	public Member() {

	}

	public Member(String uniqueId, String firstName, String lastName, String contactNumber, String address,
			String numberOfDependants, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.uniqueId = uniqueId;
		this.contactNumber = contactNumber;
		this.address = address;
		this.numberOfDependants = numberOfDependants;
		this.password = password;

	}

	@Id
	@Column(name = "unique_id", nullable = false)
	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	@Column(name = "first_name", nullable = false)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", nullable = false)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "contact_number", nullable = false)
	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Column(name = "address", nullable = false)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "number_of_dependants")
	public String getNumberOfDependants() {
		return numberOfDependants;
	}

	public void setNumberOfDependants(String numberOfDependants) {
		this.numberOfDependants = numberOfDependants;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
