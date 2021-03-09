package com.cg.onlineplantnursery.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cg.onlineplantnursery.entity.Order;

public class OrderRepositoryImpl implements IOrderRepository{
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("test1");
	EntityManager em = factory.createEntityManager();
	
	@Override
	public Order addOrder(Order order) {
		
		em.getTransaction().begin();
		em.persist(order);
		em.getTransaction().commit();
		
		System.out.println("The new order added is: "+order.toString());
		
		em.close();
		factory.close();
		return order;
		
	}
	
	
	@Override
	public Order updateOrder(Order order) {
		
		Order ord = em.find(Order.class, order.getBookingOrderId());
		em.getTransaction().begin();
		ord.setQuantity(10);  // Need to make some more changes 
		em.getTransaction().commit();
		
		System.out.println("The order with order id : "+order.getBookingOrderId()+" is updated");
		
		em.close();
		factory.close();
		return ord;
		
	}
	
	@Override
	public Order deleteOrder(int orderId) /*throws OrderIdNotFoundException*/{
		
		Order ord = em.find(Order.class, orderId);
		em.getTransaction().begin();
		em.remove(orderId);
		em.getTransaction().commit();
		
		System.out.println("Order with orderId "+orderId+" is deleted");
		
		em.close();
		factory.close();
		return ord;
	}
	
	@Override
	public Order viewOrder(int orderId) /*throws OrderIdNotFoundException*/{
		
		Order ord = em.find(Order.class, orderId);
		System.out.println("Order with order id "+orderId+" is displayed");
		
		return ord;
	}
	
	@Override
	public List<Order> viewAllOrders() {
		
		/*
		 * em.getTransaction().begin(); List<Order> list = (List<Order>)
		 * em.getEntityManagerFactory(); em.getTransaction().commit();
		 * 
		 * System.out.println("List of orders is :"+list);
		 * 
		 * em.close(); factory.close();
		 */
		
		Query q = em.createQuery("select ord from Order ord");
		List<Order> orderslist = q.getResultList();
		return orderslist;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		em.close();
	}
	
	
	
}
