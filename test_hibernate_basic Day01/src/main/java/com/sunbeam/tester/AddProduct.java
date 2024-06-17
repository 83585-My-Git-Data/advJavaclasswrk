package com.sunbeam.tester;

import static com.sunbeam.util.HibernateUtil.getFactory;


import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductsDao;
import com.sunbeam.dao.ProductsDaoImpl;
import com.sunbeam.entities.Catagory;
import com.sunbeam.entities.Products;
import com.sunbeam.util.HibernateUtil;

public class AddProduct {

	public static void main(String[] args) {
		try (SessionFactory sf = HibernateUtil.getFactory();
				Scanner sc=new Scanner(System.in)
				) {
			
//			this.productName = productName;
//			this.price = price;
//			this.availableQuantity = availableQuantity;
//			this.catagory = catagory;
//			
			ProductsDao dao=new ProductsDaoImpl();
			System.out.println("Enter Product details -ProductName, price, \r\n"
					+ "			AvailableQuantity, catagory");
			Products newProduct = new Products (sc.next(), sc.nextDouble(), sc.nextInt(), Catagory.valueOf(sc.next().toUpperCase()));
			System.out.println(dao.addProduct(newProduct));
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
