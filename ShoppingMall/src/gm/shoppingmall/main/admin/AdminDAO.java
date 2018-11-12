package gm.shoppingmall.main.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import gm.shoppingmall.main.util.DBUtil;
import gm.shoppingmall.main.util.Util;

public class AdminDAO {
	private Connection conn;
	private PreparedStatement stat;
	private Util util;
	
	public AdminDAO() {
		this.util = new Util();
		this.conn = DBUtil.getConnection();
	}
	
	/**
	 * 회원 등급으로 조회
	 * 
	 * @param Grade 등급
	 */
	public ArrayList<CustomerInfoLoginDTO> customerManage(String search, int input) {
		ArrayList<CustomerInfoLoginDTO> list = new ArrayList<>();
		
		try {
			String addSQL = "";
			
			String sql = "select * from Customer c " + 
					"    inner join customerLogin cl " + 
					"        on c.seq = cl.customer " + 
					"            inner join Membership m " + 
					"                on c.membership = m.seq ";
			
			if(input == 1) {
				addSQL = " where m.name = ?";
				
				sql = sql + addSQL;
				
				stat = conn.prepareStatement(sql);
				
				stat.setString(1, search);
			} else if(input == 2) {
				addSQL = " where substr(c.ssn,0,4) between " + 
						"      substr(to_char(sysdate,'yyyy')-?,0,4) " + 
						"      and " + 
						"      substr(to_char(sysdate,'yyyy')-?,0,4) ";
				
				sql = sql + addSQL;
				
				stat = conn.prepareStatement(sql);

				stat.setString(1, (Integer.parseInt(search)+9)+"");
				stat.setString(2, search);
			} else if(input == 3) {
				addSQL = " where cl.id = ? ";
				
				sql = sql + addSQL;
				
				stat = conn.prepareStatement(sql);
				
				stat.setString(1, search);
			}
			
			ResultSet rs = stat.executeQuery();
			
			while(rs.next()) {
				CustomerInfoLoginDTO cilDTO = new CustomerInfoLoginDTO();
				
				cilDTO.setName(rs.getString("name"));
				cilDTO.setSsn(rs.getString("ssn"));
				cilDTO.setTel(rs.getString("tel"));
				cilDTO.setId(rs.getString("id"));
				
				list.add(cilDTO);
			}
			
			return list;
		} catch (Exception e) {
			System.out.println("AdminDAO.customerManageGrade :" + e.toString());
		}
		return null;
	}

	/**
	 * 상품 리스트 반환 메소드
	 * 
	 * @param big 카테고리 상품
	 * @return 상품 list
	 */
	public ArrayList<productSeeDTO> productManage(String big) {
		ArrayList<productSeeDTO> list = new ArrayList<>();
		
		try {
			String sql = "select p.seq, p.name, price, amount from Product p " + 
					"    inner join Big b " + 
					"        on p.big = b.seq " + 
					"            inner join stock s " + 
					"                on p.seq = s.product " + 
					"                    where b.name = ?";
			
			
			stat = conn.prepareStatement(sql);
			
			stat.setString(1, big);

			ResultSet rs = stat.executeQuery();
			
			while(rs.next()) {
				productSeeDTO psDTO = new productSeeDTO();
				
				psDTO.setProductSeq(rs.getString("seq"));
				psDTO.setProductName(rs.getString("name"));
				psDTO.setPrice(rs.getString("price"));
				psDTO.setAmount(rs.getString("amount"));
				
				list.add(psDTO);
			}
			
			return list;
		} catch (Exception e) {
			System.out.println("AdminDAO.productManage :" + e.toString());
		}
		return null;
	}
	
	/**
	 * 인기 상품 반환 메소드
	 * 
	 * @return 상품 list
	 */
	public ArrayList<productSeeDTO> productManage() {
		ArrayList<productSeeDTO> list = new ArrayList<>();
		
		try {
			String sql = "select pi.seq, pi.name, pi.price, b.name as bigname " + 
					" from popularItem pi inner join Big b on pi.big = b.seq  " + 
					"                   inner join Small s on pi.small = s.seq ";
			
			stat = conn.prepareStatement(sql);
			
			ResultSet rs = stat.executeQuery();
			
			while(rs.next()) {
				productSeeDTO psDTO = new productSeeDTO();
				
				psDTO.setProductSeq(rs.getString("seq"));
				psDTO.setProductName(rs.getString("name"));
				psDTO.setPrice(rs.getString("price"));
				psDTO.setBigName(rs.getString("bigname"));
				
				list.add(psDTO);
			}
			
			return list;
		} catch (Exception e) {
			System.out.println("AdminDAO.productManage :" + e.toString());
		}
		return null;
	}

