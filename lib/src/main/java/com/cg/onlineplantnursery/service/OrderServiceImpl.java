package com.cg.onlineplantnursery.service;

import java.util.List;

import com.cg.onlineplantnursery.entity.Order;
import com.cg.onlineplantnursery.repository.IOrderRepository;
import com.cg.onlineplantnursery.repository.OrderRepositoryImpl;

public class OrderServiceImpl implements IOrderService{

	IOrderRepository ordrepimp = new OrderRepositoryImpl();
	
	@Override
	public Order addOrder(Order order) {
		return ordrepimp.addOrder(order);
	}

	@Override
	public Order updateOrder(Order order) {
		return ordrepimp.updateOrder(order);
	}

	@Override
	public Order deleteOrder(int orderId) {
		return ordrepimp.deleteOrder(orderId);
	}

	@Override
	public Order viewOrder(int orderId) {
		return ordrepimp.viewOrder(orderId);
	}

	@Override
	public List<Order> viewAllOrders() {
		return ordrepimp.viewAllOrders();
	}

}
