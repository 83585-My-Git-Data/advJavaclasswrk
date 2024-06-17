package com.sunbeam.tester;

import org.hibernate.*;

import com.sunbeam.dao.ProductsDao;
import com.sunbeam.dao.ProductsDaoImpl;
import com.sunbeam.util.HibernateUtil;

public class GetAllProducts {

	public static void main(String[] args) {
		try(SessionFactory sf = HibernateUtil.getFactory()){
			ProductsDao dao = new ProductsDaoImpl();
			dao.getAllProducts().forEach(System.out::println);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
