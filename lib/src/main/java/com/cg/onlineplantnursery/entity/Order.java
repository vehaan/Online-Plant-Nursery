package com.cg.onlineplantnursery.entity;

import java.time.LocalDate;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cg.onlineplantnursery.entity.Planter;
import com.cg.onlineplantnursery.entity.Plant;
import com.cg.onlineplantnursery.entity.Seed;

@Entity
@Table(name = "TestingTableForOrders")
public class Order {
	
	@Id
	private Integer bookingOrderId;
	private LocalDate orderDate;
	private String transactionMode;
	private int quantity; //total quantity, i.e., planter+plant+seed
	private double totalCost; 
	
	@OneToMany(cascade = CascadeType.ALL)
	private Map<Plant, Integer> plants;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Map<Seed, Integer> seeds;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Map<Planter, Integer> planters;
	
	public Order() {
		super();
	}

	public Order(Integer bookingOrderId, LocalDate orderDate, String transactionMode, int quantity, double totalCost,
			Map<Plant, Integer> plants, Map<Seed, Integer> seeds, Map<Planter, Integer> planters) {
		super();
		this.bookingOrderId = bookingOrderId;
		this.orderDate = orderDate;
		this.transactionMode = transactionMode;
		this.quantity = quantity;
		this.totalCost = totalCost;
		this.plants = plants;
		this.seeds = seeds;
		this.planters = planters;
	}

	public Integer getBookingOrderId() {
		return bookingOrderId;
	}

	public void setBookingOrderId(Integer bookingOrderId) {
		this.bookingOrderId = bookingOrderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public String getTransactionMode() {
		return transactionMode;
	}

	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public Map<Plant, Integer> getPlants() {
		return plants;
	}

	public void setPlants(Map<Plant, Integer> plants) {
		this.plants = plants;
	}

	public Map<Seed, Integer> getSeeds() {
		return seeds;
	}

	public void setSeeds(Map<Seed, Integer> seeds) {
		this.seeds = seeds;
	}

	public Map<Planter, Integer> getPlanters() {
		return planters;
	}

	public void setPlanters(Map<Planter, Integer> planters) {
		this.planters = planters;
	}

	@Override
	public String toString() {
		return "Order [bookingOrderId=" + bookingOrderId + ", orderDate=" + orderDate + ", transactionMode="
				+ transactionMode + ", quantity=" + quantity + ", totalCost=" + totalCost + ", plants=" + plants
				+ ", seeds=" + seeds + ", planters=" + planters + "]";
	}
	
}
