package com.cg.onlineplantnursery.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMERS")

public class Customer {

	@Id
	@Column(name = "CUSTOMER_ID")
	private Integer customerId;

	@Column(name = "CUSTOMER_NAME")
	private String customerName;
	
	@Column(name = "CUSTOMER_EMAIL")
	private String customerEmail;
	
	private String username;
	private String password;
	private Address address;

	public Customer() {
		super();
	}

	public Customer(Integer customerId, String customerName, String customerEmail, String username, String password,
			Address address) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.username = username;
		this.password = password;
		this.address = address;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerEmail="
				+ customerEmail + ", username=" + username + ", password=" + password + ", address=" + address + "]";
	}

}
