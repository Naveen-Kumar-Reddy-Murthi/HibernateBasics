package org.mnr.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mnr.hibernate.entity.Car;
import org.mnr.hibernate.entity.Engine;

public class S5_OneToOneDemo {

	public static void main(String[] args) {
		Engine engine = new Engine();
		engine.setCode("abc123");
		
		Car car = new Car();
		car.setModel("zen");
		car.setEngine(engine);
		
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(engine);//firt save dependent object first to avoid additional update query
		session.save(car);    
		
		
		session.getTransaction().commit();
		session.close();
		session=null;
		car=null;
		
		session = factory.openSession();
		car = (Car) session.get(Car.class, 20);
		System.out.println("car object:"+car);
		
	}

}
