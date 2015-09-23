package com.xmdevelopments.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "users_id")
	private Integer ID;

	@Column(name = "users_username")
	private String username;

	@Column(name = "users_firstname")
	private String firstName;

	@Column(name = "users_lastname")
	private String lastName;

	@Column(name = "users_email")
	private String email;

	@Column(name = "users_password")
	@JsonIgnore
	private String password;

	@Column(name = "users_group")
	private int groupId;

	@Column(name = "users_deleted", columnDefinition = "BIT", length = 1)
	private boolean isDeleted;

	@Column(name = "users_approved", columnDefinition = "BIT", length = 1)
	private boolean isApproved;

	@Column(name = "users_b2b", columnDefinition = "BIT", length = 1)
	private boolean isB2b;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public boolean isB2b() {
		return isB2b;
	}

	public void setB2b(boolean isB2b) {
		this.isB2b = isB2b;
	}

	
	
	
}
