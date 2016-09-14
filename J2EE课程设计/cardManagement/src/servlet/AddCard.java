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
import vo.user;
import dao.CardDao;

public class AddCard extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddCard() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		PageAtt pa = (PageAtt) session.getAttribute("pageAtt");
		user u = (user) session.getAttribute("user");
		Card c = new Card();
		CardDao cd=new CardDao();
		String tab = request.getParameter("tab");
		if (tab != null)
			pa.setMessage(tab);
		else
			pa.setMessage("c_card");
		c.setName(request.getParameter("name"));
		c.setSex(request.getParameter("sex"));
		c.setPhone(request.getParameter("phone"));
		c.setEmail(request.getParameter("email"));
		c.setAddress(request.getParameter("address"));
		cd.add(c, pa.getMessage(), u.getId());
		request.setAttribute("message", "Ìí¼Ó³É¹¦");
		request.setAttribute("pageAtt", pa);
		RequestDispatcher rd = request.getRequestDispatcher("/addCard.jsp");
		rd.forward(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
