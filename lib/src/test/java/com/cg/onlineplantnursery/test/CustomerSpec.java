package com.cg.onlineplantnursery.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.cg.onlineplantnursery.entity.Address;
import com.cg.onlineplantnursery.entity.Customer;
import com.cg.onlineplantnursery.repository.CustomerRepositoryImpl;
import com.cg.onlineplantnursery.repository.ICustomerRepository;

@TestMethodOrder(OrderAnnotation.class)
class CustomerSpec {

	private ICustomerRepository repo;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {

		repo = new CustomerRepositoryImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@Order(1)
	void addCustomerTest() {

		Customer c = new Customer(111,"pavan", "pavan@gmail.com", "pavan@123", "kumar");
		Address a = new Address(120,"2/31", "Narendra", "Pune", "maharastra", 523279);
		a.setCustomer(c);

		Address a1 = new Address(121,"2-12", "Ramaji", "ongole", "Andhra", 533278);
		a1.setCustomer(c);

		c.addAddress(a);
		c.addAddress(a1);

		Customer c1 = repo.addCustomer(c);

		assertEquals(c.getCustomerName(), c1.getCustomerName());

	}

	@Test
	@Order(2)
	void updateCustomerTest() {

		Customer c = new Customer(111, "pavan", "pavan@gmail.com", "pavan@123", "kumar");

		Address a = new Address(120, "2/31", "Narendra", "Pune", "maharastra", 523279);
		a.setCustomer(c);

		Customer c1 = repo.updateCustomer(c);

		Customer afterUpdate = new Customer(111, "pavan", "kantupavankumar@gmail.com", "pavan@123", "kumar");

		assertEquals(afterUpdate.getCustomerEmail(), c1.getCustomerEmail());

	}

	@Test
	@Order(3)
	void deleteCustomerTest() {

		Customer afterUpdate = new Customer(111, "pavan", "kantupavankumar@gmail.com", "pavan@123", "kumar");

		Address a = new Address(120, "2/31", "Narendra", "Pune", "maharastra", 523279);
		a.setCustomer(afterUpdate);

		Customer deleteCustomer = repo.deleteCustomer(afterUpdate);

		assertEquals(afterUpdate.getCustomerId(), deleteCustomer.getCustomerId());

	}

	@Test
	@Order(4)
	void viewCustomerTest() {

		Customer c = new Customer(111, "pavan", "pavan@gmail.com", "pavan@123", "kumar");
		Address a = new Address(120, "2/31", "Narendra", "Pune", "maharastra", 523279);
		a.setCustomer(c);
		c.addAddress(a);

		Customer c1 = new Customer(112, "Kumar", "kumar@gmail.com", "kumar@123", "kantu");
		Address a1 = new Address(121, "1/23", "Chandra Nagar", "Andhra Pradesh", "Ongole", 523278);
		a1.setCustomer(c1);
		c1.addAddress(a1);

		Customer addCustomer = repo.addCustomer(c);
		Customer addCustomer2 = repo.addCustomer(c1);
		Customer updateCustomer = repo.updateCustomer(c);

		Customer viewCustomer = repo.viewCustomer(c.getCustomerId());

		assertEquals(addCustomer.getCustomerName(), viewCustomer.getCustomerName());

	}

	@Test
	@Order(5)
	void viewAllCustomersTest() {
		Customer c = new Customer(111, "pavan", "kantupavankumar@gmail.com", "pavan@123", "kumar");
		Address a = new Address(120, "2/31", "Narendra", "Pune", "maharastra", 523279);
		a.setCustomer(c);
		c.addAddress(a);

		Customer c1 = new Customer(112, "Kumar", "kumar@gmail.com", "kumar@123", "kantu");
		Address a1 = new Address(121, "1/23", "Chandra Nagar", "Andhra Pradesh", "Ongole", 523278);
		a1.setCustomer(c1);
		c1.addAddress(a1);

		List<Customer> list = new ArrayList<>();
		list.add(c);
		list.add(c1);

		List<Customer> viewAllCustomers = repo.viewAllCustomers();

		assertEquals(list.size(), viewAllCustomers.size());

	}

	@Test
	@Order(6)
	void validateCustomerTest() {

		String userName = "pavan@123";
		String password = "kumar";

		boolean validateCustomer = repo.validateCustomer(userName, password);

		assertEquals(true, validateCustomer);
	}

}
