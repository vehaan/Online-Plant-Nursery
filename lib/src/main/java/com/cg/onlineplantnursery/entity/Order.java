package com.cg.onlineplantnursery.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cg.onlineplantnursery.entity.Planter;

@Entity
@Table(name = "Orders")
public class Order {
	
	@Id
	private Integer bookingOrderId;
	private LocalDate orderDate;
	private String transactionMode;
	private int quantity;
	private double totalCost;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Planter> planters;
	
	public Order() {
		super();
	}

	public Order(Integer bookingOrderId, LocalDate orderDate, String transactionMode, int quantity, double totalCost,
			List<Planter> planters) {
		super();
		this.bookingOrderId = bookingOrderId;
		this.orderDate = orderDate;
		this.transactionMode = transactionMode;
		this.quantity = quantity;
		this.totalCost = totalCost;
		this.planters = planters;
	}
	
	//Extra constructor just for testing purpose....After merging remove this
	public Order(Integer bookingOrderId, LocalDate orderDate, String transactionMode, int quantity, double totalCost) {
		super();
		this.bookingOrderId = bookingOrderId;
		this.orderDate = orderDate;
		this.transactionMode = transactionMode;
		this.quantity = quantity;
		this.totalCost = totalCost;
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

	public List<Planter> getPlanters() {
		return planters;
	}

	public void setPlanters(List<Planter> planters) {
		this.planters = planters;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookingOrderId == null) ? 0 : bookingOrderId.hashCode());
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + ((planters == null) ? 0 : planters.hashCode());
		result = prime * result + quantity;
		long temp;
		temp = Double.doubleToLongBits(totalCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((transactionMode == null) ? 0 : transactionMode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (bookingOrderId == null) {
			if (other.bookingOrderId != null)
				return false;
		} else if (!bookingOrderId.equals(other.bookingOrderId))
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (planters == null) {
			if (other.planters != null)
				return false;
		} else if (!planters.equals(other.planters))
			return false;
		if (quantity != other.quantity)
			return false;
		if (Double.doubleToLongBits(totalCost) != Double.doubleToLongBits(other.totalCost))
			return false;
		if (transactionMode == null) {
			if (other.transactionMode != null)
				return false;
		} else if (!transactionMode.equals(other.transactionMode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [bookingOrderId=" + bookingOrderId + ", orderDate=" + orderDate + ", transactionMode="
				+ transactionMode + ", quantity=" + quantity + ", totalCost=" + totalCost + ", planters=" + planters
				+ "]";
	}

	
	
	
}
