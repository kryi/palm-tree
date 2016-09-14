package action;

import vo.Card;
import vo.PageAtt;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.CardDao;

public class UpdateFindCard extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id;
	PageAtt pageAtt ;
	
	public PageAtt getPageAtt() {
		return pageAtt;
	}
	public void setPageAtt(PageAtt pageAtt) {
		this.pageAtt = pageAtt;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String execute() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		
		CardDao cd=new CardDao();
		pageAtt=(PageAtt) ctx.getSession().get("pageAtt");
		Card u=(Card) cd.findCardById(id, pageAtt.getMessage());
		ctx.put("card", u);
		return "updateCard";
	}
	
}
