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

public class UpdateCard extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UpdateCard() {
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
		Card ca=new Card();
		CardDao cd=new CardDao();
		PageAtt pa=null;
		HttpSession session=request.getSession();
		pa=(PageAtt)session.getAttribute("pageAtt");
		try {
			ca.setId(Integer.parseInt(request.getParameter("id")));
			ca.setName(request.getParameter("name"));
			ca.setPhone(request.getParameter("phone"));
			ca.setSex(request.getParameter("sex"));
			ca.setEmail(request.getParameter("email"));
			ca.setAddress(request.getParameter("address"));
			cd.update(ca,pa.getMessage());
			request.setAttribute("message","更新成功");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			request.setAttribute("message","更新失败");
		}
		request.setAttribute("user",ca);
		RequestDispatcher rd=request.getRequestDispatcher("/updateCard.jsp");
		rd.forward(request, response);
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
