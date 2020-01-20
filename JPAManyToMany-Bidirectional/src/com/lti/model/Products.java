package com.lti.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Products {
	@Id
	@Column(name="product_id")
	private int productId;
	@Column(name="product_name")
	private String productName;
	@Column(name="product_price")
	private double productPrice;
	
	@ManyToMany(mappedBy="products")
	private List<Orders> orders;
	
	public Products() {
		super();
		
	}

	public Products(int productId, String productName, double productPrice, List<Orders> orders) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.orders = orders;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Products [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", orders=" + orders + "]";
	}
	
	
	
}
