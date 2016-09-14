package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import service.rigiser;
import vo.user;

public class UserRigister extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserRigister() {
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
		rigiser rg = new rigiser();
		String message = "";
		try {
			if (rg.register(u))
				message = "注册成功";
				 else 
				message = "用户已经存在";
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			request.setAttribute("message", message);
			RequestDispatcher rd = request
					.getRequestDispatcher("/register.jsp");
			rd.forward(request, response);
		}
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