	/**
	 * 소분류  맞게 상품 반환 메소드
	 * 
	 * @param small 소분류
	 * @return 상품 리스트
	 */
	public ArrayList<productSeeDTO> productAllManage(String small) {
		ArrayList<productSeeDTO> list = new ArrayList<>();
		
		try {
			String sql = "select p.seq, p.name, price, amount from Product p " + 
					"    inner join Big b " + 
					"        on p.big = b.seq " + 
					"            inner join stock s " + 
					"                on p.seq = s.product " + 
					"                    inner join small s " + 
					"                        on p.small = s.seq " + 
					"                            where s.name = ? ";
			
			
			stat = conn.prepareStatement(sql);
			
			stat.setString(1, small);

			ResultSet rs = stat.executeQuery();
			
			while(rs.next()) {
				productSeeDTO psDTO = new productSeeDTO();
				
				psDTO.setProductSeq(rs.getString("seq"));
				psDTO.setProductName(rs.getString("name"));
				psDTO.setPrice(rs.getString("price"));
				psDTO.setAmount(rs.getString("amount"));
				
				list.add(psDTO);
			}
			
			return list;
		} catch (Exception e) {
			System.out.println("AdminDAO.productManage :" + e.toString());
		}
		return null;
	}
	/**
	 *  상품 수정 메소드
	 *  
	 * @param prdouctInput 상품 번호
	 */
	public int prdouctUpdate(String prdouctInput, int input, String change) {
		try {
			String sql = "";
			
			if(input == 1) {
				sql = "update product set name = ? where seq = ?";
			} else if (input == 2) {
				sql = "update product set price = ? where seq = ?";
			}
			stat = conn.prepareStatement(sql);

			stat.setString(1, change);
			stat.setString(2, prdouctInput);
			
			return stat.executeUpdate();
		} catch (Exception e) {
			System.out.println("AdminDAO.prdouctUpdate :" + e.toString());
		}
		return 0;
	}
	
	/**
	 *  상품 삭제 메소드
	 *  
	 * @param prdouctInput 상품 번호
	 */
	public int prdouctDelete(String prdouctInput) {
		try {
			String sql = "";
			
			sql = "delete from product where seq = ?";
			
			stat = conn.prepareStatement(sql);

			stat.setString(1, prdouctInput);
			
			return stat.executeUpdate();
		} catch (Exception e) {
			System.out.println("AdminDAO.prdouctDelete :" + e.toString());
		}
		return 0;
	}
	
	/**
	 * 재고 미달 상품 리스트
	 * 
	 * @return 재고 미달 상품 리스트 반환
	 */
	public ArrayList<productSeeDTO> addProduct() {
		ArrayList<productSeeDTO> list = new ArrayList<>();
		
		try {
			String sql = "select * from product p " + 
					"    inner join stock s " + 
					"        on p.seq = s.product " + 
					"            where amount < 3 ";
			
			stat = conn.prepareStatement(sql);
			
			ResultSet rs = stat.executeQuery();
			
			while(rs.next()) {
				productSeeDTO psDTO = new productSeeDTO();
				
				psDTO.setProductSeq(rs.getString("seq"));
				psDTO.setProductName(rs.getString("name"));
				psDTO.setPrice(rs.getString("price"));
				psDTO.setAmount(rs.getString("amount"));
				
				list.add(psDTO);
			}
			
			return list;
		} catch (Exception e) {
			System.out.println("AdminDAO.productManage :" + e.toString());
		}
		return null;
	}

	/**
	 * 상품 추가하기
	 * 
	 * @param input 상품 번호
	 * @param addAmount 추가할 양
	 * @return 성공 여부
	 */
	public int productAmountUpdate(int input, String addAmount) {
		try {
			String sql = "";
			
			sql = "update Stock set amount = amount+? where product = ?";
			
			stat = conn.prepareStatement(sql);

			stat.setString(1, addAmount);
			stat.setString(2, input+"");
			
			return stat.executeUpdate();
		} catch (Exception e) {
			System.out.println("AdminDAO.productAmountUpdate :" + e.toString());
		}
		return 0;
	}
	
