package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.PageAtt;
import dao.CardDao;

public class DeleteRecCard extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DeleteRecCard() {
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
		String id[]=request.getParameterValues("id");
		
		CardDao cd=new CardDao();
		HttpSession session=request.getSession();
		PageAtt pa=(PageAtt)session.getAttribute("pageAtt");
			try{
				for(int i=0;i<id.length;i++)
				cd.delete(id[i],pa.getMessage());
				request.setAttribute("message","É¾³ý³É¹¦");
				RequestDispatcher rd = request.getRequestDispatcher("/servlet/FindAllCard");
			       rd.forward(request,response);
			       
			}catch(Exception e){
			      e.printStackTrace();
			     
		    }
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
