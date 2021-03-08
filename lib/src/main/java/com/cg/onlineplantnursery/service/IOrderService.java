package com.cg.onlineplantnursery.service;

import java.util.List;

import com.cg.onlineplantnursery.entity.Order;

public interface IOrderService {
	Order addOrder(Order order);
	
	Order updateOrder(Order order);
	
	Order deleteOrder(int orderId);
	
	Order viewOrder(int  orderId);
	
	List<Order> viewAllOrders();
}