	/**
	 * 새로운 상품 추가
	 * 
	 * @param input 상품 번호
	 * @param addAmount 추가할 양
	 * @param big 대분류
	 * @param small 소분류
	 * @return 성공 여부
	 */
	public int newAddProduct(int input, String addAmount, String big, String small) {
		try {
			String sql = "";
			
			sql = "insert into product values( " + 
					"    productSeq.nextval,  " + 
					"    (select name from product where seq=?), " + 
					"    (select price from product where seq=?), " + 
					"    ?, " + 
					"    ?) ";
			
			stat = conn.prepareStatement(sql);

			stat.setString(1, input+"");
			stat.setString(2, input+"");
			stat.setString(3, big);
			stat.setString(4, small);
			
			return stat.executeUpdate();
		} catch (Exception e) {
			System.out.println("AdminDAO.newAddProduct :" + e.toString());
		}
		return 0;
	}
	
	/**
	 * 공지사항 추가하기
	 * 
	 * @param content 내용
	 * @return 성공 여부
	 */
	public int addNotice(String title, String content) {
		try {
			String sql = "insert into notice values(noticeseq.nextval,?,sysdate,?) ";
			
			stat = conn.prepareStatement(sql);
			
			stat.setString(1, content);
			stat.setString(2, title);
			
			return stat.executeUpdate();
		} catch (Exception e) {
			System.out.println("AdminDAO.addNotice :" + e.toString());
		}
		
		return 0;
	}
	
	/**
	 * 공지사항 가져오기
	 * 
	 * @return 공지사항 리스트
	 */
	public ArrayList<NoticeDTO> noticelist() {
		ArrayList<NoticeDTO> list = new ArrayList<>();
		
		try {
			String sql = "select * from notice";
			
			stat = conn.prepareStatement(sql);
			
			ResultSet rs = stat.executeQuery();
			
			while(rs.next()) {
				NoticeDTO nDTO = new NoticeDTO();
				
				nDTO.setSeq(rs.getString("seq"));
				nDTO.setContent(rs.getString("content"));
				nDTO.setDay(rs.getString("day"));
				nDTO.setTitle(rs.getString("title"));
				
				list.add(nDTO);	
			}
			
			return list;
		} catch (Exception e) {
			System.out.println("AdminDAO.noticelist :" + e.toString());
		}
		
		return null;
	}

	/**
	 * 공지사항 수정
	 * 
	 * @param input 공지사항  seq
	 * @param title 공지사항 제목
	 * @param content 공지사항 내용
	 * @return 공지사항 수정 성공 여부
	 */
	public int noticeUpdate(int input, String title, String content) {
		try {
			String sql = "update notice set title = ?, content = ? " + 
					"    where seq = ? ";
			
			stat = conn.prepareStatement(sql);
			
			stat.setString(1, title);
			stat.setString(2, content);
			stat.setString(3, input+"");
			
			return stat.executeUpdate();
		} catch (Exception e) {
			System.out.println("AdminDAO.noticeUpdate :" + e.toString());
		}
		
		return 0;
	}
	
	/**
	 * 공지사항 삭제
	 * 
	 * @param input 공지사항 번호
	 * @return 공지사항 삭제 성공 여부
	 */
	public int noticeDelete(int input) {
		try {
			String sql = "delete from notice where seq = ?";
			
			stat = conn.prepareStatement(sql);
			
			stat.setString(1, input+"");
			
			return stat.executeUpdate();
		} catch (Exception e) {
			System.out.println("AdminDAO.noticeDelete :" + e.toString());
		}
		
		return 0;
	}
	
	/**
	 * 문의사항
	 * 
	 * @return 문의사항 리스트 반환
	 */
	public ArrayList<QuestionAnswerDTO> questionList() {
		ArrayList<QuestionAnswerDTO> list = new ArrayList<>();
		
		try {
			String sql = "select * from question";
			
			stat = conn.prepareStatement(sql);
			
			ResultSet rs = stat.executeQuery();
			
			while(rs.next()) {
				QuestionAnswerDTO qsDTO = new QuestionAnswerDTO();
				
				qsDTO.setSeq(rs.getString("seq"));
				qsDTO.setContent(rs.getString("content"));
				qsDTO.setDay(rs.getString("day"));
				qsDTO.setTitle(rs.getString("title"));
				qsDTO.setCustomer(rs.getString("customer"));
				
				list.add(qsDTO);	
			}
			
			return list;
		} catch (Exception e) {
			System.out.println("questionList.noticeUpdate :" + e.toString());
		}
		return null;
	}

