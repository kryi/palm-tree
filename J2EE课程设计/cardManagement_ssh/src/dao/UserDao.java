package dao;

import org.hibernate.Session;

import vo.User;
import dbc.HibernateUtil;

public class UserDao {
	// ��¼�û���ע��
	public void add(User u) throws Exception {
		HibernateUtil.getCurrentSession().save(u);
	}

	// ��¼�û��Ĳ���
	public User finduser(String name) throws Exception {
		Session s = HibernateUtil.getCurrentSession();
		String hql = "from User where name=:Name";
		User u = (User) s.createQuery(hql).setParameter("Name", name)
				.uniqueResult();
		
		return u;
	}
}
