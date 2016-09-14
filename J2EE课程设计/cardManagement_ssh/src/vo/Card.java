package vo;

public class Card extends AbstractCard{

	public Card(){
		super();
	}
	public Card(String name, String sex, String phone, String email,
			String address) {
		super(name,sex,phone,email,address);
	}
	public Card(AbstractCard c){
		super(c.getName(),c.getSex(),c.getPhone(),c.getEmail(),c.getAddress());
		this.id=c.getId();
		this.userId=c.getUserId();
	}

}
