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

public class FindAllCard extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FindAllCard() {
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
		String strPageNo = request.getParameter("pageNo");
		String strSort = request.getParameter("sort");
		String strPageSize = request.getParameter("pageSize");
		String strOrder = request.getParameter("order");
		String StrTab = request.getParameter("tab");
		System.out.println("pageNo"+strPageNo+"sort "+strSort+"pageSize "+strPageSize+"order "+strOrder+"tab="+StrTab);
		if (strPageNo != null)
			pa.setPageNo(Integer.parseInt(strPageNo));
		if (strSort != null)
			pa.setSortAtt(strSort);
		if (strPageSize != null)
			pa.setPageSize(Integer.parseInt(strPageSize));
		if (strOrder != null)
			pa.setOrder(strOrder);
		if (StrTab != null)
			pa.setMessage(StrTab);
		CardDao cd = new CardDao();
		request.setAttribute("cardlist", cd.findAllUser(pa));
		request.setAttribute("count", cd.count(pa));
		session.setAttribute("pageAtt", pa);
		if(pa.getMessage().equals("c_card"))
		{
				RequestDispatcher rd = request.getRequestDispatcher("/view.jsp");
				rd.forward(request, response);
		}
		else 
		{
			RequestDispatcher rd = request.getRequestDispatcher("/viewRec.jsp");
			rd.forward(request, response);
		}
		
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
