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
	private String currentAddress;
	private String numberOfDependant;
	private String password;

	public Member() {

	}

	public Member(String uniqueId, String firstName, String lastName, String contactNumber, String currentAddress,
			String numberOfDependant, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.uniqueId = uniqueId;
		this.contactNumber = contactNumber;
		this.currentAddress = currentAddress;
		this.numberOfDependant = numberOfDependant;
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

	@Column(name = "current_address", nullable = false)
	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	@Column(name = "number_of_dependant")
	public String getNumberOfDependant() {
		return numberOfDependant;
	}

	public void setNumberOfDependant(String numberOfDependant) {
		this.numberOfDependant = numberOfDependant;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
