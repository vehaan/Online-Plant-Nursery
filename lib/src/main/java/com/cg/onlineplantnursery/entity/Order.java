package com.cg.onlineplantnursery.entity;

import java.time.LocalDate;

import com.cg.onlineplantnursery.entity.Planter;

public class Order {
	private Integer bookingOrderId;
	private LocalDate orderDate;
	private String transactionMode;
	private int quantity;
	private double totalCost;
	private Planter planters;
}
