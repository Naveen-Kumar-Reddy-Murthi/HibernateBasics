package org.mnr.hibernate.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mnr.hibernate.entity.Address;
import org.mnr.hibernate.entity.Person;

public class S4_ElementCollectionDemo {

	public static void main(String[] args) {
		
		Person person = new Person();
		person.setId(1);
		person.setName("naveen");
		Address address = new Address();
		ArrayList<Address> list=new ArrayList<Address>();
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
		list.add(address);
		list.add(address1);
		person.setAddressList(list);
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(person);
		session.getTransaction().commit();
		session.close();
		session=null;
		person = null;
		session = factory.openSession();
		session.beginTransaction();
		person = (Person) session.get(Person.class, 1);
		System.out.println(person);
		System.out.println(person.getAddressList());
	

	}

}
