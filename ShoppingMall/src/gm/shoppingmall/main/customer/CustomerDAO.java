package gm.shoppingmall.main.customer;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import gm.shoppingmall.main.admin.BasketDTO;
import gm.shoppingmall.main.admin.HistoryDTO;
import gm.shoppingmall.main.admin.NoticeDTO;
import gm.shoppingmall.main.product.ProductDTO;
import gm.shoppingmall.main.util.DBUtil;
import gm.shoppingmall.main.util.Util;

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

	public ArrayList<Object[]> getPopularItem() {
		String sql = "select pi.seq as 번호,pi.name as 제품명, pi.price as 가격, b.name as 대분류 " + 
				"    , s.name as 소분류 from popularItem pi inner join Big b on pi.big = b.seq " + 
				"    inner join Small s on pi.small = s.seq";
		try {
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			ArrayList<Object[]> olist = new ArrayList<Object[]>();
			while(rs.next()) {
				olist.add(new Object[] {
						rs.getString("번호"),rs.getString("제품명").length()<6 ? rs.getString("제품명")+"\t" : rs.getString("제품명")
								,rs.getString("가격"),
						rs.getString("대분류"),rs.getString("소분류")
				});
			}
			return olist;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public int getAllItemPage() {
		String sql = "select count(*) " + 
				"        from Product p inner join Big b on p.big = b.seq " + 
				"            inner join small s on p.small = s.seq ";
		try {
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			if(rs.next()) {
				return rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public ArrayList<ProductDTO> getAllItem() {
		String sql = "select p.seq as 번호, p.name as 제품명, p.price as 가격, b.name as 대분류, s.name as 소분류 " + 
				"        from Product p inner join Big b on p.big = b.seq " + 
				"            inner join small s on p.small = s.seq";
		try {
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			ArrayList<ProductDTO> data = new ArrayList<ProductDTO>();
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setSeq(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setPrice(rs.getString(3));
				dto.setBig(rs.getString(4));
				dto.setSmall(rs.getString(5));
				data.add(dto);
			}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public int addHistory(String seq, String amount) {
		String sql = "insert into History values(historySeq.nextval,?,sysdate,?,?,3)";
		try {
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, Util.LoginCustomer.getSeq());
			stat.setString(2, seq);
			stat.setString(3, amount);
			return stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public int addBasket(String amount,String seq) {
		String sql = "insert into Basket values(basketSeq.nextval,?,?,?)";
		try {
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, Util.LoginCustomer.getSeq());
			stat.setString(2, seq);
			stat.setString(3, amount);
			return stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public ArrayList<ProductDTO> getKeyWordProduct(String keyWord) {
		String sql = "select * from " + 
				"    (select p.seq as 번호, p.name as 제품명, p.price as 가격, b.name as 대분류, s.name as 소분류 " + 
				"        from Product p inner join Big b on p.big = b.seq " + 
				"            inner join small s on p.small = s.seq) where instr(제품명,?) > 0";
		try {
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, keyWord);
			ResultSet rs = stat.executeQuery();
			ArrayList<ProductDTO> list = new ArrayList<ProductDTO>();
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setSeq(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setPrice(rs.getString(3));
				dto.setBig(rs.getString(4));
				dto.setSmall(rs.getString(5));
				list.add(dto);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public ArrayList<BasketDTO> getBasketList() {
		String sql = "select p.seq as 번호, p.name as 제품명, p.price as 가격, b.name as 대분류, s.name as 소분류,bs.amount as 갯수 " + 
				"    from Basket bs inner join Product p on bs.product = p.seq " + 
				"        inner join Big b on p.big = b.seq " + 
				"            inner join small s on p.small = s.seq " + 
				"                where bs.customer= ?";
		try {
			PreparedStatement stat= conn.prepareStatement(sql);
			stat.setString(1, Util.LoginCustomer.getSeq());
			ResultSet rs = stat.executeQuery();
			ArrayList<BasketDTO> list = new ArrayList<BasketDTO>();
			while(rs.next()) {
				BasketDTO dto = new BasketDTO();
				dto.setProduct(rs.getString("번호"));
				dto.setProductName(rs.getString("제품명"));
				dto.setPrice(rs.getString("가격"));
				dto.setBig(rs.getString("대분류"));
				dto.setSmall(rs.getString("소분류"));
				dto.setAmount(rs.getString("갯수"));
				list.add(dto);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<HistoryDTO> getHistory() {
		String sql = "select h.seq as 주문번호, p.name as 상품명, p.price as 상품금액, h.amount as 주문개수, s.state as 현황,  " + 
				" to_char(h.day,'yyyy-mm-dd') as 주문일   from History h inner join Product p on h.product = p.seq " + 
				"        inner join Status s on s.seq = h.status " + 
				"        where h.customer=?";
		try {
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, Util.LoginCustomer.getSeq());
			ResultSet rs = stat.executeQuery();
			ArrayList<HistoryDTO> list = new ArrayList<HistoryDTO>();
			while(rs.next()) {
				HistoryDTO dto = new HistoryDTO();
				dto.setSeq(rs.getString("주문번호"));
				dto.setAmount(rs.getString("주문개수"));
				dto.setDay(rs.getString("주문일"));
				dto.setPrduct(rs.getString("상품명"));
				dto.setProductPrice(rs.getString("상품금액"));
				dto.setStatus(rs.getString("현황"));
				list.add(dto);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<NoticeDTO> getAllNotice() {
		String sql = "select seq,content,to_char(day,'yyyy-mm-dd') from Notice";
		try {
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			ArrayList<NoticeDTO> list = new ArrayList<NoticeDTO>();
			while(rs.next()) {
				NoticeDTO dto = new NoticeDTO();
				dto.setSeq(rs.getString(1));
				dto.setContent(rs.getString(2));
				dto.setDay(rs.getString(3));
				list.add(dto);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<QuestionDTO> getAllQuestion() {
		String sql = "select q.seq as 번호, c.name as 작성자,q.title as 제목,q.content as 내용,to_char(q.day,'yyyy-mm-dd') as 작성일  " + 
				"    from Question q inner join Customer c on q.customer = c.seq ";
		try {
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			ArrayList<QuestionDTO> list = new ArrayList<QuestionDTO>();
			while(rs.next()) {
				QuestionDTO dto = new QuestionDTO();
				dto.setSeq(rs.getString("번호"));
				dto.setDay(rs.getString("작성일"));
				dto.setCustomerName(rs.getString("작성자"));
				dto.setContent(rs.getString("내용"));
				dto.setTitle(rs.getString("제목"));
				list.add(dto);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<QuestionDTO> getMyQuestion() {
		String sql = "select q.seq as 번호, c.name as 작성자,q.title as 제목,q.content as 내용,to_char(q.day,'yyyy-mm-dd') as 작성일  " + 
				"    from Question q inner join Customer c on q.customer = c.seq "
				+ " where q.customer = ?";
		try {
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, Util.LoginCustomer.getSeq());
			ResultSet rs = stat.executeQuery();
			ArrayList<QuestionDTO> list = new ArrayList<QuestionDTO>();
			while(rs.next()) {
				QuestionDTO dto = new QuestionDTO();
				dto.setSeq(rs.getString("번호"));
				dto.setDay(rs.getString("작성일"));
				dto.setCustomerName(rs.getString("작성자"));
				dto.setContent(rs.getString("내용"));
				dto.setTitle(rs.getString("제목"));
				list.add(dto);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int addQuestion(String content, String jemok) {
		String sql = "insert into Question values(questionSeq.nextval,?,?,sysdate,?)";
		try {
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, Util.LoginCustomer.getSeq());
			stat.setString(2, content);
			stat.setString(3, jemok);
			return stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int updateQuestion(String seq, String update, int input) {
		String sql = "";
		if(input ==1) {
			//제목
			sql = "update Question set title = ? where seq =  ?";
		}else if(input==2) {
			//내용
			sql = "update Question set content = ? where seq = ?";
		}
		try {
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, update);
			stat.setString(2, seq);
			return stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public int deleteQuestion(String seq) {
		String sql = "delete from Question where seq = ?";
		try {
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, seq);
			return stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public CustomerDTO getMyInformation() {
		String sql = "select cl.id as 아이디,c.name as 이름, to_char(sysdate,'yyyy')-substr(ssn,0,4) as 나이, c.tel as 전화번호, c.address as 주소 " + 
				"    ,m.name as 등급,a.money as 누적금액, c.email as 이메일  " + 
				"        from Customer c inner join Membership m on c.membership = m.seq " + 
				"            inner join Accumulated a on a.customer = c.seq " + 
				"                inner join CustomerLogin cl on cl.customer = c.seq"
				+ "	where c.seq = ?";
		try {
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, Util.LoginCustomer.getSeq());
			ResultSet rs = stat.executeQuery();
			if(rs.next()) {
				CustomerDTO dto = new CustomerDTO();
				dto.setAccumulated(rs.getString("누적금액"));
				dto.setAddress(rs.getString("주소"));
				dto.setEmail(rs.getString("이메일"));
				dto.setId(rs.getString("아이디"));
				dto.setMembership(rs.getString("등급"));
				dto.setName(rs.getString("이름"));
				dto.setSsn(rs.getString("나이"));
				dto.setTel(rs.getString("전화번호"));
				return dto;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public int updateMyInfo(int input, String update) {
		String sql ="";
		if(input==1) {//이름
			sql = "update Customer set name = ? where seq =?";
		}else if(input==2) {//전번
			sql = "update Customer set tel = ? where seq = ?";
		}else if(input==3) {//주소
			sql="update Customer set address = ? where seq =?";
		}
		try {
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, update);
			stat.setString(2, Util.LoginCustomer.getSeq());
			return stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
	
}
