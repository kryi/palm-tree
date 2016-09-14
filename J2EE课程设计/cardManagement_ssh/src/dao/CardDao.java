package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import vo.AbstractCard;
import vo.Card;
import vo.PageAtt;
import vo.RecCard;
import dbc.HibernateUtil;

public class CardDao {

	// 查找一整页的名片并按要求排序
	@SuppressWarnings("unchecked")
	public List<Card> findAllUser(PageAtt pageAtt) {
		Session s = HibernateUtil.getCurrentSession();
		List<Card> list = null;
		Criteria c = null;
		if (pageAtt.getMessage().equals("Card"))
			c = s.createCriteria(Card.class);
		else
			c = s.createCriteria(RecCard.class);
		c.add(Restrictions.eq("userId", pageAtt.getUserId()));
		list = c.list();
		return list;
	}

	// 名片添加
	public void add(AbstractCard c, String tab) {
		if (tab.equals("Card"))
			HibernateUtil.add(new RecCard(c));
		else
			HibernateUtil.add(new Card(c));
	}

	@SuppressWarnings("unchecked")
	public List<Card> findUser(PageAtt pageAtt, String cd) {
		Session s = HibernateUtil.getCurrentSession();
		List<Card> list = null;
		Criteria c = null;
		if (pageAtt.getMessage().equals("Card"))
			c = s.createCriteria(Card.class);
		else
			c = s.createCriteria(RecCard.class);
		c.add(Restrictions.eq("userId", pageAtt.getUserId()));
		c.add(Restrictions.like(pageAtt.getCondition(), "%" + cd + "%"));
		list = c.list();
		s.close();
		return list;
	}

	public Object findCardById(String id, String tab) {
		if (tab.equals("Card"))
			return HibernateUtil.getCurrentSession().get(Card.class,
					Integer.parseInt(id));
		return HibernateUtil.getCurrentSession().get(RecCard.class,
				Integer.parseInt(id));
	}

	public void delete(String tab, String... ids) {
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = null;
		tx=s.beginTransaction();
		if (tab.equals("Card")) {
			for (String id : ids) {
				System.out.println("id---------------------"+id);
				s.delete(s.load(Card.class, Integer.parseInt(id)));
			}

		} else {
			for (String id : ids){
				System.out.println("rec_id---------------------"+id);
				s.delete(s.load(RecCard.class, Integer.parseInt(id)));
			}
				
		}
		tx.commit();
		s.close();

	}

	public void update(Object c, String tab) throws Exception {// 用户信息的更新
		if (tab.equals("Card"))
			HibernateUtil.update((Card) c);
		else
			HibernateUtil.update((RecCard) c);
	}

	// public int count(PageAtt pa) {
	// Session s = HibernateUtil.getCurrentSession();
	// String hql = "select count(*) from " + pa.getMessage()
	// + " where userId = " + pa.getUserId();
	// Query query = s.createQuery(hql);
	// return (Integer) query.uniqueResult();
	//
	// }

}
