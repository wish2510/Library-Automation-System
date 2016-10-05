package controller;

import java.io.IOException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.soap.AddressingFeature.Responses;

import dao.borrowdao;
import dao.numofcopydao;
import dao.reservedao;
import vo.bookVO;
import vo.borrowVO;
import vo.branchVO;
import vo.numofcopyVO;
import vo.reserveVO;


@WebServlet("/reservebookcontroller")
public class reservebookcontroller extends HttpServlet {
	String readerid =  null;
	String bookid = null;
	String readeridforreturn = null;
	String bookidforreturn = null;
	String branchidforreturn =null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reservebookcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("hvhbhvbhvbhdbvhdbhbvhdbv");
		String flag = request.getParameter("flag");
		
		if(flag!=null && flag.equals("AddNewReader"))
		{
			System.out.println("zzzzzzzzzzzzz");
//			reservebook(request, response);
		}
		if(flag!=null && flag.equals("clckbookreserve"))
		{
			System.out.println("jinda hain to");
			reservebookandaddtodb(request , response);
		}
		if(flag!=null && flag.equals("borrow"))
		{
			System.out.println("asdsjdfaskdbfbdsjfbasdbfhads");
			borrowbook(request , response);
		}
		if(flag!=null && flag.equals("return"))
		{
			System.out.println("asdsjdfaskdbfbdsjfbasdbfhads");
			returnbook(request , response);
		}
	}
	private void reservebook(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String readerid = request.getParameter("d");
		String branchid = request.getParameter("branchretrived");
		
		numofcopyVO numofcopyVO = new numofcopyVO();
		branchVO branchVO = new branchVO();
		bookVO bookVO = new bookVO();
		
		numofcopyVO.setBranchID(Long.parseLong(branchid));
		branchVO.setBranchID(Long.parseLong(branchid));
		bookVO.setBookID(Long.parseLong(branchid));
		
		numofcopydao numofcopydao = new numofcopydao();
		List idvisebookcopy = numofcopydao.bookcopysearch(numofcopyVO);
		

		HttpSession session = request.getSession();
		
		session.setAttribute("branchwisebook", idvisebookcopy);
		
		response.sendRedirect("view/htm/reader_reservebooksuggest.jsp");
	}
	private void reservebookandaddtodb(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String readerid = request.getParameter("readerID");
		String branchid = request.getParameter("branchID");
		String bookid = request.getParameter("bookID");
		
		reserveVO reserveVO = new reserveVO();
		
		reserveVO.setBookID(Long.parseLong(bookid));
		reserveVO.setReaderID(Long.parseLong(readerid));
		reserveVO.setBranchID(Long.parseLong(branchid));

		
		java.util.Date date = new java.util.Date();
		String reserveDate = date.toString();
		reserveVO.setReserveDate(reserveDate);
		
		reservedao reservedao = new reservedao();
		HttpSession session2 = request.getSession();
		List lslslslsls = reservedao.search2(reserveVO);
		if(lslslslsls.size()>=10)
		{
			session2.setAttribute("mzx1000", lslslslsls);
			response.sendRedirect("view/htm/Reader_MainPage.jsp");
		}
		else
		{
		reservedao.insert(reserveVO);
		System.out.println("kingggggggggggggggggggggggggggggggggggg");
		numofcopyVO numofcopyVO = new numofcopyVO();
		
		numofcopyVO.setBookID(Long.parseLong(bookid));
		numofcopyVO.setBranchID(Long.parseLong(branchid));
		numofcopydao numofcopydao1 = new numofcopydao();
		System.out.println("");
		List cppp = numofcopydao1.getcopy(numofcopyVO);

		numofcopyVO = (numofcopyVO) cppp.get(0);
		String uid = numofcopyVO.getCopy().toString();
		System.out.println("kjafsdkjbfajdbfkcbcfiehf iahfadfhjasdbfhjdbfhasbdhcfbahdbcfhasdbfchasbdjcfbashdbfchsdabfchasbdc fhasbd hfcb sdhfb"+uid);
		Long cpy = numofcopyVO.getCopy();
		System.out.println("My n"+cpy);
		cpy = cpy-1;
		System.out.println("My nae is khannnnnnnnnnnnnnnnnn"+cpy);
		numofcopyVO.setBookID(numofcopyVO.getBookID());
		numofcopyVO.setBranchID(numofcopyVO.getBranchID());
		numofcopyVO.setCopy(cpy);
		numofcopyVO.setNumofcopyID(numofcopyVO.getNumofcopyID());
		numofcopydao numofcopydao = new numofcopydao();
		numofcopydao1.updatecopy(numofcopyVO);
		HttpSession session = request.getSession();
		
		session.setAttribute("copyandreserve", "Successfully");
		response.sendRedirect("view/htm/reader_reservebooksuggest.jsp");
	}
	}

	private void returnbook(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		readeridforreturn = request.getParameter("ddf");
		branchidforreturn = request.getParameter("branchretrived");
		bookidforreturn = request.getParameter("bookidd");
		
		System.out.println("lelelelele "+readeridforreturn+" branchID "+branchidforreturn+" Book ID"+bookidforreturn);
		borrowVO brVO = new borrowVO();
		brVO.setBookID(Long.parseLong(bookidforreturn));
		borrowdao borrowdao = new borrowdao();
		
		List ls = borrowdao.searchreserveitem(brVO);
		HttpSession httpSession = request.getSession();
		
		if(ls.size()<=10)
		{
			response.sendRedirect("view/htm/reader_returnbrnchselect.jsp");
		}
		else
		{

				httpSession.setAttribute("MAX102", "yes");
			
		}	
		
		

	
		}

	private void borrowbook(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		readerid = request.getParameter("d");
//		String branchid = request.getParameter("branchretrived");
		bookid = request.getParameter("bookid");
		
		System.out.println(readerid+" "+bookid);
		
		reserveVO reserveVO = new reserveVO();
		reserveVO.setBookID(Long.parseLong(bookid));
		reservedao reservedao = new reservedao();
		List ls = reservedao.searchreserveitem(reserveVO);
		HttpSession httpSession = request.getSession();
		
		if(ls.size()<=10)
		{

			
			response.sendRedirect("view/htm/reader_borrowbranchselect.jsp");	
		}
		else
		{

			httpSession.setAttribute("MAX10", "yes");
			
		}	

	}
	private void borrownewbook(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		// TODO Auto-generated method stub
		
		String branchID = request.getParameter("branchretrived");
		
		System.out.println(branchID+" "+ bookid+" "+ readerid +"Me eeee");

		reserveVO reserveVO = new reserveVO();
		reserveVO.setBookID(Long.parseLong(bookid));
		reserveVO.setBranchID(Long.parseLong(branchID));
		reserveVO.setReaderID(Long.parseLong(readerid));
		reservedao reservedao = new reservedao();
		List ls = reservedao.checkbranchfororrow(reserveVO);
		System.out.println("ksdhaks"+ls.size());
		reserveVO reserVO = (reserveVO)ls.get(0);
		System.out.println(reserVO.getBranchID().toString());
		HttpSession session = request.getSession();
		if(branchID.equals( reserVO.getBranchID().toString()))
		{
			System.out.println("It is same");
			borrowVO borrowVO = new borrowVO();
			borrowVO.setBookID(Long.parseLong(bookid));
			borrowVO.setReaderID(Long.parseLong(readerid));
			borrowVO.setBranchID(Long.parseLong(branchID));
			borrowVO.setFine(0.0);
			Date now = new Date();
			borrowVO.setbDateTime(now.toString());
			
			borrowdao borrowdao = new borrowdao();
			borrowdao.insert(borrowVO);
			
			reserveVO res = new reserveVO();
			res.setBookID(Long.parseLong(bookid));
			reservedao rdo = new reservedao();
			List s = rdo.search(res);
			if(s.size()>0)
			{
				reserveVO resd = (reserveVO) s.get(0);
				resd.setReserveID(resd.getReserveID());
				rdo.delete(resd);
			}
			else
			{
				reserveVO resd = (reserveVO) s.get(0);
				res.setBookID(resd.getBookID());
				rdo.deleteone(res);
			}
			
			session.setAttribute("congo", "con");
			response.sendRedirect("view/htm/Reader_MainPage.jsp");
		}
		else
		{
			session.setAttribute("failure", "fal");
			System.out.println("It is different");
			response.sendRedirect("view/htm/Reader_MainPage.jsp");
		}
		
}

	private void returnonebook(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		// TODO Auto-generated method stub
		System.out.println("QQQQQQQQQQQQQQQQQQQQQQQQQQQQ");
		String branchID = request.getParameter("branchretrived");
		System.out.println(branchID+" mememememmemememddssdsd");
		borrowVO borrowVO = new borrowVO();
		System.out.println("bookid ="+bookidforreturn+" branchID="+branchID+" readerID"+readeridforreturn);
		borrowVO.setBookID(Long.parseLong(bookidforreturn));
		borrowVO.setBranchID(Long.parseLong(branchID));
		borrowVO.setReaderID(Long.parseLong(readeridforreturn));

		reservedao reservedao = new reservedao();
//		System.out.println("bookid =" +bookidforreturn+" Bran"+branchID+" "+readeridforreturn);
		List ls1 = reservedao.checkbranchforreturn(borrowVO);
		System.out.println("SIze of returned list ="+ls1.size());
		numofcopyVO numofcopyVO = new numofcopyVO();
		numofcopydao numofcopydao = new numofcopydao();
		HttpSession session = request.getSession();

		if(ls1.size()>0)
		{
			System.out.println("asdfghjkldfghjkl");
			borrowVO.setBorrowID(((borrowVO)ls1.get(0)).getBorrowID());
			List t = reservedao.updatebdate(borrowVO);
			System.out.println("List sixe is "+t.size());

			borrowVO bvc = (borrowVO)(t.get(0));
			borrowVO.setBorrowID(bvc.getBorrowID());
			borrowVO.setBookID(bvc.getBookID());
			borrowVO.setBranchID(bvc.getBranchID());
			borrowVO.setReaderID(bvc.getReaderID());
			borrowVO.setbDateTime(bvc.getbDateTime());
			
			
			Calendar cal1 = new GregorianCalendar();
			Calendar cal2 = new GregorianCalendar();
			String year = bvc.getbDateTime().substring(24, 28);
			String month="";
			String day = bvc.getbDateTime().substring(8, 10);
			System.out.println(bvc.getbDateTime().substring(4,7));
			if((bvc.getbDateTime().substring(4,7).equals("Jan")))
			{
				month = "1";
			}
			if((bvc.getbDateTime().substring(4,7).equals("Feb")))
			{
				month = "2";
			}if((bvc.getbDateTime().substring(4,7).equals("Mar")))
			{
				month = "3";
			}if((bvc.getbDateTime().substring(4,7).equals("Apr")))
			{
				month = "4";
			}if((bvc.getbDateTime().substring(4,7).equals("May")))
			{
				month = "5";
			}if((bvc.getbDateTime().substring(4,7).equals("Jun")))
			{
				month = "6";
			}if((bvc.getbDateTime().substring(4,7).equals("Jul")))
			{
				month = "7";
			}if((bvc.getbDateTime().substring(4,7).equals("Aug")))
			{
				month = "8";
			}if((bvc.getbDateTime().substring(4,7).equals("Sep")))
			{
				month = "9";
			}if((bvc.getbDateTime().substring(4,7).equals("Oct")))
			{
				month = "10";
			}if((bvc.getbDateTime().substring(4,7).equals("Nov")))
			{
				month = "11";
			}if((bvc.getbDateTime().substring(4,7).equals("Dec")))
			{
				month = "12";
			}
			cal1.set(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
			String returndate = new Date().toString();
			
			System.out.println(returndate.substring(24, 28)+" "+returndate.substring(8, 10)+" "+returndate.substring(4, 7));
			String year1 = returndate.substring(24, 28);
			
			String month1="";
			String day1 = returndate.substring(8, 10);
			if(returndate.substring(4,7).equals("Jan"))
			{
				month1 = "1";
			}
			if(returndate.substring(4,7).equals("Feb"))
			{
				month1 = "2";
			}if(returndate.substring(4,7).equals("Mar"))
			{
				month1 = "3";
			}if(returndate.substring(4,7).equals("Apr"))
			{
				month1 = "4";
			}if(returndate.substring(4,7).equals("May"))
			{
				month1 = "5";
			}if(returndate.substring(4,7).equals("Jun"))
			{
				month1 = "6";
			}if(returndate.substring(4,7).equals("Jul"))
			{
				month1 = "7";
			}if(returndate.substring(4,7).equals("Aug"))
			{
				month1 = "8";
			}if(returndate.substring(4,7).equals("Sep"))
			{
				month1 = "9";
			}if(returndate.substring(4,7).equals("Oct"))
			{
				month1 = "10";
			}if(returndate.substring(4,7).equals("Nov"))
			{
				month1 = "11";
			}if(returndate.substring(4,7).equals("Dec"))
			{
				month1 = "12";
			}
			cal2.set(Integer.parseInt(year1), Integer.parseInt(month1), Integer.parseInt(day1));
			
			int dayscount = daysBetween(cal1.getTime(), cal2.getTime());
			System.out.println("Dayscount "+dayscount);
			
			if(dayscount> -1)
			{
				double i3 = (Double)(dayscount*0.20);
				borrowVO.setFine(i3);
			}
			else
			{
				System.out.println("Not greater than 21");
				borrowVO.setFine(bvc.getFine());
			}
			borrowVO.setrDateTime(returndate);
			
			
			System.out.println("jjjjj");
//			borrowVO.setFine(bvc.getFine());
			System.out.println(returndate);
			borrowdao borrowdao = new borrowdao();
			borrowdao.update(borrowVO);
			numofcopyVO nmcpy = new numofcopyVO();
			nmcpy.setBookID(Long.parseLong(bookidforreturn));
			nmcpy.setBranchID(Long.parseLong(request.getParameter("branchretrived")));
			System.out.println("aaaaaaaaaaa "+bookidforreturn+" bbbbbbb "+branchID);
			List ls  = numofcopydao.bookcopysearchforreturn(nmcpy);
			
			numofcopyVO numvo = (numofcopyVO)ls.get(0);
			Long coppy = numvo.getCopy();
			coppy = coppy+1;
			Long coppyid =numvo.getNumofcopyID();
			numvo.setBookID(numvo.getBookID());
			numvo.setNumofcopyID(numvo.getNumofcopyID());
			numvo.setBranchID(numvo.getBranchID());
			numvo.setCopy(coppy);
			numofcopydao.updatecopy(numvo);	
			
			session.setAttribute("successfully returned", "returned");
		}
		else
		{
			session.setAttribute("oppps", "returned");
		}
		response.sendRedirect("view/htm/Reader_MainPage.jsp");
		
}

	private int daysBetween(Date d1, Date d2) {
		// TODO Auto-generated method stub
		return (int) ((d2.getTime() - d1.getTime())/(1000 * 60 * 60 *24 ));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("pppppppppppppppppp");
		String flag = request.getParameter("flag");
		if(flag!=null && flag.equals("Reservenewbook"))
		{
			System.out.println("asdsjdfaskdbfbdsjfbasdbfhads");
			reservebook(request , response);
		}
		if(flag!=null && flag.equals("borrownewbook"))
		{
			System.out.println("asdsjdfaskdbfbdsjfbasdbfhads");
			try {
				borrownewbook(request , response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(flag!=null && flag.equals("returnbook"))
		{
			System.out.println("asdsjdfaskdbfbdsjfbasdbfhads");
			try {
				returnonebook(request , response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
