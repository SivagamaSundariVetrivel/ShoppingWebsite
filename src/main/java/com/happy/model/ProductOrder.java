package com.happy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ProductOrder {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int orderNo;
    private int orderId;
    
    @OneToOne
    @JoinColumn(name="pid")
    private Product product;
    
    private int quantity;

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ProductOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductOrder(int orderId, Product product, int quantity) {
		super();
		this.orderId = orderId;
		this.product = product;
		this.quantity = quantity;
	}
}
