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
@WebServlet("/reservecopycontroller")
public class Reservecopycontroller extends HttpServlet {
String id1234 = null;
String id12345 = null;


	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reservecopycontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String flag = request.getParameter("flag");
		
		if(flag!=null && flag.equals("reserve"))
		{
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			reservesearch(request, response);
		}
		
	}
		private void reservesearch(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
			String id = request.getParameter("idn");
			HttpSession session = request.getSession();
			session.setAttribute("ID", id);
			
			response.sendRedirect("view/htm/Reader_BookReserve.jsp");
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

		
}
