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
				return -1;//用户不存在
			else if(u.getPwd().equals(su.getPwd()))
				return su.getId();
			return 0;//密码不正确
		}catch(Exception e){
			e.printStackTrace();
			return -2;
		}
	}

}
