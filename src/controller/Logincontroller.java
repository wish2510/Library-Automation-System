package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.addnewuserdao;
import dao.adminlogindao;
import dao.borrowdao;
import dao.readerdao;
import dao.reservedao;
import dao.userlogindao;
import vo.adminloginVO;
import vo.borrowVO;
import vo.readerVO;
import vo.reserveVO;

/**
 * Servlet implementation class Logincontroller
 */
@WebServlet("/Logincontroller")
public class Logincontroller extends HttpServlet {
String id1234 = null;
String id12345 = null;


	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logincontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String flag = request.getParameter("flag");

		if(flag!=null && flag.equals("Loginsearch"))
		{
			System.out.println("1111");
			loginsearch(request, response);
		}
		if(flag!=null && flag.equals("readersearch"))
		{
			System.out.println("Joi je anhi avi j gayu hase");
			readersearch(request,response);
		}
		
	}
	public void readersearch(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String readerrID = request.getParameter("readerid");
		
		readerVO readerVO = new readerVO();
		readerVO.setReaderID(Long.parseLong(readerrID));
		
		userlogindao userlogindao = new userlogindao();
		List useridretried = userlogindao.searchreader(readerVO);
		
		HttpSession session3 = request.getSession();
		session3.setAttribute("readerrrriidd", useridretried);
		if(useridretried.size()>0)
		{
			System.out.println("User found");
			readerVO = (readerVO)useridretried.get(0);
			String useid = readerVO.getReaderID().toString();
			id12345 = useid;
			session3.setAttribute("id1234_f",id1234);
			
			retrivedataofuser(request, response);
			response.sendRedirect("view/htm/Reader_MainPage.jsp");
		}
		
	}

	private void retrivedataofuser(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
			
			readerVO readerVO = new readerVO();
			readerdao readerdao = new readerdao();
			
			borrowVO borrowVO1 = new borrowVO();
			borrowdao borrowdao = new borrowdao();
			
			reserveVO reserveVO = new reserveVO();
			reservedao reservedao = new reservedao();
			
			borrowVO vrVO = new borrowVO();
			borrowdao2 borrowdao2 = new borrowdao2();
			
			HttpSession session = request.getSession();

			readerVO.setReaderID(Long.parseLong(id12345));
			borrowVO1.setReaderID(Long.parseLong(id12345));
			reserveVO.setReaderID(Long.parseLong(id12345));
			vrVO.setReaderID(Long.parseLong(id12345));
			
//			List readerDs = readerdao.searchreaderdata(readerVO);
			List reservDs = reservedao.searchreaderreservedata(reserveVO);
			List borrowDs = borrowdao.searchreaderborrowdata(borrowVO1);
			
			//			List borrow = borrowdao2.getborrodetil(vrVO);
			System.out.println(reservDs.size());
//			session.setAttribute("lisred", readerDs);
			session.setAttribute("lisredres", reservDs);
			session.setAttribute("lsredbor", borrowDs);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag = request.getParameter("flag");
		if(flag!=null && flag.equals("AddNewReader"))
		{
			addNewUser(request , response);
		}
		
	}

	private void addNewUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String rdrName = request.getParameter("Name");
		String rdrAddress = request.getParameter("Address");
		String rdrPhone = request.getParameter("Phone");
		System.out.println(rdrName);
		readerVO rdrVO =  new readerVO();
		rdrVO.setReaderName(rdrName);
		rdrVO.setAddress(rdrAddress);
		rdrVO.setPhone(rdrPhone);
		
		addnewuserdao addnewuserdao1 = new addnewuserdao();
		List lsalreadyuser = addnewuserdao1.alreadyusersearch(rdrVO);

		HttpSession session1 = request.getSession();
		
		if(lsalreadyuser.size()>0)
		{

			session1.setAttribute("alreadyuser", "User Already available");	
		}
		else
		{
			addnewuserdao addnewuserdao = new addnewuserdao();
			addnewuserdao.insert(rdrVO);	
		}
		
		response.sendRedirect("view/htm/AdminMainPage.jsp");	
	}
	private void loginsearch(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		adminloginVO adminLoginVO = new adminloginVO();
		adminLoginVO.setUsername(username);
		adminLoginVO.setPassword(password);
		
		adminlogindao logindao =new adminlogindao();
		java.util.List ls = adminlogindao.loginsearch(adminLoginVO);
		
		HttpSession session =request.getSession();
		session.setAttribute("login", ls);
		
//		List ls123 =(List) session.getAttribute("lis");
		System.out.println("2222");
		System.out.println(ls.size());
		if(ls.size()>0)
		{
			adminLoginVO = (adminloginVO)ls.get(0);
			//String regtype=adminloginVO.getRegtype();
			String id = adminLoginVO.getAdminid().toString();
			id1234 = id;
			session.setAttribute("id1234_f",id1234);
			System.out.println(id);
//			search(request,response);

				
			response.sendRedirect("view/htm/AdminMainPage.jsp");
			
			
		}
		else
		{
			session.setAttribute("invalid","Wrong Username and Password!!");
			response.sendRedirect("view/htm/Login.jsp");
		}
	
	}

