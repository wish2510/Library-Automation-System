package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.bookVO;
import vo.readerVO;

public class addnewbookdao {

	public void insert(bookVO bkVO)
	{
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(bkVO);		
			transaction.commit();
			session.flush();
			session.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	public List search(bookVO rdrVO) {
		// TODO Auto-generated method stub		
		java.util.List ls =null;
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Query  query=null;
			query = session.createQuery("from bookVO");
			System.out.println("qwasscsxcfvdfvsfdgfbgfxbnghnhm//////////////////");
			ls = query.list();
			}
		catch (Exception e) {
			// TODO: handle exception
			}
		return ls;
	}
/*	public List alreadyusersearch(readerVO rdrVO) {
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
*/}
