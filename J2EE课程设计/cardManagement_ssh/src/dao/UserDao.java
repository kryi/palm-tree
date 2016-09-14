package dao;

import org.hibernate.Session;

import vo.User;
import dbc.HibernateUtil;

public class UserDao {
	// 登录用户的注册
	public void add(User u) throws Exception {
		HibernateUtil.getCurrentSession().save(u);
	}

	// 登录用户的查找
	public User finduser(String name) throws Exception {
		Session s = HibernateUtil.getCurrentSession();
		String hql = "from User where name=:Name";
		User u = (User) s.createQuery(hql).setParameter("Name", name)
				.uniqueResult();
		
		return u;
	}
}
