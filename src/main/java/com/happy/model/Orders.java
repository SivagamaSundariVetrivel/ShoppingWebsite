package com.happy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderId;
	private double totalPrice;
	private String userName;
	
	@OneToOne
	@JoinColumn(name="shippingAddressId")
	private ShippingAddress deliveryAddress;
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public ShippingAddress getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(ShippingAddress deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public Orders(double totalPrice, String userName, ShippingAddress deliveryAddress) {
		super();
		this.totalPrice = totalPrice;
		this.userName = userName;
		this.deliveryAddress = deliveryAddress;
	}

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
