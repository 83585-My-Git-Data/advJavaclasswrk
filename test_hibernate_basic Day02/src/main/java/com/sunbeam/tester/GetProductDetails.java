package com.sunbeam.tester;

import java.util.Scanner;

import org.hibernate.*;

import com.sunbeam.dao.ProductsDao;
import com.sunbeam.dao.ProductsDaoImpl;
import com.sunbeam.util.HibernateUtil;

public class GetProductDetails {

	public static void main(String[] args) {
		try(SessionFactory sf = HibernateUtil.getFactory();
				Scanner sc = new Scanner(System.in)){
			ProductsDao dao = new ProductsDaoImpl();
			System.out.println("Enter Product ID ");
			System.out.println(dao.getProductDetailsById(sc.nextLong()));
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
