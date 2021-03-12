package com.cg.onlineplantnursery.service;

import java.util.List;

import com.cg.onlineplantnursery.entity.Customer;
import com.cg.onlineplantnursery.repository.CustomerRepositoryImpl;
import com.cg.onlineplantnursery.repository.ICustomerRepository;

public class CustomerServiceImpl implements ICustomerService {

	//ICustomerRepository cr = new CustomerRepositoryImpl();

	@Override
	public Customer addCustomer(Customer customer) {
		return null;
	}

	@Override
	public Customer updateCustomer(Customer tenant) {
		return null;
	}

	@Override
	public Customer deleteCustomer(Customer tenant) {
		return null;
	}

	@Override
	public Customer viewCustomer(int customerId) {
		return null;
	}

	@Override
	public List<Customer> viewAllCustomers() {
		return null;
	}

	@Override
	public boolean validateCustomer(String userName, String password) {
		return false;
	}

}
