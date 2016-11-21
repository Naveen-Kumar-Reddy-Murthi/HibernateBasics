package org.mnr.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mnr.hibernate.entity.FourWheeler;
import org.mnr.hibernate.entity.TwoWheeler;
import org.mnr.hibernate.entity.Vehicle;

public class S8_Inheritence {

	public static void main(String[] args) {
		
		Vehicle vehicle = new Vehicle();
		vehicle.setName("Car");
		
		TwoWheeler bike = new TwoWheeler();
		bike.setHandleSize("HD222E3");
		bike.setName("FZ");
		
		FourWheeler car = new FourWheeler();
		car.setSteeringModel("STW2344");
		car.setName("DUSTER");
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		session.save(vehicle);
		session.save(car);
		session.save(bike);
		
		session.getTransaction().commit();
		
		/**
		 * Here Vehicle is super class 
		 * By default, hibernate will implement SINGLE_TABLE strategy if there no inheritance 
		 * strategy is mentioned on super class
		 * It also adds default descriminatory column(String)and its values will be String
		 * Descriminatory column values can be overridden in child class using annotations.
		 * on su
		 */

	}

}
