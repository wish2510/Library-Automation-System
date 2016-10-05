package controller;

import java.io.IOException;
import java.io.ObjectOutputStream.PutField;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.numofcopydao;
import vo.bookVO;
import vo.branchVO;
import vo.numofcopyVO;
import vo.publisherVO;


@WebServlet("/searchbyidcontroller")
public class searchbyidcontroller extends HttpServlet {


	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchbyidcontroller() {
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
		
	}

	private void searchbyid(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String bookid = request.getParameter("searchbyidd");
		
		numofcopyVO numofcopyVO = new numofcopyVO();

		numofcopyVO.setBookID(Long.parseLong(bookid));
		
		numofcopydao numofcopydao = new numofcopydao();

		List cppp = numofcopydao.searchbyiid(numofcopyVO);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("serhbyid", cppp);
		
		response.sendRedirect("view/htm/reader_searchbyID2display.jsp");
	}
	
	private void searchbytitle(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("searchbytit");
		
		
		bookVO bookVO = new bookVO();
		bookVO.setBookTitle(title);
		
		numofcopydao numofcopydao = new numofcopydao();
		
		numofcopydao.searchbytitle(bookVO);
		List srchbytit = numofcopydao.searchbytitle(bookVO);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("srchbytit", srchbytit);
		
		response.sendRedirect("view/htm/reader_searchbytitle2display.jsp");
	}
	
	
	private void searchbypublisher(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("searchbypub");
		
		publisherVO pubVO = new publisherVO();
		pubVO.setPublisherName(title);
		
		numofcopydao numofcopydao = new numofcopydao();
		

		List srchbytit = numofcopydao.searchbypublisher(pubVO);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("srchbypub", srchbytit);
		
		response.sendRedirect("view/htm/reader_searchbypublisher2display.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("pppppppppppppppppp");
		String flag = request.getParameter("flag");
		if(flag!=null && flag.equals("searchbyID"))
		{
			System.out.println("asdsjdfaskdbfbdsjfbasdbfhads");
			searchbyid(request , response);
		}
		if(flag!=null && flag.equals("searchbytitle"))
		{
			System.out.println("asdsjdfaskdbfbdsjfbasdbfhads");
			searchbytitle(request , response);
		}
		
		if(flag!=null && flag.equals("searchbypublisher"))
		{
			System.out.println("asdsjdfaskdbfbdsjfbasdbfhads");
			searchbypublisher(request , response);
		}
		if(flag!=null && flag.equals("adminsearchbytitle"))
		{
			System.out.println("asdsjdfaskdbfbdsjfbasdbfhads");
			searchbyidadmin(request , response);
		}		
	}
	private void searchbyidadmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("vvvv");
		System.out.println("titititiiiiiiiiiiiiitttttttt"+title);
		bookVO bookVO = new bookVO();
		bookVO.setBookTitle(title);
		
		numofcopydao numofcopydao = new numofcopydao();
		
		numofcopydao.searchbytitle(bookVO);
		List srchbyidd = numofcopydao.searchbytitle(bookVO);
		
		HttpSession session3 = request.getSession();
		
		session3.setAttribute("srchbyiddddd", srchbyidd);
		
		response.sendRedirect("view/htm/AdminSearchByID.jsp");
	}
	
}
