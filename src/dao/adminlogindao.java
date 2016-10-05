package dao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.adminloginVO;
import vo.readerVO;

public class adminlogindao {

	public void insert(readerVO readervo)
	{
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(readervo);		
			transaction.commit();
			session.flush();
			session.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	public void update(adminloginVO adminloginvo)
	{
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(adminloginvo);
			transaction.commit();
			session.flush();
			session.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

/*	public java.util.List search(adminloginVO loginVO)
	{
		java.util.List ls =null;
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			
			Query  query=null;
			if(loginVO.getFstname()!=null)
			query = session.createQuery("from UserLoginVO login , UserProfileVO profile, vo_country cntry where login.userid = profile.userid and cntry.cntryid=profile.country and login.fstname like'"+loginVO.getFstname()+"%'");
			else if(loginVO.getUserid()!=null)
			query = session.createQuery("from UserLoginVO login , UserProfileVO profile, ReferingClinicVO refer where login.userid = profile.userid and profile.userid=login.userid and login.userid="+loginVO.getUserid());
			else
			query=session.createQuery("from UserLoginVO");
			
			ls = query.list();
			

		return ls;
	}
*/
/*	public java.util.List fetch(adminloginVO loginVO)
	{
		java.util.List ls =null;
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			
			Query  query=null;
			query=session.createQuery("from UserLoginVO where userid="+loginVO.getUserid());
			ls = query.list();
			session.flush();
			session.close();

			return ls;
	}
*/	
/*	public void delete(adminloginVO userloginvo)
	{
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			
			Transaction transaction = session.beginTransaction();
			
			Query query = session.createQuery("delete from UserLoginVO where userid ="+userloginvo.getUserid() );
			query.executeUpdate();
			transaction.commit();
			session.flush();
			session.close();

		} 
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
			
			
	}
*/
	public static java.util.List loginsearch(adminloginVO adminloginVO) {
		// TODO Auto-generated method stub
		System.out.println("Inside loginsearch");
		java.util.List ls =null;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Query  query=null;
		
		query = session.createQuery("from adminloginVO where username like'"+adminloginVO.getUsername()+"'and password like'"+adminloginVO.getPassword()+"'");
		
		ls = query.list();
		System.out.println(ls.size());
		
	return ls;

	}

/*	public List dd(adminloginVO loginVO) {
		// TODO Auto-generated method stub
		java.util.List ls =null;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Query  query=null;
		query=session.createQuery("from UserLoginVO login where login.userid!="+ loginVO.getUserid());
		
		ls = query.list();
		

	return ls;

	}

	public List fu(UserProfileVO upv) {
		// TODO Auto-generated method stub
		java.util.List ls =null;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Query  query=null;
		query=session.createQuery("from UserProfileVO  up where up.emailprimary='"+ upv.getEmailprimary()+"' and up.birthdate='"+upv.getBirthdate()+"'");
		ls = query.list();
		return ls;
	}

	public List fu2(adminloginVO uv) {
		// TODO Auto-generated method stub
		java.util.List ls =null;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Query  query=null;
		query=session.createQuery("from UserLoginVO login where login.username='"+uv.getUsername()+"'");
		ls = query.list();
		return ls;
	}
*/
	}

