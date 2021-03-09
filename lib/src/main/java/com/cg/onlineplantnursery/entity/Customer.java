package com.cg.onlineplantnursery.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity

  @Table(name = "CUSTOMERS",uniqueConstraints = {
  
  @UniqueConstraint(columnNames = "CUSTOMER_ID"),
  
  @UniqueConstraint(columnNames = "USERNAME") })
 


public class Customer {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CUSTOMER_ID",unique = true , nullable = false)
	private Integer customerId;

	@Column(name = "CUSTOMER_NAME",nullable = false)
	private String customerName;

	@Column(name = "CUSTOMER_EMAIL",unique = true)
	private String customerEmail;
    
	@Column(name = "USERNAME",unique = true,nullable = false)
	private String username; // unique
	
	@Column(name = "PASSWORD")
	private String password;

	@OneToMany(mappedBy = "customer",cascade=CascadeType.ALL)
	private List<Address> address = new ArrayList<>();

	public Customer() {
		super();
	}

	public Customer(Integer customerId ,String customerName, String customerEmail, String username, String password) {
		super();
         this.customerId=customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.username = username;
		this.password = password;

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

	public List<Address> getAddress() {
		return Collections.unmodifiableList(address);
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public void addAddress(Address address) {
		this.address.add(address);

	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerEmail="
				+ customerEmail + ", username=" + username + ", password=" + password + ", address=" + address + "]";
	}

}
