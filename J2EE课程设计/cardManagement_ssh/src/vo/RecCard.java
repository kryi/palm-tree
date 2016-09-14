package vo;

public class RecCard extends AbstractCard{	
	public RecCard(){
		super();
	}
	public RecCard(String name, String sex, String phone, String email,
			String address) {
		super(name,sex,phone,email,address);
	}
	public RecCard(AbstractCard c){
		super(c.getName(),c.getSex(),c.getPhone(),c.getEmail(),c.getAddress());
		this.id=c.getId();
		this.userId=c.getUserId();
	}
}
