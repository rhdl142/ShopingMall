package gm.shoppingmall.main.customer;

import java.util.ArrayList;

import gm.shoppingmall.main.MainClass;
import gm.shoppingmall.main.admin.BasketDTO;
import gm.shoppingmall.main.admin.HistoryDTO;
import gm.shoppingmall.main.admin.NoticeDTO;
import gm.shoppingmall.main.product.ProductDTO;
import gm.shoppingmall.main.util.MyPrint;
import gm.shoppingmall.main.util.MyScanner;
import gm.shoppingmall.main.util.Util;

public class CustomerController {
	private MyScanner scan;
	private MyPrint out;
	private CustomerDAO cdao;
	private String title;
	private String[] header;
	

	public CustomerController() {
		scan = new MyScanner();
		out = new MyPrint();
		cdao = new CustomerDAO();
	}

	/**
	 * 회원 메인 분기문
	 */
	public void main() {
		while (true) {
			out.title("회원 메뉴");
			out.menu(Util.CUSTOMERMENU);
			int input = 0;
			try {
				input = scan.nextInt("선택");
			} catch (Exception e) {
				out.result(Util.ELSEMENT);
				continue;
			}
			if (input == 1) {
				// 쇼핑하기
				MainClass.crumb.in("쇼핑하기");
				gotoShopping();
				MainClass.crumb.out();
			} else if (input == 2) {
				// 회원 정보
				MainClass.crumb.in("회원 정보");
				CustomerInfo();
				MainClass.crumb.out();

			} else if (input == 3) {
				// 주문 배송내역 보기
				MainClass.crumb.in("주문/배송내역 보기");
				history();
				MainClass.crumb.out();

			} else if (input == 4) {
				// 이벤트
				MainClass.crumb.in("이벤트");

				MainClass.crumb.out();

			} else if (input == 5) {
				// 고객센터
				MainClass.crumb.in("고객센터");
				customerCenter();
				MainClass.crumb.out();

			} else if (input == 6) {
				// 로그아웃
				logout();
				return;
			}

		}

	}
	private void customerCenter() {
		title="고객센터";
		while(true) {
			out.title(title);
			out.menu(new String[] {
					"공지사항","문의하기","상위메뉴로 돌아가기"
			});
			int input = 0;
			try {
				input=scan.nextInt("선택");
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(input==1) {
				//공지사항
				title="공지사항";
				MainClass.crumb.in(title);
				notice();
				MainClass.crumb.out();
			}else if(input==2) {
				//문의하기
				title="문의하기";
				MainClass.crumb.in(title);
				question();
				MainClass.crumb.out();
			}else if(input==3) {
				//돌아가기
				return;
			}else {
				out.result(Util.ELSEMENT);
				continue;
			}
		}
		
	}
	
	/**
	 * 문의하기 메소드
	 */
	private void question() {
		title = "문의하기";
		while(true) {
			out.title(title);
			out.menu(new String[] {
					"전체 문의 내역","나의 문의 확인","문의글 작성","나의 문의 수정","나의 문의 삭제","상위 메뉴로 돌아가기"
			});
			int input=0;
			try {
				input=scan.nextInt("선택");
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(input==1) {//전체
				MainClass.crumb.in("전체 문의 확인");
				allQuestion();
				MainClass.crumb.out();
			}else if(input==2) {//확인
				MainClass.crumb.in("나의 문의 확인");
				title="나의 문의 확인";
				myQuestion(input,title);
				MainClass.crumb.out();
			}else if(input==3) {//작성
				MainClass.crumb.in("문의글 작성");
				addQuestion();
				MainClass.crumb.out();
			}else if(input==4) { //수정
				MainClass.crumb.in("내 문의 수정");
				title="내 문의 수정";
				updateQuestion(input,title);
				MainClass.crumb.out();
			}else if(input==5) {//내 문의 삭제
				MainClass.crumb.in("내 문의 삭제");
				title="내 문의 삭제";
				deleteQuestion(input,title);
				MainClass.crumb.out();
			}else if(input==6) { //상위메뉴로 돌아가기
				return;
			}else {
				out.result(Util.ELSEMENT);
				continue;
			}
			
			
			
			
		}	
	}
	
	private void deleteQuestion(int input,String title) {
		String seq = myQuestion(input,title);
		int result = cdao.deleteQuestion(seq);
		out.result(result, "해당 문의를 삭제했습니다. 계속하시려면 엔터키를 눌러주세요.");
	}

	private void updateQuestion(int input,String title) {
		title="문의글 수정";
		String seq = myQuestion(input,title);
		out.menu(new String[] {
				"제목수정","내용수정","상위메뉴로 돌아가기"
		});
		input = scan.nextInt("선택");
		if(input==1) {
			title="제목수정";
			MainClass.crumb.in(title);
			out.title(title);
			String jemok = scan.next("수정할 제목");
			int result= cdao.updateQuestion(seq,jemok,input);
			out.result(result, "제목을 수정하였습니다. 계속하시려면 엔터키를 눌러주세요");
			MainClass.crumb.out();
			return;
		}else if(input==2) {
			title="내용수정";
			MainClass.crumb.in(title);
			out.title(title);
			String content = scan.next("수정할 내용");
			int result = cdao.updateQuestion(seq,content,input);
			out.result(result, "내용을 수정하였습니다. 계속하시려면 엔터키를 눌러주세요");
			MainClass.crumb.out();
			return;
		}else if(input==3) {
			return;
		}else {
			return;
		}
	}

	private void addQuestion() {
		title="문의글 작성";
		out.title(title);
		String content="";
		String jemok = scan.next("제목");
		while(true) {
			String input = scan.next("내용[입력종료:end]");
			if(input.equals("end")) {
				break;
			}
			content += input+"\r\n";
		}
		int result = cdao.addQuestion(content,jemok);
		out.result(result, "문의글을 작성하셨습니다. 계속하시려면 엔터키를 눌러주세요");
	}

	/**
	 * 나의 문의 확인 메소드
	 */
	private String myQuestion(int input,String title) {
		header=new String[] {
				"번호","작성자"," ","게시날짜"," ","제목"	
			};
			ArrayList<QuestionDTO> list = cdao.getMyQuestion();
			ArrayList<Object[]> data = new ArrayList<Object[]>();
			for(QuestionDTO dto : list) {
				data.add(new Object[] {
					dto.getSeq(),dto.getCustomerName()+"\t",
					dto.getDay(),
					dto.getTitle()
				});
			}
			int maxPage = (int)Math.ceil((double)(list.size()/Util.ONEPAGE))+1;
			paging(title, header, maxPage, data);
			String seq = scan.next("번호");
			if(input==4||input==5) { //수정
				return seq;
			}
			for(QuestionDTO dto : list) {
				if(dto.getSeq().equals(seq)) {
					showQuestion(dto);;
					out.pause();
					return null;
				}
			}
			return null;
			
	}

	/**
	 * 전체 문의 목록 조회 메서드
	 */
	private void allQuestion() {
		title="전체 문의 목록";
		header=new String[] {
			"번호","작성자"," ","게시날짜"," ","제목"	
		};
		ArrayList<QuestionDTO> list = cdao.getAllQuestion();
		ArrayList<Object[]> data = new ArrayList<Object[]>();
		for(QuestionDTO dto : list) {
			data.add(new Object[] {
				dto.getSeq(),dto.getCustomerName()+"\t",
				dto.getDay(),
				dto.getTitle()
			});
		}
		int maxPage = (int)Math.ceil((double)(list.size()/Util.ONEPAGE))+1;
		paging(title, header, maxPage, data);
		String seq = scan.next("번호");
		for(QuestionDTO dto : list) {
			if(dto.getSeq().equals(seq)) {
				showQuestion(dto);;
				out.pause();
				break;
			}
		}
	}

	/**
	 * 공지사항 관련 메소드
	 */
	private void notice() {
		out.title(title);
		header = new String[] {
			"번호","내용"," ","게시날짜"	
		};
		ArrayList<NoticeDTO> list = cdao.getAllNotice();
		ArrayList<Object[]> data = new ArrayList<Object[]>();
		for(NoticeDTO dto : list) {
			data.add(new Object[] {
				dto.getSeq()
				,dto.getContent().substring(0, 5)+"..."
				,dto.getDay()	
			});
		}
		int maxPage= (int)Math.ceil((double)(list.size()/Util.ONEPAGE));
		paging(title, header, maxPage, data);
		String seq = scan.next("번호");
		for(NoticeDTO dto : list) {
			if(dto.getSeq().equals(seq)) {
				showNotice(dto);
				out.pause();
				break;
			}
		}
		
	}
	
	/**
	 * 주문 배송 조회 메소드
	 */
	private void history() {
		title="주문&배송 조회";
		header= new String[]{
			"주문번호","상품명"," ","상품금액","갯수","상품상태","주문일"
		};
		ArrayList<HistoryDTO> list = cdao.getHistory();
		ArrayList<Object[]> data = new ArrayList<Object[]>();
		for(HistoryDTO dto : list) {
			data.add(new Object[] {
				dto.getSeq(),dto.getProduct().length()<6 ? dto.getProduct()+"\t" : dto.getProduct()
				,dto.getProductPrice(),dto.getAmount(),dto.getStatus(),dto.getDay()
			});
		}
		int maxPage = (int)Math.ceil(list.size()/Util.ONEPAGE)+1;
		paging(title, header, maxPage, data);
		out.pause();
	}
	
	
	/**
	 * 회원정보 조회 메소드
	 */
	private void CustomerInfo() {
		while(true) {
			out.title("회원 정보 조회");
			showCustomerInfo();
			out.menu(new String[] {
				"정보 수정","탈퇴 신청","상위메뉴로 돌아가기"
			});
			int input = 0;
			try {
				input = scan.nextInt("선택");
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(input==1) { //회원정보 수정
				MainClass.crumb.in("정보 수정");
				updateMyInfo();
				MainClass.crumb.out();
				break;
			}else if(input==2) { //회원 탈퇴 신청
				
			}else if(input==3) { //상위메뉴
				return;
			}else {
				out.result(Util.ELSEMENT);
				continue;
			}
		}
	}
	
	
	
	/**
	 * 내정보 수정 메소드
	 */
	private void updateMyInfo() {
		while(true) {
			out.title("정보 수정");
			showCustomerInfo();
			out.menu(new String[] {
					"이름","전화번호","주소","상위메뉴로 돌아가기"
			});
			int input=0;
			try {
				input=scan.nextInt("선택");
			} catch (Exception e) {
				e.printStackTrace();
			}
			String update="";
			if(input==1) { //이름
				update = scan.next("수정할 이름");
			}else if(input==2) { //전화번호
				update = scan.next("수정할 전화번호");
			}else if(input==3) { //주소
				update = scan.next("수정할 주소");
			}else if(input==4) { //리턴
				return;
			}else {
				out.result(Util.ELSEMENT);
				continue;
			}
			int result = cdao.updateMyInfo(input,update);
			out.result(result, "해당 정보를 수정하였습니다. 계속하시려면 엔터키를 입력해주세요.");
			return;
		}
	}

	/**
	 * 쇼핑하기 메소드
	 */
	private void gotoShopping() {
		while (true) {
			out.title("쇼핑하기");
			out.menu(Util.SHOPPING);
			int input = 0;
			try {
				input = scan.nextInt("선택");
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (input == 1) {// 인기 상품 모음
				MainClass.crumb.in("인기상품 모음");
				popularProduct();
				MainClass.crumb.out();
			} else if (input == 2) {// 상품 보기
				MainClass.crumb.in("상품 보기");
				allProduct();
				MainClass.crumb.out();
			} else if (input == 3) {// 상품 검색
				MainClass.crumb.in("상품 검색");
				searchProduct();
				MainClass.crumb.out();
			} else if (input == 4) {// 장바구니 목록
				MainClass.crumb.in("장바구니 목록");
				showBasket();
				MainClass.crumb.out();
			} else if (input == 5) {// 상위메뉴 돌아가기
				return;
			} else {
				out.result(Util.ELSEMENT);
				continue;
			}
		}
	}
	
	private void logout() {
		Util.LoginCustomer=null;
		MainClass.isAuth=null;
	}

	/**
	 * 장바구니 목록 보기 메소드
	 */
	private void showBasket() {
		title="장바구니 목록";
		header=new String[]{
				"번호","제품명"," ","가격","대분류","소분류"
		};
		ArrayList<BasketDTO> list = cdao.getBasketList();
		ArrayList<Object[]> data = new ArrayList<Object[]>();
		for(BasketDTO basket : list) {
			data.add(new Object[] {
				basket.getProduct(),basket.getProductName().length()<6 ? basket.getProductName()+"\t" : basket.getProductName(),
						basket.getPrice(),basket.getBig(),basket.getSmall()
			});
		}
		int maxPage = (int)Math.ceil(list.size()/Util.ONEPAGE)+1;
		paging(title, header, maxPage, data);
		String seq = scan.next("번호");
		int result=0;
		for(BasketDTO dto : list) {
			if(dto.getProduct().equals(seq)) {
				result=showProduct(dto);
				break;
			}
		}
		//포문끝남
		if(result==1) {//구매함 -> 구매내역에 추가
			buyItem(seq);
			return;
		}else if(result ==3) {
			return;
		}
	}

	/**
	 * 상품검색 메소드
	 */
	private void searchProduct() {
		out.title("상품 검색");
		title="상품검색";
		header=new String[]{
				"번호","제품명"," ","가격","대분류","소분류"
		};
		System.out.println();
		String keyWord = scan.next("▶ 검색어");
		ArrayList<ProductDTO> list = cdao.getKeyWordProduct(keyWord);
		ArrayList<Object[]> data = new ArrayList<Object[]>();
		for(ProductDTO dto : list) {
			data.add(new Object[] {
				dto.getSeq(),dto.getName().length()<6 ? dto.getName()+"\t" : dto.getName(),dto.getPrice(),dto.getBig(),dto.getSmall()	
			});
		}
		int maxPage = (int)Math.ceil(list.size()/Util.ONEPAGE)+1;
		paging(title, header, maxPage, data);
		String seq = scan.next("번호");
		int result=0;
		for(ProductDTO dto : list) {
			if(dto.getSeq().equals(seq)) {
				result=showProduct(dto);
				break;
			}
		}
		//포문끝남
		if(result==1) {//구매함 -> 구매내역에 추가
			buyItem(seq);
			return;
		}else if(result==2) {//장바구니 담기 -> 장바구니 테이블에 추가
			shoppingBag(seq);
			return;
		}else if(result ==3) {
			return;
		}
	}

	/**
	 * 모든 아이템 보기, 구매하기, 장바구니 담기.
	 */
	private void allProduct() {
		title="상품 보기";
		header=new String[]{
				"번호","제품명"," ","가격","대분류","소분류"
		};
		int maxPage = cdao.getAllItemPage();
		maxPage = (int)Math.ceil(maxPage/Util.ONEPAGE)+1;
		ArrayList<ProductDTO> plist = cdao.getAllItem();
		ArrayList<Object[]> data = new ArrayList<Object[]>();
		for(ProductDTO dto : plist) {
			data.add(new Object[] {
				dto.getSeq(),dto.getName().length()<6 ? dto.getName()+"\t" : dto.getName(),dto.getPrice(),dto.getBig(),dto.getSmall()	
			});
		}
		paging(title, header, maxPage, data);
		//페이징 끝
		String seq = scan.next("번호");
		int result=0;
		for(ProductDTO dto : plist) {
			if(dto.getSeq().equals(seq)) {
				result=showProduct(dto);
				break;
			}
		}
		//포문나옴, 상품보고 결과
		if(result==1) {//구매함 -> 구매내역에 추가
			buyItem(seq);
			return;
		}else if(result==2) {//장바구니 담기 -> 장바구니 테이블에 추가
			shoppingBag(seq);
		}else if(result ==3) {
			return;
		}
		
	}



	/**
	 * 인기상품 보기 메소드
	 */
	private void popularProduct() {
		title="인기상품 보기";
		header=new String[]{
			"번호","제품명"," ","가격","대분류","소분류"
		};
		out.title(title);
		out.header(header);
		ArrayList<Object[]> olist = cdao.getPopularItem();
		for(int i =0; i<olist.size();i++) {
			out.data(olist.get(i));
		}
		out.pause();
	}
	
	/**
	 * Object배열 컬렉션을 페이징 처리하는 메소드
	 * @param title 제목
	 * @param header 헤더
	 * @param maxPage 최대페이지
	 * @param data 해당Object배열
	 */
	public void paging(String title, String[] header, int maxPage, ArrayList<Object[]> data) {
		while (true) {
			out.title(title);
			out.header(header);
			// ArrayList<RecruitmentDTO> list = jdao.getAllRecruit();
			// int maxPage = (int) Math.ceil(list.size() / EnumUtil.ONEPAGE);
			for (int i = 0; i < Util.ONEPAGE; i++) {
				try {
					out.data(data.get(i));
				} catch (Exception e) {
					break;
				}
			} // for
			out.line();
			System.out.println("\t\t\t" + Util.FIRSTPAGE + "/" + maxPage);
			out.line();
			while (true) {
				int page = scan.nextInt("페이지(다음단계 : 0)");
				if (page > maxPage) {
					out.pause("페이지의 범위를 초과하셨습니다. 계속하시려면 엔터키를 눌러주세요.");
					continue;
				}
				if (page == 0) {
					return;
				}
				int last = page * Util.ONEPAGE;
				int first = last - Util.ONEPAGE;
				out.title(title);
				out.header(header);
				for (int i = first; i < last; i++) {
					try {
						out.data(data.get(i));
					} catch (Exception e) {
						break;
					}
				}
				out.eline();
				System.out.println("\t\t\t" + page + "/" + maxPage);
				out.eline();
			}
		}

	}
	/**
	 * 장바구니에 담기 메소드
	 * @param seq 상품번호
	 */
	private void shoppingBag(String seq) {
		String amount = scan.next("담을 갯수");
		int result = cdao.addBasket(amount,seq);
		out.result(result, "해당 상품을 장바구니에 등록하였습니다. 장바구니에서 확인해주세요.");
	}
	
	/**
	 * 상품 구매하기 메소드
	 * @param seq 상품번호
	 */
	private void buyItem(String seq) {
		String amount = scan.next("구매 갯수");
		int result = cdao.addHistory(seq,amount);
		out.result(result, "해당 상품을 구매하였습니다. 주문내역에서 확인해주세요.");
	}
	
	/**
	 * 상품을 하나하나 보여주는 메소드
	 * @param item 상품객체
	 * @return 구매할지 장바구니담을지의 결과값
	 */
	private int showProduct(ProductDTO item) {
		out.title("상품 보기");
		System.out.println("★ 제품명 : "+item.getName()+"\r\n");
		System.out.println("★ 분류 : "+item.getBig()+"//"+item.getSmall());
		System.out.println("★ 가격 : "+item.getPrice());
		out.menu(new String[] {
				"구매하기","장바구니 담기","상위항목으로 돌아가기"
		});
		return scan.nextInt("선택");
		
	}
	/**
	 * 오버로딩 메소드
	 * @param item 장바구니 객체
	 * @return 구매할지 말지의 결과값
	 */
	private int showProduct(BasketDTO item) {
		out.title("상품 보기");
		System.out.println("★ 제품명 : "+item.getProductName()+"\r\n");
		System.out.println("★ 분류 : "+item.getBig()+"//"+item.getSmall());
		System.out.println("★ 가격 : "+item.getPrice());
		out.menu(new String[] {
				"구매하기","상위항목으로 돌아가기"
		});
		return scan.nextInt("선택");
		
	}
	
	/**
	 * 공지사항을 출력해주는 메소드
	 */
	private void showNotice(NoticeDTO dto) {
		out.title(title);
		System.out.println("▶ 작성자 : 관리자+\r\n");
		System.out.println("▶ 게시날짜 :"+dto.getDay()+"\r\n");
		char[] data = new char[dto.getContent().length()];
		for(int i =0;i<data.length; i++) {
			data[i] = dto.getContent().charAt(i);
			if(i!=0&&i%50==0) {
				System.out.print(data[i]+"\r\n");
				continue;
			}
			System.out.print(data[i]);
		}
		System.out.println();
		
	}
	/**
	 * 공지사항을 출력해주는 메소드
	 */
	private void showQuestion(QuestionDTO dto) {
		out.title(title);
		for(int i =0; i<Util.LONG/2-dto.getTitle().length();i++) {
			System.out.print(" ");
		}
		System.out.println("["+dto.getTitle()+"]");
		System.out.println("▶ 작성자 : "+dto.getCustomerName());
		System.out.println("▶ 게시날짜 :"+dto.getDay()+"\r\n");
		char[] data = new char[dto.getContent().length()];
		for(int i =0;i<data.length; i++) {
			data[i] = dto.getContent().charAt(i);
			if(i!=0&&i%50==0) {
				System.out.print(data[i]+"\r\n");
				continue;
			}
			System.out.print(data[i]);
		}
		System.out.println();
		
	}
	
	private void showCustomerInfo() {
		CustomerDTO dto= cdao.getMyInformation();
		System.out.println("● 아이디: \t"+dto.getId());
		out.line();
		System.out.println("● 이름: \t\t"+dto.getName());
		out.line();
		System.out.println("● 나이 : \t\t"+dto.getSsn());
		out.line();
		System.out.println("● 전화번호: \t"+dto.getTel());
		out.line();
		System.out.println("● 주소: \t\t"+dto.getAddress());
		out.line();
		System.out.println("● 등급: \t\t"+dto.getMembership());
		out.line();
		System.out.println("● 누적금액 : \t"+dto.getAccumulated());
	}
}
