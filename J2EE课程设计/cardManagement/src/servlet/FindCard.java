package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.PageAtt;
import vo.user;
import dao.CardDao;

public class FindCard extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FindCard() {
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
		String text=new String(request.getParameter("text").getBytes("ISO-8859-1"),"UTF-8");
		HttpSession session = request.getSession();
		
		System.out.println("find");
		System.out.println("text"+text);
		PageAtt pa = (PageAtt) session.getAttribute("pageAtt");
		user u=(user)session.getAttribute("user");
		if(pa==null)
			pa=new PageAtt(u.getId());
		String strPageNo = request.getParameter("pageNo");
		String strSort = request.getParameter("sort");
		String strCondition=request.getParameter("condition");
		String strPageSize = request.getParameter("pageSize");
		String strOrder = request.getParameter("order");
		String StrTab = request.getParameter("tab");
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
		if(strCondition!=null)
			pa.setCondition(strCondition);
		System.out.println("pageNo="+strPageNo+" sort="+strSort+" pageSize="+strPageSize+" order="+strOrder+" tab="+StrTab+" condition="+strCondition+" text="+text);
		CardDao cd = new CardDao();
		request.setAttribute("cardlist", cd.findUser(pa,text));
		session.setAttribute("pageAtt", pa);
		request.setAttribute("text", text);
		RequestDispatcher rd = request.getRequestDispatcher("/view.jsp");
		rd.forward(request, response);

	}
	public void init() throws ServletException {
		// Put your code here
	}

}
