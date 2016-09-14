package action;

import vo.Card;
import vo.PageAtt;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.CardDao;

public class AddCard extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PageAtt pageAtt;
	String name, sex, phone, email, address, tab;
	
	public PageAtt getPageAtt() {
		return pageAtt;
	}

	public void setPageAtt(PageAtt pageAtt) {
		this.pageAtt = pageAtt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name=name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getTab() {
		return tab;
	}

	public void setTab(String tab) {
		this.tab = tab;
	}

	@Override
	public String execute() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		pageAtt=(PageAtt) ctx.getSession().get("pageAtt");
		if (tab != null)
			pageAtt.setMessage(tab);
		else
			pageAtt.setMessage("Card");
		Card c = new Card(name, sex, phone, email, address);
		c.setUserId(pageAtt.getUserId());
		
		CardDao cd = new CardDao();
		System.out.println("addname="+name);
		cd.add(c, "RecCard");
		ctx.put("message", "Ìí¼Ó³É¹¦");
		ctx.getSession().put("pageAtt", pageAtt);
		return "add";

	}

}
