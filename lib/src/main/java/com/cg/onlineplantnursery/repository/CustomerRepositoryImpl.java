package com.cg.onlineplantnursery.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cg.onlineplantnursery.entity.Customer;

public class CustomerRepositoryImpl implements ICustomerRepository {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("OnlinePlantNursery");
	EntityManager em = factory.createEntityManager();

	@Override
	public Customer addCustomer(Customer customer) {
		em.getTransaction().begin();
		em.persist(customer);
		em.getTransaction().commit();
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer tenant) {

		Customer updateC = em.find(Customer.class, tenant.getCustomerId());
		em.getTransaction().begin();

		updateC.setCustomerEmail("kantupavankumar@gmail.com");

		em.getTransaction().commit();

		return updateC;
	}

	@Override
	public Customer deleteCustomer(Customer tenant) {
		Customer toBeDeleted = em.find(Customer.class, tenant.getCustomerId());
		em.getTransaction().begin();

		em.remove(toBeDeleted);

		em.getTransaction().commit();

		return toBeDeleted;
	}

	@Override
	public Customer viewCustomer(int customerId) {

		em.getTransaction().begin();
		Customer find = em.find(Customer.class, customerId);
		em.getTransaction().commit();

		return find;
	}

	@Override
	public List<Customer> viewAllCustomers() {
		em.getTransaction().begin();
		Query createNamedQuery = em.createQuery("select c from Customer c");

		List<Customer> res = new ArrayList<>();

		res = createNamedQuery.getResultList();
		em.getTransaction().commit();

		return res;
	}

	@Override
	public boolean validateCustomer(String userName, String password) {

		Query createQuery = em.createQuery("select c from Customer c");

		List<Customer> res = new ArrayList<>();
		res = createQuery.getResultList();

		for (Customer customer : res) {

			if (customer.getUsername().equals(userName)) {

				if (customer.getPassword().equals(password)) {
					return true;
				}

			}

		}

		return false;

	}

}
