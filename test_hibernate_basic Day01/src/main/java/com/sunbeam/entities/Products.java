package com.sunbeam.entities;

import javax.persistence.*;


@Entity

@Table(name="products")

public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="product_name", length=35)
	private String productName;
	private double price;
	@Column(name="avl_quantity")
	private int availableQuantity;
	@Enumerated(EnumType.STRING)
	@Column(length=45)
	private Catagory catagory;
	
	
	
	public Products() {
		
	}



	public Products( String productName, double price, int availableQuantity, Catagory catagory) {
		super();
		
		this.productName = productName;
		this.price = price;
		this.availableQuantity = availableQuantity;
		this.catagory = catagory;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public int getAvailableQuantity() {
		return availableQuantity;
	}



	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}



	public Catagory getCatagory() {
		return catagory;
	}



	public void setCatagory(Catagory catagory) {
		this.catagory = catagory;
	}



	@Override
	public String toString() {
		return "Products [productName=" + productName + ", price=" + price + ", availableQuantity=" + availableQuantity
				+ ", catagory=" + catagory + "]";
	}
	
}
