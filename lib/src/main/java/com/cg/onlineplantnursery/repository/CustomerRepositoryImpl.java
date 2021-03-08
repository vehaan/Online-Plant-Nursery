package com.cg.onlineplantnursery.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.onlineplantnursery.entity.Customer;

public class CustomerRepositoryImpl implements ICustomerRepository {
	
	EntityManagerFactory factory =  Persistence.createEntityManagerFactory("OnlinePlantNursery");
	EntityManager em  =  factory.createEntityManager();

	@Override
	public Customer addCustomer(Customer customer) {
		em.persist(customer);
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer tenant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer deleteCustomer(Customer tenant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer viewCustomer(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> viewAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validateCustomer(String userName, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
