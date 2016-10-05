package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.addnewbookdao;
import dao.addnewuserdao;
import dao.adminlogindao;
import dao.numofcopydao;
import vo.adminloginVO;
import vo.bookVO;
import vo.numofcopyVO;
import vo.readerVO;

/**
 * Servlet implementation class Logincontroller2
 */
@WebServlet("/Logincontroller2")
public class Logincontroller2 extends HttpServlet {
String id1234 = null;


	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logincontroller2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag = request.getParameter("flag");
		if(flag!=null && flag.equals("AddNewBook"))
		{
			addNewBook(request , response);
		}
		
	}

	private void addNewBook(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		System.out.println("Hello");
		System.out.println("pppppppppppp");
		String branretr = request.getParameter("branchretrived");
		String booktitlename = request.getParameter("booktitle");
		String authornameretrived = request.getParameter("authorretrived");
		String publisherretrived = request.getParameter("publisherretrived");
		String publicationdate = request.getParameter("pubDate");
		String issbn = request.getParameter("isbn");
		String numofcpy = request.getParameter("numcopy");
		System.out.println(branretr + booktitlename+authornameretrived+publicationdate+publisherretrived);
		
		bookVO bookVO = new bookVO();
		bookVO.setBookTitle(booktitlename);
		bookVO.setIsbn(issbn);
		bookVO.setPublisherID(Long.parseLong(publisherretrived));
		bookVO.setAuthorID(Long.parseLong(authornameretrived));
		bookVO.setPubDate(publicationdate);
		
		addnewbookdao addnewbookdao = new addnewbookdao();
		addnewbookdao.insert(bookVO);
		
		numofcopyVO numofcopyVO = new numofcopyVO();
		numofcopyVO.setBranchID(Long.parseLong(branretr));
		numofcopyVO.setCopy(Long.parseLong(numofcpy));
		numofcopyVO.setBookID(bookVO.getBookID());
		numofcopydao numofcopydao = new numofcopydao();
		numofcopydao.insert(numofcopyVO);
		
		session.setAttribute("BookAdded","Book Added successfully");
		response.sendRedirect("view/htm/AdminMainPage.jsp");
	}

}
