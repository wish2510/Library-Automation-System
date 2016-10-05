package dao;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.branchVO;
public class branchajaxdao {
	
	public List select() {
		// TODO Auto-generated method stub
		Session session = null;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
	
		Query qry = session.createQuery("from branchVO");
		List objlist = qry.list();

		tr.commit();
        session.close();
        return objlist;
		
	}	
	public java.util.List search(branchVO brVO)
	{
		java.util.List ls =null;
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			
			Query  query=null;
			System.out.println("anhi aavi gyu");
			query = session.createQuery("from branchVO where branchID="+ brVO.getBranchID());
			
			ls = query.list();
			

		return ls;
	}
	public java.util.List searchexi(branchVO brVO)
	{
		java.util.List ls =null;
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			
			Query  query=null;
			System.out.println("anhi aavi gyu");
			query = session.createQuery("from branchVO");
			
			ls = query.list();
			

		return ls;
	}
}
