package dao;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.bookVO;
import vo.borrowVO;
import vo.numofcopyVO;
import vo.reserveVO;
public class borrowdao {
		
		public List searchreaderborrowdata(borrowVO broVO) {
			// TODO Auto-generated method stub		
			java.util.List ls =null;
			try {
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				Query  query=null;
				System.out.println("another query fired");
				System.out.println(broVO);
				query = session.createQuery("from borrowVO bor, readerVO rdr, bookVO bk, branchVO br where bor.readerID = rdr.readerID and bor.bookID = bk.bookID and bor.branchID= br.branchID and bor.readerID='"+ broVO.getReaderID()+"'and bor.rDateTime="+null+"");
				ls = query.list();
				}
			catch (Exception e) {
				// TODO: handle exception
				}

			return ls;
		}
		public void insert(borrowVO bkVO)
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
		public void update(borrowVO numofcopyvo)
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
		public List searchreserveitem(borrowVO userRecordVO) {
			java.util.List ls =null;
			
			try {
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				
				Query  query=null;
				query = session.createQuery("from borrowVO where readerID="+ userRecordVO.getReaderID());
				
					
				ls = query.list();
				

			} catch (Exception e) {
				// TODO: handle exception
			}

			return ls;
		}
		public List frequnatborrow(borrowVO userRecordVO) {
			java.util.List ls =null;
			
			try {
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				Query  query=null;
				query = session.createQuery("select rdr.readerName, count(brvo.readerID) "
						+ "from readerVO rdr, borrowVO brvo "
						+ "where rdr.readerID=brvo.readerID group by brvo.readerID order by count(brvo.readerID) desc");
							
				ls = query.list();
				} catch (Exception e) {
				// TODO: handle exception
			}

			return ls;
		}
	
		public List mostborrow(borrowVO userRecordVO) {
			java.util.List ls =null;
			
			try {
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				System.out.println("most borrow andar");
				Query  query=null;
//				query = session.createQuery("select brvo.readerID, count(brvo) from borrowVO brvo group by brvo.readerID");
//				query = session.createQuery("select from borrowVO brvo where brvo.readerID, count(brvo) group by brvo.readerID");
//				query = session.createQuery(" select readerVO.readerName, count(bv.readerID) from readerVO band join band.readerID borrowVO bv group by band.readerID ");	
				query = session.createQuery("select bk.bookTitle, count(brvo.bookID) from bookVO bk, borrowVO brvo where brvo.bookID=bk.bookID group by brvo.bookID order by count(brvo.bookID) desc");
				//order by max(vote.totalVotes) desc				
ls = query.list();
				

			} catch (Exception e) {
				// TODO: handle exception
			}

			return ls;
		}

		public List averagefine(borrowVO userRecordVO) {
			java.util.List ls =null;
			
			try {
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				System.out.println("most borrow andar");
				Query  query=null;
//				query = session.createQuery("select brvo.readerID, count(brvo) from borrowVO brvo group by brvo.readerID");
//				query = session.createQuery("select from borrowVO brvo where brvo.readerID, count(brvo) group by brvo.readerID");
//				query = session.createQuery(" select readerVO.readerName, count(bv.readerID) from readerVO band join band.readerID borrowVO bv group by band.readerID ");	
				query = session.createQuery("select rdr.readerName, avg(brvo.fine) from readerVO rdr, borrowVO brvo where brvo.readerID=rdr.readerID group by brvo.readerID");
				//order by max(vote.totalVotes) desc
				System.out.println("Pati gayu");
ls = query.list();
				

			} catch (Exception e) {
				// TODO: handle exception
			}

			return ls;
		}
	
	
}

