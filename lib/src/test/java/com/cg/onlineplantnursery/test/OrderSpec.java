package com.cg.onlineplantnursery.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.runners.MethodSorters;

import com.cg.onlineplantnursery.entity.Order;
import com.cg.onlineplantnursery.entity.Plant;
import com.cg.onlineplantnursery.entity.Planter;
import com.cg.onlineplantnursery.entity.Seed;
import com.cg.onlineplantnursery.repository.OrderRepositoryImpl;

@TestMethodOrder(OrderAnnotation.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
		
		Plant p = new Plant(3,8,"fast","Lemon","summer","for lemons","easy","hot","shrub","fruit-plant",50/*stock*/,10.0);
		Map<Plant, Integer> pmap = new HashMap<>();
		pmap.put(p, 10);
		
		Seed s = new Seed(14,"Rose","5 days","Easy","Medium","20 degree celcius","Flower","For Rose",50/*stock*/,2,4);
		Map<Seed, Integer> smap = new HashMap<>();
		smap.put(s, 20);
		
		Planter pr = new Planter((Integer) 1,34.50f,500,2,"Red","Circle",300/*stock*/,2000); 
		Map<Planter, Integer> prmap = new HashMap<>();
		prmap.put(pr, 5);
		
		order = new Order(1, LocalDate.now(), "UPI", 35, 200.0, pmap, smap, prmap);
		order1 = new Order(1, LocalDate.now(), "UPI", 35, 200.0, pmap, smap, prmap);
		
		orderList = new ArrayList<>();
		orderList.add(order);
		orderList.add(order1);
		
		ordrepimp = new OrderRepositoryImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	//@Order(1)
	void addOrderTest() {
		assertEquals(order, ordrepimp.addOrder(order));
	}
	
	@Test
	//@Order(2)
	void b_updateOrderTest() {
		assertEquals(order, ordrepimp.updateOrder(order));
	}
	
	@Test
	//@Order(5)
	void e_deleteOrderTest() {
		assertEquals(order, ordrepimp.updateOrder(order));
	}
	
	@Test
	//@Order(3)
	void c_viewOrderTest() {
		assertEquals(order.getBookingOrderId(), ordrepimp.viewOrder(order.getBookingOrderId()));
	}
	
	@Test
	//@Order(4)
	void d_viewAllOrdersTest() {
		assertEquals(orderList.size(), ordrepimp.viewAllOrders().size());
	}

}
