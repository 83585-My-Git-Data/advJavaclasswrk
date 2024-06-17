package com.sunbeam.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductsDao;
import com.sunbeam.dao.ProductsDaoImpl;
import com.sunbeam.entities.Catagory;
import com.sunbeam.util.HibernateUtil;

public class ProductDiscount {

	public static void main(String[] args) {
		try (SessionFactory sf = HibernateUtil.getFactory();
				Scanner sc = new Scanner(System.in)){
			ProductsDao dao = new ProductsDaoImpl();
			System.out.println("Enter Catagory and Discount amount");
			System.out.println(dao.ProductDiscount(Catagory.valueOf(sc.next().toUpperCase()), sc.nextDouble()));
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
