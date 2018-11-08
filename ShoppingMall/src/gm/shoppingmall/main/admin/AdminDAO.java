package gm.shoppingmall.main.admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import gm.shoppingmall.main.util.DBUtil;

public class AdminDAO {
	private Connection conn;
	
	public AdminDAO() {
		conn = DBUtil.getConnection();
	}

	public AdminDTO getAdminDTO() {
		String sql = "select * from admin";
		try {
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			if(rs.next()) {
				AdminDTO dto = new AdminDTO();
				dto.setId(rs.getString("ID"));
				dto.setPw(rs.getString("PW"));
				return dto;
			}
		} catch (Exception e) {
			System.out.println("AdminDAO.getAdminDTO :" + e.toString());
		}
		return null;
	}
	
	
	
	
}
