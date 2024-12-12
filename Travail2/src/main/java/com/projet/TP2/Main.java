package com.projet.TP2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.projet.Util.HibernateUtil;


public class Main {

	public static void main(String[] args) {
		String message = "Execution";
		System.out.print(message);
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transation = null;
	}	
}

