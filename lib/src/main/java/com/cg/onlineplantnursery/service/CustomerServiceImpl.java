package com.cg.onlineplantnursery.service;

import java.util.List;

import com.cg.onlineplantnursery.entity.Customer;
import com.cg.onlineplantnursery.repository.CustomerRepositoryImpl;
import com.cg.onlineplantnursery.repository.ICustomerRepository;

public class CustomerServiceImpl implements ICustomerService {

	ICustomerRepository cr = new CustomerRepositoryImpl();

	@Override
	public Customer addCustomer(Customer customer) {
		return cr.addCustomer(customer);
	}

	@Override
	public Customer updateCustomer(Customer tenant) {
		return cr.updateCustomer(tenant);
	}

	@Override
	public Customer deleteCustomer(Customer tenant) {
		return cr.deleteCustomer(tenant);
	}

	@Override
	public Customer viewCustomer(int customerId) {
		return cr.viewCustomer(customerId);
	}

	@Override
	public List<Customer> viewAllCustomers() {
		return cr.viewAllCustomers();
	}

	@Override
	public boolean validateCustomer(String userName, String password) {
		return cr.validateCustomer(userName, password);
	}

}