	/**
	 * 문의사항 답변하기 메소드
	 * 
	 * @param input 문의사항 번호
	 * @param content 내용물
	 * @return 문의사항 답번 성공 여부
	 */
	public int addQuestion(int input, String content) {
		try {
			String sql = "insert into answer values "
					+ " (answer.nextval, ?, ?, sysdate) ";
			
			stat = conn.prepareStatement(sql);
			
			stat.setString(1, input+"");
			stat.setString(2, content);
			
			return stat.executeUpdate();
		} catch (Exception e) {
			System.out.println("AdminDAO.addQuestion :" + e.toString());
		}
		
		return 0;
	}

	/**
	 * 문의사항 삭제하기
	 * 
	 * @param input 문의사항 번호
	 * @return 문의사항 삭제 성공 여부
	 */
	public int questionDelete(int input) {
		try {
			String sql = "delete from question where seq = ?";
			
			stat = conn.prepareStatement(sql);
			
			stat.setString(1, input+"");
			
			return stat.executeUpdate();
		} catch (Exception e) {
			System.out.println("AdminDAO.questionDelete :" + e.toString());
		}
		
		return 0;
	}

	/**
	 * 일 월 년 매출
	 * 
	 * @param year 년
	 * @param month 월
	 * @param date 일
	 * @param input 년,월,일 구분
	 * @return 매출 반환
	 */
	public int salesAvg(String year, String month, String date, int input) {
		try {
			String sql = " select sum(price*amount) as sale,count(*) as cnt from product p " + 
					"    inner join history h  " + 
					"        on p.seq = h.product ";
			
			String addSQL = "";
			
			if(input == 1) {
				addSQL = " where day = ? ";
				sql = sql + addSQL;
				
				stat = conn.prepareStatement(sql);
				
				stat.setString(1, year+"/"+month+"/"+date);
			} else if(input == 2) {
				addSQL = " where day between ? and (to_char(add_months(?,1),'yyyymmdd')) ";
				sql = sql + addSQL;
				
				stat = conn.prepareStatement(sql);
				
				stat.setString(1, year+"/"+month+"/"+date);
				stat.setString(2, year+"/"+month+"/"+date);
			} else if(input == 3) {
				addSQL = " where day between ? and (to_char(add_months(?,12),'yyyymmdd')) ";
				sql = sql + addSQL;
				
				stat = conn.prepareStatement(sql);
				
				stat.setString(1, year+"/"+month+"/"+date);
				stat.setString(2, year+"/"+month+"/"+date);
			}
			
			
			ResultSet rs = stat.executeQuery();
			
			if(rs.next()) {
				return Integer.parseInt(rs.getString("sale"));
			}
			
		} catch (Exception e) {
			System.out.println("AdminDAO.questionDelete :" + e.toString());
		}
		
		return 0;
	}

	/**
	 * 주문내역
	 * 
	 * @param input 주문 현황 구분
	 * @return 주문 현황 리스트
	 */
	public ArrayList<HistoryDTO> orderStatus(int input) {
		ArrayList<HistoryDTO> list = new ArrayList<>();
		
		try {
			String sql = "select * from history h " + 
					"    inner join status s " + 
					"        on h.status = s.seq " + 
					"            where s.state = ? ";
			
			if(input == 1) {
				stat = conn.prepareStatement(sql);
				
				stat.setString(1, "구매완료");
			} else if(input == 2) {
				stat = conn.prepareStatement(sql);
				
				stat.setString(1, "배송중");
			} else if(input == 3) {
				stat = conn.prepareStatement(sql);
				
				stat.setString(1, "주문완료");
			} else if(input == 4) {
				stat = conn.prepareStatement(sql);
				
				stat.setString(1, "반품");
			}
			
			ResultSet rs = stat.executeQuery();
			
			while(rs.next()) {
				HistoryDTO hDTO = new HistoryDTO();
				
				hDTO.setCustomer(rs.getString("customer"));
				hDTO.setDay(rs.getString("day"));
				hDTO.setPrduct(rs.getString("product"));
				hDTO.setAmount(rs.getString("amount"));
				
				list.add(hDTO);	
			}
			
			return list;
		} catch (Exception e) {
			System.out.println("AdminDAO.questionDelete :" + e.toString());
		}
		
		return null;
	}
}





















