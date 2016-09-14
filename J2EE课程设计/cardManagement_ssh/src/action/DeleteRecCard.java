package action;

import vo.PageAtt;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.CardDao;

public class DeleteRecCard extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id[];
	private PageAtt pageAtt;

	public String[] getId() {
		return id;
	}

	public void setId(String[] id) {
		this.id = id;
	}

	public PageAtt getPageAtt() {
		return pageAtt;
	}

	public void setPageAtt(PageAtt pageAtt) {
		this.pageAtt = pageAtt;
	}
	public String execute() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		CardDao cd=new CardDao();
		pageAtt=(PageAtt)ctx.getSession().get("pageAtt");
		System.out.println("tab-------------"+pageAtt.getMessage());
		cd.delete(pageAtt.getMessage(),id);
		ctx.put("message", "²Ù×÷Íê³É");
		return "FindAllCard";
	}
}
