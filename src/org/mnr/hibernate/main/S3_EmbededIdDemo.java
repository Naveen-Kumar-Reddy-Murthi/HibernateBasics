package org.mnr.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mnr.hibernate.entity.Login;
import org.mnr.hibernate.entity.User;

public class S3_EmbededIdDemo {

	public static void main(String[] args) {
		
		Login login = new Login();
	    login.setId(1);
	    login.setPassword("lsdfjdlfjs");
	    
	    User user = new User();
	    user.setName("Naveen");
	    user.setLogin(login);
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
	    session.beginTransaction();
	    
	    session.save(user);
	    session.getTransaction().commit();
	    session.close();
		

	}

}
