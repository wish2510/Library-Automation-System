package dao;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class publisherajaxdao {
	
	public List select() {
		// TODO Auto-generated method stub
		Session session = null;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
	
		Query qry = session.createQuery("from  publisherVO");
		List objlist = qry.list();
     
		tr.commit();
        session.close();
		return objlist;
		
	}	
	
}
