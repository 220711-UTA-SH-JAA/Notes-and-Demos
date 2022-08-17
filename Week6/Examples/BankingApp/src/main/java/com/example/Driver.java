package com.example;

import org.hibernate.Session;

import com.example.utils.HibernateUtil;

public class Driver {
	
	public static void main(String args[]) {
		
		Session ses = HibernateUtil.getSession();
		
	}

}
