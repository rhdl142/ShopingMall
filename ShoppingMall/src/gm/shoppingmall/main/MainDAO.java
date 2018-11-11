package gm.shoppingmall.main;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import gm.shoppingmall.main.admin.AdminDTO;
import gm.shoppingmall.main.customer.CustomerDTO;
import gm.shoppingmall.main.util.DBUtil;
import oracle.jdbc.OracleTypes;

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


	public int idDoubleCheck(String id) {
		String sql = "select count(*) from CustomerLogin where id = ?";
		try {
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, id);
			ResultSet rs = stat.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}


	public int join(String id, String pw, String name, String ssn, String tel, String email, String address) {
		String sql = "call procJoin(?,?,?,?,?,?,?,?)";
		try {
			CallableStatement stat = conn.prepareCall(sql);
			stat.setString(1, id);
			stat.setString(2, pw);
			stat.setString(3, name);
			stat.setString(4, ssn);
			stat.setString(5, tel);
			stat.setString(6, email);
			stat.setString(7, address);
			stat.registerOutParameter(8, OracleTypes.NUMBER);
			stat.executeQuery();
			return stat.getInt(8);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}


	public CustomerDTO getCustomer(String id) {
		String sql = "select * from Customer c inner join CustomerLogin cl on c.seq = cl.customer where id = ?";
		try {
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, id);
			ResultSet rs = stat.executeQuery();
			if(rs.next()) {
				CustomerDTO dto = new CustomerDTO();
				dto.setSeq(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setSsn(rs.getString(3));
				dto.setTel(rs.getString(4));
				dto.setEmail(rs.getString(5));
				dto.setAddress(rs.getString(6));
				dto.setMembership(rs.getString(7));
				return dto;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	

}
