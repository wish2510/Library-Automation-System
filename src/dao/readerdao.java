package dao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import vo.adminloginVO;
import vo.readerVO;
import vo.reserveVO;
public class readerdao {
		
		public List searchreaderdata(readerVO rdrrVO) {
			// TODO Auto-generated method stub		
			java.util.List ls =null;
			try {
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				Query  query=null;
				query = session.createQuery("from readerVO readerr, reserveVO rsv, borrowVO br where readerr.readerID=rsv.readerID and readerr.readerID=br.readerID and readerr.readerID="+ rdrrVO.getReaderID());
				ls = query.list();
				}
			catch (Exception e) {
				// TODO: handle exception
				}

			return ls;
		}

/*		public void delete(reserveVO userRecordVO) {

			try {
				Query query = null;
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				
				Transaction transaction = session.beginTransaction();
				System.out.println("HIIIII"+userRecordVO.getUserRecordid());
				if(userRecordVO.getUserRecordid()!=null)
					query = session.createQuery("delete from UserRecordVO where userRecordid ="+userRecordVO.getUserRecordid());
				else
					query = session.createQuery("delete from UserRecordVO where userid ="+userRecordVO.getUserid());
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
/*		public List searchpersonalrecord(reserveVO userRecordVO) {
			java.util.List ls =null;
			
			try {
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				
				Query  query=null;
				query = session.createQuery("from UserRecordVO where userRecordid="+ userRecordVO.getUserRecordid());
				
					
				ls = query.list();
				

			} catch (Exception e) {
				// TODO: handle exception
			}

			return ls;
		}
	
*/	
}

