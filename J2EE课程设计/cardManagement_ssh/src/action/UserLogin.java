package action;

import service.Log;
import vo.PageAtt;
import vo.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserLogin extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name, pwd;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String execute() throws Exception {
		Log lg = new Log();
		User u = new User();
		u.setName(name);
		u.setPwd(pwd);
		ActionContext ctx = ActionContext.getContext();

		int ans = lg.login(u);
		System.out.println(ans);
		switch (ans) {
		case -2:
			ctx.put("message", "服务器未打开");
			return "defeat";
		case -1:
			ctx.put("message", "用户名不存在");
			return "defeat";
		case 0:
			ctx.put("message", "密码错误");
			return "defeat";
		default:
			u.setId(ans);
			PageAtt pa = new PageAtt(ans);
			ctx.getSession().put("user", u);
			ctx.getSession().put("pageAtt", pa);
			return "success";

		}

	}

}
