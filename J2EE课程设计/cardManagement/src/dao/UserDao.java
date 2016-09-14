package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.user;
import dbc.jdbcUtils;

public class UserDao {
	//登录用户的注册
	public void add(user u) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = jdbcUtils.getConnection();
			System.out.println(u.getName() + " " + u.getPwd());
			String sql = "insert into c_user(userName,password)  values (?,?) ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getPwd());

			ps.executeUpdate();
		} finally {
			jdbcUtils.close1(ps, conn);
		}
	}

	// 登录用户的查找
	public user finduser(String name) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		user u = null;
		try {
			conn = jdbcUtils.getConnection();
			String sql = "select * from c_user where userName=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
//			System.out.println(rs.next());
			if (rs.next()) {
				u = new user();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setPwd(rs.getString(3));
			}
		} finally {
			jdbcUtils.close2(rs, ps, conn);
		}
		return u;
	}
}
