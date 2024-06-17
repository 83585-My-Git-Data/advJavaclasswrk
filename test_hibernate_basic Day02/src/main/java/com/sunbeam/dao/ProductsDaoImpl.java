package com.sunbeam.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.*;

import com.sunbeam.entities.Catagory;
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

	@Override
	public List<Products> getAllProducts() {
		String jpql = "select p from Products p";
		List<Products> products  = null;
		Session session = HibernateUtil.getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
		products = session.createQuery(jpql, Products.class).getResultList();
			tx.commit();
		}catch(RuntimeException e) {
			if(tx != null) {
				tx.rollback();
			}
			throw e;
		}
				return products;
	}

	@Override
	public List<Products> getProductPriceRange(double range1, double range2, Catagory cat) {
//		String jpql = "select p from products p where p.price between :start and :end and p.catagory = :cata";
		String jpql = "select p from Products p where p.catagory = :cata and p.price between :start and :end";
		List<Products> products = null;
		Session session = HibernateUtil.getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			products = session.createQuery(jpql,Products.class)
					.setParameter("cata",cat)
					.setParameter("start",range1)
					.setParameter("end",range2)
					.getResultList();
			tx.commit();
		}catch(RuntimeException e) {
			if(tx != null) {
				tx.rollback();
			}
			throw e;
		}
				return products;
	}

	@Override
	public String ProductDiscount(Catagory cat, double discount) {
		String mesg = "Applying discount Failed !!!";
		String jpql ="update Products p set p.price = p.price-:disc where p.catagory=:cata";
		Session session  = HibernateUtil.getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			int rows = session.createQuery(jpql)
					.setParameter("disc", discount)
					.setParameter("cata", cat)
					.executeUpdate();
			tx.commit();
			mesg = "Applied discount on Catagory- " + rows;
		} catch (RuntimeException e) {
			if(tx!=null) {
				tx.rollback();
			}throw e;
		}
		
		return mesg;
	}

	
	
}
