package action;

import vo.AbstractCard;
import vo.PageAtt;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.CardDao;

public class UpdateCard extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id, name, phone, sex, email, address;
	PageAtt pageAtt;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public PageAtt getPageAtt() {
		return pageAtt;
	}

	public void setPageAtt(PageAtt pageAtt) {
		this.pageAtt = pageAtt;
	}

	@Override
	public String execute() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		AbstractCard ac = new AbstractCard(name, sex, phone, email,
				address);
		CardDao cd = new CardDao();

		pageAtt = (PageAtt) ctx.getSession().get("pageAtt");
		System.out.println("-----------"+sex);
		ac.setId(Integer.parseInt(id));
		ac.setUserId(pageAtt.getUserId());
		try {
			cd.update(ac, pageAtt.getMessage());
			ctx.put("message", "更新成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ctx.put("message", "更新失败");
		}
		return "updateCard";

	}

}
