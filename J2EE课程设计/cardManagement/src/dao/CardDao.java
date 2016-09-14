package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.Card;
import vo.PageAtt;
import dbc.jdbcUtils;

public class CardDao {

	// 查找一整页的名片并按要求排序
	public ArrayList<Card> findAllUser(PageAtt pa) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int stno = pa.getPageNo() * pa.getPageSize();
		ArrayList<Card> cardList = new ArrayList<Card>();
		try {
			conn = jdbcUtils.getConnection();
			String sql = "select * from " + pa.getMessage()
					+ " where userId  = ? order by " + pa.getSortAtt() + " "
					+ pa.getOrder() + " limit ?,?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pa.getUserId());
			ps.setInt(2, stno);
			ps.setInt(3, pa.getPageSize());
			rs = ps.executeQuery();
			System.out.println("sql=" + sql);
			while (rs.next()) {
				Card u = new Card();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setSex(rs.getString(3));
				u.setPhone(rs.getString(4));
				u.setEmail(rs.getString(5));
				u.setAddress(rs.getString(6));
				cardList.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbcUtils.close2(rs, ps, conn);
		}
		return cardList;
	}

	// 名片添加
	public void add(Card c, String tab, int UserId) {

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = jdbcUtils.getConnection();
			System.out.println(tab);
			String sql = "insert into "
					+ tab
					+ "(name,sex,phone,email,address,userId)  values (?,?,?,?,?,?) ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, c.getName());
			ps.setString(2, c.getSex());
			ps.setString(3, c.getPhone());
			ps.setString(4, c.getEmail());
			ps.setString(5, c.getAddress());
			ps.setInt(6, UserId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbcUtils.close1(ps, conn);
		}
	}

	public void add(String id, Card c, String tab, int UserId) {

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = jdbcUtils.getConnection();
			System.out.println(tab);
			String sql = "insert into "
					+ tab
					+ "(id,name,sex,phone,email,address,userId)  values (?,?,?,?,?,?,?) ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(id));
			ps.setString(2, c.getName());
			ps.setString(3, c.getSex());
			ps.setString(4, c.getPhone());
			ps.setString(5, c.getEmail());
			ps.setString(6, c.getAddress());
			ps.setInt(7, UserId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbcUtils.close1(ps, conn);
		}
	}

	public ArrayList<Card> findUser(PageAtt pa, String cd) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int stno = pa.getPageNo() * pa.getPageSize();
		ArrayList<Card> cardList = new ArrayList<Card>();
		try {
			conn = jdbcUtils.getConnection();
			System.out.println(cd);
			String sql = "select * from " + pa.getMessage()
					+ " where userId  = ? and " + pa.getCondition()
					+ " like \"%" + cd + "%\"order by " + pa.getSortAtt() + " "
					+ pa.getOrder() + " limit ?,?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pa.getUserId());
			ps.setInt(2, stno);
			ps.setInt(3, pa.getPageSize());
			System.out.println("sql=" + sql);
			rs = ps.executeQuery();
			System.out.println(stno + " " + pa.getPageSize());
			while (rs.next()) {
				Card u = new Card();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setSex(rs.getString(3));
				u.setPhone(rs.getString(4));
				u.setEmail(rs.getString(5));
				u.setAddress(rs.getString(6));
				cardList.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbcUtils.close2(rs, ps, conn);
		}
		return cardList;
	}

	public Card findCardById(String id, String tab) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Card u = null;
		try {
			conn = jdbcUtils.getConnection();
			String sql = "select * from " + tab + " where id  = ? ";
			ps = conn.prepareStatement(sql);
			System.out.println("id===="+id);
			ps.setInt(1, Integer.parseInt(id));
			System.out.println("sql=" + sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				u = new Card();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setSex(rs.getString(3));
				u.setPhone(rs.getString(4));
				u.setEmail(rs.getString(5));
				u.setAddress(rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbcUtils.close2(rs, ps, conn);
		}
		return u;
	}

	public void delete(String id, String tab) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = jdbcUtils.getConnection();
			String sql = "delete from " + tab + " where id=?";
			ps = conn.prepareStatement(sql);
			System.out.println("id=" + id);
			ps.setInt(1, Integer.parseInt(id));
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbcUtils.close1(ps, conn);
		}
	}

	public void update(Card c, String tab) throws Exception {// 用户信息的更新
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = jdbcUtils.getConnection();
			System.out.println("table=" + tab);
			String sql = "update " + tab
					+ " set name=?,sex=?,phone=?,email=?,address=? where id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, c.getName());
			ps.setString(2, c.getSex());
			ps.setString(3, c.getPhone());
			ps.setString(4, c.getEmail());
			ps.setString(5, c.getAddress());
			ps.setInt(6, c.getId());
			ps.executeUpdate();
		} finally {
			jdbcUtils.close1(ps, conn);
		}
	}

	public int count(PageAtt pa) {
		Connection conn = null;
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 int recordCount=0;
		 try{
			 conn = jdbcUtils.getConnection();
				String sql = "select count(*) from "+pa.getMessage()+" where userId="+pa.getUserId();
				ps=conn.prepareStatement(sql);
				rs=ps.executeQuery();
				rs.next();
				recordCount=rs.getInt(1);
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			 jdbcUtils.close1(ps, conn);
		 }
		return recordCount;
		
	}

}
