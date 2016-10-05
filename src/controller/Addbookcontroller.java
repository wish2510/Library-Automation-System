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
import dao.numofcopydao;
import dao.readerdao;
import dao.reservedao;
import dao.userlogindao;
import vo.adminloginVO;
import vo.borrowVO;
import vo.numofcopyVO;
import vo.readerVO;
import vo.reserveVO;

/**
 * Servlet implementation class Logincontroller
 */
@WebServlet("/Addbookcontroller")
public class Addbookcontroller extends HttpServlet {
String id1234 = null;
String id12345 = null;


	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addbookcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String flag = request.getParameter("flag");
		
		if(flag!=null && flag.equals("addexistbook"))
		{

			addexistbook(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag = request.getParameter("flag");
		if(flag!=null && flag.equals("addexistbook"))
		{
			addexistbook(request , response);
		}
		
	}

	private void addexistbook(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

		String isbn = request.getParameter("bookid");
		String branch = request.getParameter("branchid");
		String numofcopy = request.getParameter("numcopy");

		numofcopyVO numofcopyVO = new numofcopyVO();
		numofcopyVO.setBookID(Long.parseLong(isbn));
		numofcopyVO.setBranchID(Long.parseLong(branch));
		
		numofcopydao numofcopydao =  new numofcopydao();
		List lslsls = numofcopydao.getcopy(numofcopyVO);

		numofcopyVO numcpy2 = (numofcopyVO) lslsls.get(0);
		numofcopyVO.setBookID(numcpy2.getBookID());
		numofcopyVO.setBranchID(numcpy2.getBranchID());
		numofcopyVO.setCopy(Long.parseLong(numofcopy));
		
		numofcopydao.updatecopy(numofcopyVO);
		HttpSession session = request.getSession();
		session.setAttribute("existBookAdded", "success");
		response.sendRedirect("view/htm/AdminMainPage.jsp");	
	}

}
