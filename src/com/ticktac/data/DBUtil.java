package com.ticktac.data;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {
	private static final EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("ticktacUP");
	
	public static EntityManagerFactory getEMF() { return emf; }
}
