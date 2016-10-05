package dao;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.bookVO;
import vo.numofcopyVO;
import vo.publisherVO;

public class numofcopydao {

	
		public static java.util.List bookcopysearch(numofcopyVO numcopVO) {
		// TODO Auto-generated method stub

		java.util.List ls =null;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Query  query=null;
		
		query = session.createQuery("from numofcopyVO numcp, branchVO brn, bookVO bkv where numcp.branchID = brn.branchID and numcp.bookID = bkv.bookID and numcp.branchID ='"+ numcopVO.getBranchID()+"'and numcp.copy >'"+ 0+"'");
		
		ls = query.list();
		System.out.println(ls.size());
		
	return ls;

	}
		public static java.util.List bookcopysearchforreturn(numofcopyVO numcopVO) {
			// TODO Auto-generated method stub

			java.util.List ls =null;
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			
			Query  query=null;
			
			query = session.createQuery("from numofcopyVO numcp where numcp.branchID ='"+ numcopVO.getBranchID()+"'and numcp.bookID ='"+ numcopVO.getBookID()+"'");
			
			ls = query.list();
			System.out.println(ls.size());
			
		return ls;

		}

		public void insert(numofcopyVO numofcopyVO) {
			// TODO Auto-generated method stub
			try {
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				session.save(numofcopyVO);		
				transaction.commit();
				session.flush();
				session.close();
			} 
			catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		
		public void updatecopy(numofcopyVO numofcopyvo)
		{
			try {
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				session.saveOrUpdate(numofcopyvo);
				transaction.commit();
				session.flush();
				session.close();
			} 
			catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
				
				
		}
		public List getcopy(numofcopyVO numofcopyvo)
		{
			java.util.List ls =null;
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			
			Query  query=null;
			
			query = session.createQuery("from numofcopyVO numcp where numcp.bookID='"+ numofcopyvo.getBookID()+"'and numcp.branchID='"+numofcopyvo.getBranchID()+"'");
			
			ls = query.list();
			System.out.println(ls.size());
				
			return ls;
				
		}

		public List searchbyiid(numofcopyVO numofcopyvo)
		{
			java.util.List ls =null;
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			
			Query  query=null;
			
			query = session.createQuery("from numofcopyVO numcp, branchVO br, bookVO bk where numcp.bookID = bk.bookID and numcp.branchID = br.branchID and numcp.bookID='"+ numofcopyvo.getBookID()+"'");
			
			ls = query.list();
			System.out.println(ls.size());
				
			return ls;
				
		}
		public List searchbytitle(bookVO numofcopyvo)
		{
			java.util.List ls =null;
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			
			Query  query=null;
			
			query = session.createQuery("from bookVO bk, numofcopyVO numcp, branchVO br where numcp.branchID = br.branchID and bk.bookID=numcp.bookID and bk.bookTitle like'"+numofcopyvo.getBookTitle()+"%'");
			
			ls = query.list();
			System.out.println(ls.size());
				
			return ls;
				
		}
		
		public List searchbypublisher(publisherVO numofcopyvo)
		{
			java.util.List ls =null;
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			
			Query  query=null;
			
			query = session.createQuery("from publisherVO pubv, bookVO bk where pubv.publisherID = bk.publisherID and pubv.publisherName like'"+numofcopyvo.getPublisherName()+"%'");
			
			ls = query.list();
			System.out.println(ls.size());
				
			return ls;
				
		}
		public void insertcopy(numofcopyVO numofcopyVO) {
			// TODO Auto-generated method stub
			
		}
}

