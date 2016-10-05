package dao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import vo.branchVO;
public class ReferingClinicdao {
	public void insert(branchVO referingClinicVO)
	{
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();			
			session.save(referingClinicVO);		
			transaction.commit();
			session.flush();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	public java.util.List search(branchVO referingClinicVO)
	{
		java.util.List ls1 =null;	
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			/*Query q = session.createQuery("from UserLoginVO where sarchbypatient like '"+loginVO.getFstname()+"' ");
			ls = q.list();*/
			Query  query=null;
			query=session.createQuery("from ReferingClinicVO refer,vo_country cntry where refer.cliniccountry = cntry.cntryid");
			ls1 = query.list();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ls1;
	}
	public java.util.List search1(branchVO referingClinicVO)
	{
		java.util.List ls1 =null;
		
		try {
			
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			/*Query q = session.createQuery("from UserLoginVO where sarchbypatient like '"+loginVO.getFstname()+"' ");
			ls = q.list();*/
			Query  query=null;
			query=session.createQuery("select max(clinicid) from ReferingClinicVO");
			ls1 = query.list();
			

		} catch (Exception e) {
			// TODO: handle exception
		}
		return ls1;
	}
}