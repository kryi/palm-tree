package service;

import vo.user;
import dao.UserDao;

public class log {

	public int login(user u) {
		UserDao ud=new UserDao();
		user su=null;
		try{
			su=ud.finduser(u.getName());
			if(su==null)
				return -1;//�û�������
			else if(u.getPwd().equals(su.getPwd()))
				return su.getId();
			return 0;//���벻��ȷ
		}catch(Exception e){
			e.printStackTrace();
			return -2;
		}
	}

}
