package com.cg.onlineplantnursery.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import com.cg.onlineplantnursery.entity.Address;
import com.cg.onlineplantnursery.entity.Customer;
import com.cg.onlineplantnursery.service.ICustomerService;
import com.google.common.base.Verify;

class CustomerServicemock {

	
	
	@Mock
	ICustomerService mockedCustomerService;
	
	
	@BeforeEach
	public void beforeEach() {
		
		MockitoAnnotations.initMocks(this);
		
	}
	
	
	
	
	@Test
	public void test() {
		
		
		Customer x = null;
		
		
		Customer c = new Customer(111, "pavan", "pavan@gmail.com", "pavan@123", "kumar");
		Address a = new Address(120, "2/31", "Narendra", "Pune", "maharastra", 523279);
		a.setCustomer(c);
        c.addAddress(a);
		
        Customer c1 = new Customer(112, "Kumar", "kumar@gmail.com", "kumar@123", "kantu");
		Address a1 = new Address(121, "1/23", "Chandra Nagar", "Andhra Pradesh", "Ongole", 523278);
		a1.setCustomer(c1);
		c1.addAddress(a1);
		
		
		Customer c2 = new Customer(111, "pavan", "kantupavankumar@gmail.com", "pavan@123", "kumar");
		Address a2 = new Address(120, "2/31", "Narendra", "Pune", "maharastra", 523279);
		a2.setCustomer(c2);
        c2.addAddress(a2);
		
		
		List<Customer> list = new ArrayList<>();
		list.add(c);
		list.add(c1);
		
		
		
		
		
		when(mockedCustomerService.addCustomer(Mockito.anyObject())).thenReturn(c);
		when(mockedCustomerService.updateCustomer(Mockito.anyObject())).thenReturn(c2);
		when(mockedCustomerService.deleteCustomer(Mockito.anyObject())).thenReturn(c);
		when(mockedCustomerService.viewCustomer(Mockito.anyInt())).thenReturn(c);
		when(mockedCustomerService.viewAllCustomers()).thenReturn(list);
		when(mockedCustomerService.validateCustomer(Mockito.anyString(), Mockito.anyString())).thenReturn(true);
		
		
		
		
		
		assertEquals("pavan", mockedCustomerService.addCustomer(x).getCustomerName());
		assertEquals("kantupavankumar@gmail.com",mockedCustomerService.updateCustomer(x).getCustomerEmail() );
	     verify(mockedCustomerService).addCustomer(x);
	
		
	}
	
	

}
