package controller;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import vo.borrowVO;

public class borrowdao2 {

	public List getborrodetil(borrowVO vrVO) {
		// TODO Auto-generated method stub
		List ls = null;
		try {
			System.out.println("asdasdas");
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			System.out.println("dasdasdfsadfsdafsdaf");
			Session session = sessionFactory.openSession();
			System.out.println("He he he");
			Query query = session.createQuery("from borrowVO");
			ls = query.list();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ls;
	}
		
}
