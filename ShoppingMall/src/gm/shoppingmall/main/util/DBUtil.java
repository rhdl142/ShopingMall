package gm.shoppingmall.main.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 디비 연결을 위한 클래스
 * @author 우성환
 *
 */
public class DBUtil {
	
	public static Connection getConnection() {
		Connection conn = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,"gmshop","java1234");
		} catch (Exception e) {
			System.out.println("DBUtil.getConnection :" + e.toString());
		}
		return conn;
	}
}
