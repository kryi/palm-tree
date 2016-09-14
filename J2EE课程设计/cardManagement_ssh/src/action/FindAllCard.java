package action;

import java.util.List;

import vo.Card;
import vo.PageAtt;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.CardDao;

public class FindAllCard extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PageAtt pageAtt;
	private String pageNo, sort, pageSize, order, tab;

	public PageAtt getPageAtt() {
		return pageAtt;
	}

	public void setPageAtt(PageAtt pageAtt) {
		this.pageAtt = pageAtt;
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

	@Override
	public String execute() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		System.out.println("findAll= " + tab);
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

		CardDao cd = new CardDao();
		List<Card> list =cd.findAllUser(pageAtt);
		ctx.put("cardlist", list);
		ctx.put("count", list.size());
		ctx.getSession().put("pageAtt", pageAtt);
		if (pageAtt.getMessage().equals("Card"))
			return "view";
		else
			return "viewRec";
	}

}
