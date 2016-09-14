package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.Card;
import vo.PageAtt;
import dao.CardDao;

public class UpdateFindCard extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public UpdateFindCard() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		CardDao cd=new CardDao();
		HttpSession session=request.getSession();
		PageAtt pa=(PageAtt)session.getAttribute("pageAtt");
		Card u=null;
		try{
			u=cd.findCardById(id,pa.getMessage());
			request.setAttribute("card", u);
			RequestDispatcher rd=request.getRequestDispatcher("/updateCard.jsp");
			rd.forward(request,response);
		}catch(Exception e){
		      e.printStackTrace();
	    }
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
