package com.sunbeam.tester;

import org.hibernate.SessionFactory;

import com.sunbeam.util.HibernateUtil;

public class HibernateTest {

	public static void main(String[] args) {
		try(SessionFactory sf = HibernateUtil.getFactory()){
			System.out.println("My Hibernate is Up and Running Very Fast... !!!!");
		} catch(Exception e){
			e.printStackTrace();
		}

	}

}
