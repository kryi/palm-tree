package action;

import vo.AbstractCard;
import vo.PageAtt;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.CardDao;

public class DeleteCard extends ActionSupport {

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

	@Override
	public String execute() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		CardDao cd = new CardDao();
		pageAtt = (PageAtt) ctx.getSession().get("pageAtt");

		AbstractCard c[] = new AbstractCard[id.length];
		for (int i = 0; i < id.length; i++) {
			c[i] = (AbstractCard) cd.findCardById(id[i], pageAtt.getMessage());
		}
		cd.delete(pageAtt.getMessage(), id);
		
		for (int i = 0; i < id.length; i++)
			cd.add(c[i], pageAtt.getMessage());
		ctx.put("message", "²Ù×÷Íê³É");
		return "FindAllCard";
	}

}