/*	
	public void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		
		UserRecorddao userRecorddao = new UserRecorddao();
		UserRecordVO userRecordVO = new UserRecordVO();
	
		adminlogindao userLogindao = new adminlogindao();
		adminloginVO loginVO = new adminloginVO();
		
		UserProfiledao userProfiledao = new UserProfiledao();
		UserProfileVO profileVO = new UserProfileVO();
		
		ShareRecordVO shareRecordVO = new ShareRecordVO();
		ShareRecorddao shareRecorddao = new ShareRecorddao();
		
		HttpSession session = request.getSession();
		
		shareRecordVO.setTrustedcontact(id1234);
		userRecordVO.setUserid(Long.valueOf(id1234));
		loginVO.setUserid(Long.valueOf((id1234)));
		profileVO.setUserid(Long.valueOf((id1234)));
		
		List ls = userRecorddao.search(userRecordVO);
		List ls1 = userLogindao.search(loginVO);
		List ls25 = shareRecorddao.searchtrustee(shareRecordVO);
		session.setAttribute("lis", ls);
		session.setAttribute("lis1", ls1);
		session.setAttribute("ls256", ls25);

		}	
	
*/
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	/*
	private void forgotusername(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String email= request.getParameter("emailaddress");
		String dob= request.getParameter("dob");
		adminloginVO uv = new adminloginVO();
		UserProfileVO upv = new UserProfileVO();
		adminlogindao ud = new adminlogindao();
		upv.setEmailprimary(email);
		upv.setBirthdate(dob);
		HttpSession session = request.getSession();
		
		List l = ud.fu(upv);
		if(l.size()>0)
		{
		upv= (UserProfileVO) l.get(0);
		uv.setUserid(upv.getUserid());
		List ls= 	ud.search(uv);
		Object[] ob =(Object[]) ls.get(0);
		uv= (adminloginVO) ob[0];
			
			
			String toemail = upv.getEmailprimary();
			//String comment = request.getParameter("comment");
			//String subject = request.getParameter("subject");	
	        java.util.Properties properties = new java.util.Properties();
	        properties.put("mail.smtp.auth", "true");
	        properties.put("mail.smtp.starttls.enable", "true");
	        javax.mail.Session mailSession = javax.mail.Session.getInstance(properties);
	        try {
	            MimeMessage message = new MimeMessage(mailSession);
	           // message.setContent("<a href='http:\\\\"+request.getRemoteHost()+"\\"+request.getContextPath()+"\\register\\loadRegistrationPage.htm?random="+ id +"'>Please click here to Activate SwapMeTv Account</a> ", "text/html");
	            message.setContent("<a target='_blank' style='cursor:pointer' href='http:\\\\"+request.getRemoteHost()+":8080\\"+request.getContextPath()+"\\temp.jsp?random="+ random +"'>Please click here to Activate Bank Account</a> ", "text/html");
	            message.setSubject("Confromation Mail");
	            message.setContent("Username is " + uv.getUsername(),"text/html");
	            InternetAddress sender = new InternetAddress("vishalpatel.ldce@gmail.com", "Health Records...");
	            InternetAddress receiver = new InternetAddress(toemail);
	            message.setFrom(sender);
	            message.setRecipient(Message.RecipientType.TO, receiver);          
	            message.saveChanges();
	            javax.mail.Transport transport = mailSession.getTransport("smtp");
	            transport.connect("smtp.gmail.com", 587, "vishalpatel.ldce@gmail.com", "bestin1991");
	            transport.sendMessage(message, message.getAllRecipients());
	            transport.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

		session.setAttribute("success", "Mail Is sent to you at your Email Address");	
			
		}
		else
		{

			session.setAttribute("error", "Sorryy!!! Your information doesn't Match");	
				
		}
		response.sendRedirect("view/ForgotPassword.jsp");
	}
*/

}
