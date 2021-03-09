package com.cg.onlineplantnursery.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.onlineplantnursery.entity.Order;
import com.cg.onlineplantnursery.repository.OrderRepositoryImpl;

public class OrderSpec {
	
	OrderRepositoryImpl ordrepimp;
	
	private Order order;
	private Order order1;
	private List<Order> orderList;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
		orderList = new ArrayList<>();
		orderList.add(order);
		orderList.add(order1);
		
		order = new Order((Integer)1, LocalDate.now(), "UPI", 10, 200.0);
		ordrepimp = new OrderRepositoryImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	void addOrderTest() {
		assertEquals(order, ordrepimp.addOrder(order));
	}
	
	@Test
	void updateOrderTest() {
		assertEquals(order, ordrepimp.updateOrder(order));
	}
	
	@Test
	void deleteOrderTest() {
		assertEquals(order, ordrepimp.updateOrder(order));
	}
	
	@Test
	void viewOrderTest() {
		assertEquals(order.getBookingOrderId(), ordrepimp.viewOrder(order.getBookingOrderId()));
	}
	
	@Test
	void viewAllOrdersTest() {
		assertEquals(orderList.size(), ordrepimp.viewAllOrders().size());
	}

}
