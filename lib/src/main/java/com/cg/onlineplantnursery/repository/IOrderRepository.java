package com.cg.onlineplantnursery.repository;

import java.util.List;

import com.cg.onlineplantnursery.entity.Order;

public interface IOrderRepository {
	
	//Is my comment added?
	Order addOrder(Order order);
	
	Order updateOrder(Order order);
	
	Order deleteOrder(int orderId);
	
	Order viewOrder(int  orderId);
	
	List<Order> viewAllOrders();
	
}
