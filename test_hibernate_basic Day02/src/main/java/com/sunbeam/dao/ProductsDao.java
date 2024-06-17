package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entities.Catagory;
import com.sunbeam.entities.Products;

public interface ProductsDao {
	String addProduct(Products products);
	Products getProductDetailsById(Long productId);
	List<Products> getAllProducts();
	List<Products> getProductPriceRange(double range1, double range2, Catagory cat);
	String ProductDiscount(Catagory cat, double discount);
}
