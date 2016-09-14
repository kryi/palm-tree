package action;

import vo.PageAtt;
import vo.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.CardDao;

public class FindCard extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String text, pageNo, sort, condition, pageSize, order, tab;
	User user;
	PageAtt pageAtt;
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getTab() {
		return tab;
	}

	public void setTab(String tab) {
		this.tab = tab;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		CardDao cd = new CardDao();

		pageAtt = (PageAtt) ctx.getSession().get("pageAtt");

		if (pageNo != null)
			pageAtt.setPageNo(Integer.parseInt(pageNo));
		if (sort != null)
			pageAtt.setSortAtt(sort);
		if (pageSize != null)
			pageAtt.setPageSize(Integer.parseInt(pageSize));
		if (order != null)
			pageAtt.setOrder(order);
		if (tab != null)
			pageAtt.setMessage(tab);
		if (condition != null)
			pageAtt.setCondition(condition);

		ctx.put("cardlist", cd.findUser(pageAtt, text));
		ctx.put("text", text);
		ctx.getSession().put("pageAtt", pageAtt);

		if (pageAtt.getMessage().equals("Card")) {
			return "view";
		} else
			return "viewRec";

	}

}
