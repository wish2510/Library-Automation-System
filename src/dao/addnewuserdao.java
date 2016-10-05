package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.readerVO;

public class addnewuserdao {

	public void insert(readerVO rdVO)
	{
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(rdVO);		
			transaction.commit();
			session.flush();
			session.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	public List alreadyusersearch(readerVO rdrVO) {
		// TODO Auto-generated method stub		
		java.util.List ls =null;
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Query  query=null;
			query = session.createQuery("from readerVO reader where readerName like'"+rdrVO.getReaderName()+"'and phone like'"+rdrVO.getPhone()+"'");
			ls = query.list();
			}
		catch (Exception e) {
			// TODO: handle exception
			}
		return ls;
	}
}
