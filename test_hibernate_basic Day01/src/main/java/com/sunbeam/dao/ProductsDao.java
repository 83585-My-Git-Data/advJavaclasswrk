package com.sunbeam.dao;

import com.sunbeam.entities.Products;

public interface ProductsDao {
	String addProduct(Products products);
	Products getProductDetailsById(Long productId);
}
