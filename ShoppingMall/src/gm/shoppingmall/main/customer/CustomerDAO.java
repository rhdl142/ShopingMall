package gm.shoppingmall.main.customer;

import java.sql.Connection;

import gm.shoppingmall.main.util.DBUtil;

/**
 * 고객사이드의 DB와 관련된 기능 담당하는 클래스
 * @author woo
 *
 */
public class CustomerDAO {
	private Connection conn;
	
	public CustomerDAO() {
		conn = DBUtil.getConnection();
	}
	
	
	
	
}
