package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.log;
import vo.PageAtt;
import vo.user;

public class UserLogin extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserLogin() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		user u = new user();
		u.setName(request.getParameter("name"));
		u.setPwd(request.getParameter("pwd"));
		log lg = new log();
		String message = "";
		try {

			int ans = lg.login(u);
			if (ans == -1) {
				message = "用户名不存在";
				request.setAttribute("message", message);
				RequestDispatcher rd = request
						.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
			} else if (ans == 0) {
				message = "密码不正确";
				request.setAttribute("message", message);
				RequestDispatcher rd = request
						.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
			} else if (ans == -2) {
				message = "有错误";
				request.setAttribute("message", message);
				RequestDispatcher rd = request
						.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
			} else {
				HttpSession session=request.getSession();
				u.setId(ans);
				session.setAttribute("name", u.getName());
				PageAtt pa=new PageAtt(u.getId());
				session.setAttribute("pageAtt",pa);
				session.setAttribute("user", u);
				RequestDispatcher rd = request
						.getRequestDispatcher("/main.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
