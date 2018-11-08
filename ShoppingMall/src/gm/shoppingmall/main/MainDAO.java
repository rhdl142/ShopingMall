package gm.shoppingmall.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import gm.shoppingmall.main.util.DBUtil;

public class MainDAO {
	
	private Connection conn;
	
	
	public MainDAO() {
		conn = DBUtil.getConnection();
	}


	public int logincheck(String id, String pw) {
		
		String sql = "select count(*) from CustomerLogin where id = ? and pw = ?";
		
		try {
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, id);
			stat.setString(2, pw);
			ResultSet rs = stat.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("MainDAO.logincheck :" + e.toString());
		}
		
		
		return 0;
	}
	
	

}
