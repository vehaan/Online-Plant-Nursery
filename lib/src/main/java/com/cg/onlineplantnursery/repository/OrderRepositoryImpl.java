package com.cg.onlineplantnursery.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cg.onlineplantnursery.entity.Order;
import com.cg.onlineplantnursery.entity.Plant;
import com.cg.onlineplantnursery.entity.Planter;
import com.cg.onlineplantnursery.entity.Seed;

public class OrderRepositoryImpl implements IOrderRepository {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("test1");
	EntityManager em = factory.createEntityManager();
	
	@Override
	public Order addOrder(Order order) {
		em.getTransaction().begin();
		em.persist(order);
		em.getTransaction().commit();
		
		HashMap<Planter, Integer> pr = (HashMap<Planter, Integer>) order.getPlanters();
		Integer prquantity = pr.entrySet().stream().findFirst().get().getValue(); //Ordered quantity of planters 
		Integer prstock = pr.entrySet().stream().findFirst().get().getKey().getPlanterStock(); //Updating the quantity of planters
		prstock -= prquantity;
		
		HashMap<Plant, Integer> p = (HashMap<Plant, Integer>) order.getPlants();
		Integer pquantity = p.entrySet().stream().findFirst().get().getValue(); //Ordered quantity of plants 
		Integer pstock = p.entrySet().stream().findFirst().get().getKey().getPlantsStock(); //Updating the quantity of plants
		pstock -= pquantity;
		 
		HashMap<Seed, Integer> s = (HashMap<Seed, Integer>) order.getSeeds();
		Integer squantity = s.entrySet().stream().findFirst().get().getValue(); //Ordered quantity of seeds 
		Integer sstock = s.entrySet().stream().findFirst().get().getKey().getSeedsStock(); //Updating the quantity of seeds
		sstock -= squantity;
		
		System.out.println("The new order added is: "+order.toString());
		
		return order;
	}

	@Override
	public Order updateOrder(Order order) {
		Order ord = em.find(Order.class, order.getBookingOrderId());
		em.getTransaction().begin();
		ord.setTransactionMode("Cash");  //Need to make some more changes, Hard coded for now 
		em.getTransaction().commit();
		
		System.out.println("The order with order id : "+order.getBookingOrderId()+" is updated");
		
		return ord;	
	}
	
	@Override
	public Order deleteOrder(int orderId) /*throws OrderIdNotFoundException*/{
		Order order = em.find(Order.class, orderId);
		em.getTransaction().begin();
		em.remove(order);
		em.getTransaction().commit();
		
		HashMap<Planter, Integer> pr = (HashMap<Planter, Integer>) order.getPlanters();
		Integer prquantity = pr.entrySet().stream().findFirst().get().getValue(); //Ordered quantity of planters 
		Integer prstock = pr.entrySet().stream().findFirst().get().getKey().getPlanterStock(); //Updating the quantity of planters
		prstock += prquantity;
		
		HashMap<Plant, Integer> p = (HashMap<Plant, Integer>) order.getPlants();
		Integer pquantity = p.entrySet().stream().findFirst().get().getValue(); //Ordered quantity of plants 
		Integer pstock = p.entrySet().stream().findFirst().get().getKey().getPlantsStock(); //Updating the quantity of plants
		pstock += pquantity;
		 
		HashMap<Seed, Integer> s = (HashMap<Seed, Integer>) order.getSeeds();
		Integer squantity = s.entrySet().stream().findFirst().get().getValue(); //Ordered quantity of seeds 
		Integer sstock = s.entrySet().stream().findFirst().get().getKey().getSeedsStock(); //Updating the quantity of seeds
		sstock += squantity;
		
		System.out.println("Order with orderId "+orderId+" is deleted");
		
		return order;
	}
	
	@Override
	public Order viewOrder(int orderId) /*throws OrderIdNotFoundException*/{
		Order ord = em.find(Order.class, orderId);
		System.out.println("Order with order id "+orderId+" is displayed");
		
		return ord;
	}
	
	@Override
	public List<Order> viewAllOrders() {
		Query q = em.createQuery("select ord from TestingTableForOrders ord");
		List<Order> orderslist = q.getResultList();
		return orderslist;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		em.close();
		factory.close();
	}
	
	
}