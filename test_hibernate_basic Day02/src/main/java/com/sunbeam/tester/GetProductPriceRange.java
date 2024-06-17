package com.sunbeam.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductsDao;
import com.sunbeam.dao.ProductsDaoImpl;
import com.sunbeam.entities.Catagory;
import com.sunbeam.util.HibernateUtil;

public class GetProductPriceRange {

	public static void main(String[] args) {
		try(SessionFactory sf = HibernateUtil.getFactory();
				Scanner sc = new Scanner(System.in);
				){
			ProductsDao dao = new ProductsDaoImpl();
			System.out.println("Enter the range and Catagory");
			dao.getProductPriceRange(sc.nextDouble(), sc.nextDouble(), Catagory.valueOf(sc.next().toUpperCase()))
			.forEach(System.out::println);
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
