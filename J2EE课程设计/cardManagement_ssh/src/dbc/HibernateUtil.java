package dbc;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	public static final ThreadLocal<Session> session = new ThreadLocal<Session>();

	private HibernateUtil() {

	}

	static {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			Configuration cfg = new Configuration().configure();
			// hibernate3的方法
			// sessionFactory = new
			// Configuration().configure().buildSessionFactory();

			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
					.applySettings(cfg.getProperties()).buildServiceRegistry();
			sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("初始化SessionFactory失败！" + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session getCurrentSession() throws HibernateException {
		Session s = (Session) session.get();
		// 当原Session为空或已关闭时，打开一个新的Session
		if (s == null || !s.isOpen()) {
			s = sessionFactory.openSession();
			session.set(s);
		}
		return s;
	}

	public static void closeSession() throws HibernateException {
		Session s = (Session) session.get();
		session.set(null);
		if (s != null) {
			s.close();
		}
	}

	public static void add(Object entity) {
		Session s = null;
		Transaction tx = null;

		try {
			s = HibernateUtil.getCurrentSession();
			tx = s.beginTransaction();
			s.save(entity);
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (s != null)
				s.close();
		}

	}

	public static void update(Object entity) {
		Session s = null;
		Transaction tx = null;

		try {
			s = HibernateUtil.getCurrentSession();
			tx = s.beginTransaction();
			s.update(entity);
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (s != null)
				s.close();
		}

	}
}
