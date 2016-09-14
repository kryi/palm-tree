package vo;

public class PageAtt {
	private int userId, PageNo, PageSize;
	private String Order, sortAtt, message,condition;

	public PageAtt(int userId) {
		super();
		this.userId = userId;
		PageNo = 0;
		PageSize = 10;
		Order = "asc";
		sortAtt = "id";
		message="c_card";
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getPageNo() {
		return PageNo;
	}

	public void setPageNo(int pageNo) {
		PageNo = pageNo;
	}

	public int getPageSize() {
		return PageSize;
	}

	public void setPageSize(int pageSize) {
		PageSize = pageSize;
	}

	public String getOrder() {
		return Order;
	}

	public void setOrder(String order) {
		Order = order;
	}

	public String getSortAtt() {
		return sortAtt;
	}

	public void setSortAtt(String sortAtt) {
		this.sortAtt = sortAtt;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
