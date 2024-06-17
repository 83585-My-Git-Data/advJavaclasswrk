package com.sunbeam.dao;

import java.io.Serializable;

import org.hibernate.*;


import com.sunbeam.entities.Products;
import com.sunbeam.util.HibernateUtil;

public class ProductsDaoImpl implements ProductsDao {

	@Override
	public String addProduct(Products products) {
		String mesg = "Addition Product into Cart is Failed !!! ";
		
		Session session = HibernateUtil.getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Serializable productId = session.save(products);
			tx.commit();
			mesg="Product adeed Successfully, with ID"+productId;
		}catch(RuntimeException e) {
			if(tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return mesg;
	}

	@Override
	public Products getProductDetailsById(Long productId) {
		Products products = null;
		Session session = HibernateUtil.getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			products = session.get(Products.class, productId);
			tx.commit();
		} catch(RuntimeException e) {
			if(tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return products;
	}
	
}
