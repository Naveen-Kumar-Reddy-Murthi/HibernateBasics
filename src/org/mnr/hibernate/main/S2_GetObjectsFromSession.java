package org.mnr.hibernate.main;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.mnr.hibernate.entity.UserDetails;

public class S2_GetObjectsFromSession {
	
	public static void main(String...args){
		
SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		session.beginTransaction();
		
		UserDetails user=(UserDetails) session.get(UserDetails.class, 1);
		user.getNoNeed();
		System.out.println(user);
	}

}
