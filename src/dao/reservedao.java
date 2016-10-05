package dao;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.borrowVO;
import vo.reserveVO;
public class reservedao {
		
		public List searchreaderreservedata(reserveVO reservvvVO) {
			// TODO Auto-generated method stub		
			java.util.List ls =null;
			try {
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				Query  query=null;
				System.out.println("Quesry fired");
				query = session.createQuery("from reserveVO reserv, readerVO rdr, bookVO bk, branchVO br where reserv.readerID = rdr.readerID and reserv.bookID = bk.bookID and reserv.branchID= br.branchID and reserv.readerID="+ reservvvVO.getReaderID());
				ls = query.list();
				}
			catch (Exception e) {
				// TODO: handle exception
				}

			return ls;
		}
		public List search(reserveVO reservvvVO) {
			// TODO Auto-generated method stub		
			java.util.List ls =null;
			try {
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				Query  query=null;
				System.out.println("Quesry fired");
				query = session.createQuery("from reserveVO reserv where reserv.bookID="+ reservvvVO.getBookID());
				ls = query.list();
				}
			catch (Exception e) {
				// TODO: handle exception
				}

			return ls;
		}
	
		public List search2(reserveVO reservvvVO) {
			// TODO Auto-generated method stub		
			java.util.List ls =null;
			try {
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				Query  query=null;
				System.out.println("Quesry fired");
				query = session.createQuery("from reserveVO reserv where reserv.readerID="+ reservvvVO.getReaderID());
				ls = query.list();
				}
			catch (Exception e) {
				// TODO: handle exception
				}

			return ls;
		}

		
		public void delete(reserveVO userloginvo)
		{
			try {
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				
				Transaction transaction = session.beginTransaction();
				
				Query query = session.createQuery("delete from reserveVO where reserveID ="+userloginvo.getReserveID() );
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

		public void deletereturned(borrowVO userloginvo)
		{
			try {
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				
				Transaction transaction = session.beginTransaction();
				
				Query query = session.createQuery("delete from borrowVO where borrowID ="+userloginvo.getBorrowID());
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
		public List updatebdate(borrowVO reservvvVO) {
			// TODO Auto-generated method stub		
			java.util.List ls =null;
			try {
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				Query  query=null;
				System.out.println("Quesry fired");
				query = session.createQuery("from borrowVO reserv where reserv.borrowID="+ reservvvVO.getBorrowID());
				ls = query.list();
				}
			catch (Exception e) {
				// TODO: handle exception
				}

			return ls;
		}
		public void deleteone(reserveVO userloginvo)
		{
			try {
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				
				Transaction transaction = session.beginTransaction();
				
				Query query = session.createQuery("delete from reserveVO where reserveID ="+userloginvo.getBookID() );
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
		
		public List checkbranchfororrow(reserveVO reservvvVO) {
			// TODO Auto-generated method stub		
			java.util.List ls =null;
			try {
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				Query  query=null;
				System.out.println("Quesry fired");
				query = session.createQuery("from reserveVO reserv where reserv.bookID ='"+ reservvvVO.getBookID()+"'and reserv.branchID='"+reservvvVO.getBranchID()+"'and reserv.readerID='"+reservvvVO.getReaderID()+"'");
				ls = query.list();
				}
			catch (Exception e) {
				// TODO: handle exception
				}

			return ls;
		}
	
		
		public List checkbranchforreturn(borrowVO reservvvVO) {
			// TODO Auto-generated method stub		
			java.util.List ls =null;
			try {
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				Query  query=null;
				System.out.println("Quesry fired");
				query = session.createQuery("from borrowVO borv where borv.bookID ='"+ reservvvVO.getBookID()+"'and borv.readerID='"+reservvvVO.getReaderID()+"'and borv.branchID='"+reservvvVO.getBranchID()+"'and borv.rDateTime="+null+"");
				ls = query.list();
				}
			catch (Exception e) {
				// TODO: handle exception
				}

			return ls;
		}

		
		public void insert(reserveVO rvVO)
		{
			try {
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				session.save(rvVO);		
				transaction.commit();
				session.flush();
				session.close();
			} 
			catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
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
		public List searchreserveitem(reserveVO userRecordVO) {
			java.util.List ls =null;
			
			try {
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				
				Query  query=null;
				query = session.createQuery("from reserveVO where readerID="+ userRecordVO.getReaderID());
				
					
				ls = query.list();
				

			} catch (Exception e) {
				// TODO: handle exception
			}

			return ls;
		}	
		
}

