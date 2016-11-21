package org.mnr.hibernate.main;



import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.mnr.hibernate.entity.Address;
import org.mnr.hibernate.entity.UserDetails;


public class S1_SavingJavaObjectToDatabase {

	public static void main(String[] args) {
		
		UserDetails user = new UserDetails();
//		user.setId(1);
		user.setName("Naveen");
		user.setDescription("Naveen is a good person");
		user.setJoiningDate(new Date());
		user.setNoNeed("noNeed");
		
		Address address = new Address();
		address.setHno("1");
		address.setStreet("a");
		address.setCity("c");
		address.setState("s");
		address.setPincode("p");
		address.setCountry("co");
		
		Address address1 = new Address();
		address1.setHno("2");
		address1.setStreet("a2");
		address1.setCity("c2");
		address1.setState("s2");
		address1.setPincode("p2");
		address1.setCountry("co2");
		
		user.setHomeAddress(address);
		user.setOfficeAddress(address1);
		
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		

	}

}
