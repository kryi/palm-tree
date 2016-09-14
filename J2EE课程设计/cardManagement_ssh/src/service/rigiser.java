package service;

import vo.User;
import dao.UserDao;

public class rigiser {
	UserDao ud = new UserDao();
	public boolean register(User u)throws Exception
	{
		if(ud.finduser(u.getName())!=null)
				return false;
		ud.add(u);
		return true;
	}
}
