package org.mnr.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mnr.hibernate.entity.Car;
import org.mnr.hibernate.entity.Engine;
import org.mnr.hibernate.entity.Owner;

public class S6_OneToManyDemo {

	public static void main(String[] args) {
		Engine engine = new Engine();
		engine.setCode("abc123");
		
		Car car1 = new Car();
		car1.setModel("zen");
		car1.setEngine(engine);
		
		Car car2 = new Car();
		car2.setModel("i10");
		car2.setEngine(engine);
		
		Owner owner = new Owner();
		owner.setName("Naveen");
		owner.getCars().add(car1);
		owner.getCars().add(car2);
		
		car1.setOwner(owner);
		car2.setOwner(owner);
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(engine);//first save dependent object first to avoid additional update query
//		session.save(car1); //If cascade option is set in the containing object onetomany relationship,
//		session.save(car2); //these dependent objects need not be saved.
		session.save(owner);
		
		
		session.getTransaction().commit();
		session.close();

	}

}
