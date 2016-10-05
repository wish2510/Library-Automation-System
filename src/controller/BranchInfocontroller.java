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
import dao.branchajaxdao;
import dao.readerdao;
import dao.reservedao;
import dao.userlogindao;
import vo.adminloginVO;
import vo.borrowVO;
import vo.branchVO;
import vo.readerVO;
import vo.reserveVO;

/**
 * Servlet implementation class Logincontroller
 */
@WebServlet("/BranchInfocontroller")
public class BranchInfocontroller extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BranchInfocontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
String flag = request.getParameter("flag");
		
		if(flag!=null && flag.equals("frequantborrower"))
		{
			
			frequentborrower(request, response);
		}
		if(flag!=null && flag.equals("mostborrowed"))
		{
			
			mostborrow(request, response);
		}
		if(flag!=null && flag.equals("averagefine"))
		{
			averagefine(request, response);
		}
		
	}
	private void averagefine(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		borrowVO borrowVO = new borrowVO();
		borrowdao borrowdao = new borrowdao();
		
		List<Object[]> l = borrowdao.averagefine(borrowVO);
		HttpSession session = request.getSession();
		session.setAttribute("meme2", l);
		System.out.println("zzzzzzzzzzxxxxxxxxxxxxxxxccccccccccc"+l.size());
		response.sendRedirect("view/htm/averagefine.jsp");
			
	}


	private void BranchInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String branchid = request.getParameter("branchretrived");
		System.out.println("nf adhfhasfkjasdnfkjasdnfkjn"+branchid);
		branchVO branchVO = new branchVO();
		branchVO.setBranchID(Long.parseLong(branchid));
		branchajaxdao branchajaxdao = new branchajaxdao();
		List ls = branchajaxdao.search(branchVO);
		System.out.println("myyyyyyyyyy"+ls.size());
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("branchinfo", ls);
		System.out.println("fadfadsf");
		response.sendRedirect("view/htm/admin_BranchInfodisplay.jsp");
			
	}

	private void frequentborrower(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		borrowVO borrowVO = new borrowVO();
		borrowdao borrowdao = new borrowdao();
		
		List<Object[]> l = borrowdao.frequnatborrow(borrowVO);
		HttpSession session = request.getSession();
		session.setAttribute("meme", l);
		System.out.println("zzzzzzzzzzxxxxxxxxxxxxxxxccccccccccc"+l.size());
		for (Object[] object : l) {
			System.out.println("andar");
			String s =(String) object[0];
			
			Long count = (Long)(object[1]);
			System.out.println(s+"---"+count);
		}
		response.sendRedirect("view/htm/admin_freqborrower.jsp");
			
	}

	private void mostborrow(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		borrowVO borrowVO = new borrowVO();
		borrowdao borrowdao = new borrowdao();
		
		List<Object[]> l = borrowdao.mostborrow(borrowVO);
		HttpSession session = request.getSession();
		session.setAttribute("meme1", l);
		System.out.println("zzzzzzzzzzxxxxxxxxxxxxxxxccccccccccc"+l.size());
		for (Object[] object : l) {
			System.out.println("andar");
			String s =(String) object[0];
			
			Long count = (Long)(object[1]);
			System.out.println(s+"---"+count);
		}
		response.sendRedirect("view/htm/admin_mostborrowed.jsp");
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag = request.getParameter("flag");
		
		if(flag!=null && flag.equals("BranchInfo"))
		{
			
			BranchInfo(request, response);
		}
		
	}

	
}
