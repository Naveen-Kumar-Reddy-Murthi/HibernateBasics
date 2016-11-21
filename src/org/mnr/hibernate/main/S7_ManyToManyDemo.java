package org.mnr.hibernate.main;

import java.util.Date;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mnr.hibernate.entity.Customer;
import org.mnr.hibernate.entity.Order;

public class S7_ManyToManyDemo {

	public static void main(String[] args) {
		
		Order order = new Order();
		order.setOrderDate(new Date());
		
		
		Order order1 = new Order();
		order1.setOrderDate(new Date());
		
		Customer customer = new Customer();
		customer.setCode("NAVE1243");
		
		 HashSet<Customer> customers = new HashSet<Customer>();
		 customers.add(customer);
		 
		 order.setCustomers(customers);
		 order1.setCustomers(customers);
		 
		 HashSet<Order> orders = new HashSet<Order>();
		 orders.add(order);
		 orders.add(order1);
		 customer.setOrders(orders);
		
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
//		session.save(customer);
		
		session.getTransaction().commit();
		session.close();
		session=null;
		session= factory.openSession();
		 customer= (Customer) session.get(Customer.class, 1) ;
		 System.out.println(customer);
		 System.out.println(customer.getOrders());

	}

}
