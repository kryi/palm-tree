package service;

import vo.User;
import dao.UserDao;

public class Log {

	public int login(User u) {
		UserDao ud=new UserDao();
		User su=null;
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
