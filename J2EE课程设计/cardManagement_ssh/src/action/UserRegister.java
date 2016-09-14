package action;

import service.rigiser;
import vo.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserRegister extends ActionSupport {

	/**
	 * 
	 */
	private String name,pwd;
	private static final long serialVersionUID = 1L;
	
	

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
		rigiser rg=new rigiser();
		User u=new User();
		u.setName(name);
		u.setPwd(pwd);
		ActionContext ctx = ActionContext.getContext();
		if(rg.register(u)){
			ctx.put("message","注册成功");
			return "success";
		}
			ctx.put("message", "用户已存在");
			return "defeat";
			
	}
	

}
