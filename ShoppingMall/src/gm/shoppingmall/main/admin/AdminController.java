package gm.shoppingmall.main.admin;

import java.util.ArrayList;

import gm.shoppingmall.main.MainClass;
import gm.shoppingmall.main.MainDAO;
import gm.shoppingmall.main.util.MyPrint;
import gm.shoppingmall.main.util.MyScanner;
import gm.shoppingmall.main.util.Util;

public class AdminController {
	private MyScanner scan;
	private MyPrint out;
	private AdminDAO dao;
	private MainDAO mdao;
	public static AdminDTO adto;

	public AdminController() {
		this.scan = new MyScanner();
		this.out = new MyPrint();
		this.dao = new AdminDAO();
		this.mdao = new MainDAO();
		AdminController.adto = mdao.getAdminDTO();
	}


	/**
	 * 아이디 패스워드 유효성 검사 및 관리자 전체적인 메뉴
	 * 
	 * @param id 아이디
	 * @param pw 패스워드
	 */
	public void main() {
		while (true) {
			if (MainClass.isAuth == null) {
				break;
			} else {
				MainClass.crumb.in("관리자");

				out.title("관리자");

				out.menu(Util.ADMINMENU);
				int input = scan.nextInt("선택");

				if (input == 1) {
					MainClass.crumb.in("회원 관리");
					custmoerManage();
					MainClass.crumb.out();
				} else if (input == 2) {
					MainClass.crumb.in("상품 관리");
					productManage();
					MainClass.crumb.out();
				} else if (input == 3) {
					MainClass.crumb.in("주문/배송 관리");
					orderManage();
					MainClass.crumb.out();
				} else if (input == 4) {
					MainClass.crumb.in("고객 센터 관리");
					custmerCenterManage();
					MainClass.crumb.out();
				} else if (input == 5) {
					MainClass.crumb.in("매출 관리");
					salesManage();
					MainClass.crumb.out();
				} else if (input == 6) {
					logout();
				} else if (input == 7) {
					break;
				} else {
					out.result("다시 입력해주세요");
				}
			}
		}
	}
	/**
	 * 로그아웃
	 */
	private void logout() {
		MainClass.isAuth = "null";
	}

	/**
	 * 매출 관리
	 */
	private void salesManage() {
		MainClass.crumb.in("매출 관리");

		
		while(true) {
			out.title("매출 관리");
			
			out.menu(Util.SALESMANAGE);
			int input = scan.nextInt("선택");
			
			if(input == 1) {
				MainClass.crumb.in("일 매출");
				out.title("일 매출");
				
				String year = scan.next("년");
				String month = scan.next("월");
				String date = scan.next("일");
				
				int result = dao.salesAvg(year,month,date,input);
				
				System.out.println("일 매툴 : "+result+"원");
				MainClass.crumb.out();
			} else if(input == 2) {
				MainClass.crumb.in("월 매출");
				out.title("월 매출");
				
				String year = scan.next("년");
				String month = scan.next("월");
				
				int result = dao.salesAvg(year,month,"01",input);
				
				System.out.println("월 매툴 : "+result+"원");
				MainClass.crumb.out();
			} else if(input == 3) {
				MainClass.crumb.in("년 매출");
				out.title("년 매출");
				
				String year = scan.next("년");
				
				int result = dao.salesAvg(year,"01","01",input);
				
				System.out.println("년 매툴 : "+result+"원");
				MainClass.crumb.out();
			} else if(input == 4) {
				break;
			} else {
				out.result("다시 입력해 주세요");
			}
		}
		
		
		while(true) {
			out.title("매출 관리");
			
			out.menu(Util.SALESMANAGE);
			int input = scan.nextInt("선택");
			
			if(input == 1) {
				MainClass.crumb.in("일 매출");
				out.title("일 매출");
				
				String year = scan.next("년");
				String month = scan.next("월");
				String date = scan.next("일");
				
				int result = dao.salesAvg(year,month,date,input);
				
				System.out.println("일 매툴 : "+result+"원");
				MainClass.crumb.out();
			} else if(input == 2) {
				MainClass.crumb.in("월 매출");
				out.title("월 매출");
				
				String year = scan.next("년");
				String month = scan.next("월");
				
				int result = dao.salesAvg(year,month,"01",input);
				
				System.out.println("월 매툴 : "+result+"원");
				MainClass.crumb.out();
			} else if(input == 3) {
				MainClass.crumb.in("년 매출");
				out.title("년 매출");
				
				String year = scan.next("년");
				
				int result = dao.salesAvg(year,"01","01",input);
				
				System.out.println("년 매툴 : "+result+"원");
				MainClass.crumb.out();
			} else if(input == 4) {
				break;
			} else {
				out.result("다시 입력해 주세요");
			}
		}
		
		
		while(true) {
			out.title("매출 관리");
			
			out.menu(Util.SALESMANAGE);
			int input = scan.nextInt("선택");
			
			if(input == 1) {
				MainClass.crumb.in("일 매출");
				out.title("일 매출");
				
				String year = scan.next("년");
				String month = scan.next("월");
				String date = scan.next("일");
				
				int result = dao.salesAvg(year,month,date,input);
				
				System.out.println("일 매툴 : "+result+"원");
				MainClass.crumb.out();
			} else if(input == 2) {
				MainClass.crumb.in("월 매출");
				out.title("월 매출");
				
				String year = scan.next("년");
				String month = scan.next("월");
				
				int result = dao.salesAvg(year,month,"01",input);
				
				System.out.println("월 매툴 : "+result+"원");
				MainClass.crumb.out();
			} else if(input == 3) {
				MainClass.crumb.in("년 매출");
				out.title("년 매출");
				
				String year = scan.next("년");
				
				int result = dao.salesAvg(year,"01","01",input);
				
				System.out.println("년 매툴 : "+result+"원");
				MainClass.crumb.out();
			} else if(input == 4) {
				break;
			} else {
				out.result("다시 입력해 주세요");
			}
		}
		
		MainClass.crumb.out();
	}

	/**
	 * 고객 센터 관리 전체적인 틀
	 */
	private void custmerCenterManage() {
		MainClass.crumb.in("고객 센터 관리");
		
		while(true) {
			out.title("고객 센터 관리");
			
			out.menu(Util.CUSTMERCENTERMANAGE);
			int input = scan.nextInt("선택");
			
			if(input == 1) {
				MainClass.crumb.in("공지사항 관리");
				while(true) {
					out.title("공지사항 관리");
					
					out.menu(Util.CUSTMERCENTERMANAGE1);
					input = scan.nextInt("선택");
				
					if(input == 1) {
						MainClass.crumb.in("추가하기");
						out.title("추가하기");
						
						String title = scan.next("제목");
						String content = scan.next("내용물");
						
						int result = dao.addNotice(title, content);
						
						out.result(result, "추가 성공");
						MainClass.crumb.out();
					} else if(input == 2) {
						MainClass.crumb.in("수정하기");
						out.title("수정하기");
						
						ArrayList<NoticeDTO> list = dao.noticelist();

						int page = 1;
						while (true) {
							int onePage = 7;
							int index = (page * onePage) - onePage;
							
							out.header(new String[] {"번호","날짜","제목","내용"});
								
							for (int i = index; i < index + onePage; i++) {
								if (i >= list.size()) {
									break;
								}

								out.data(new Object[] {list.get(i).getSeq(),
												list.get(i).getDay(),
												list.get(i).getTitle(),
												list.get(i).getContent()});
							}
								
							for(int i =0 ; i<30; i++) {
								System.out.print(" ");
							}
							System.out.println("(0:돌아가기)\t\t" + page + "/"
									+ (list.size() % onePage == 0 ? list.size() / onePage : list.size() / onePage + 1));
							page = scan.nextInt(">>페이지");
								
							if (page == 0) {
								break;
							}
						}						
						
						input = scan.nextInt("수정할 번호 선택");
						String title = scan.next("제목 수정");
						String content = scan.next("내용수정");
						
						int result = dao.noticeUpdate(input, title, content);
						
						out.result(result, "수정 성공");
						
						MainClass.crumb.out();
					} else if(input == 3) {
						MainClass.crumb.in("삭제하기");
						out.title("삭제하기");
						
						ArrayList<NoticeDTO> list = dao.noticelist();

						int page = 1;
						while (true) {
							int onePage = 7;
							int index = (page * onePage) - onePage;
							
							out.header(new String[] {"번호","날짜","제목","내용"});
								
							for (int i = index; i < index + onePage; i++) {
								if (i >= list.size()) {
									break;
								}

								out.data(new Object[] {list.get(i).getSeq(),
												list.get(i).getDay(),
												list.get(i).getTitle(),
												list.get(i).getContent()});
							}
								
							for(int i =0 ; i<30; i++) {
								System.out.print(" ");
							}
							System.out.println("(0:돌아가기)\t\t" + page + "/"
									+ (list.size() % onePage == 0 ? list.size() / onePage : list.size() / onePage + 1));
							page = scan.nextInt(">>페이지");
								
							if (page == 0) {
								break;
							}
						}		
						
						input = scan.nextInt("삭제할 번호 선택");
						
						int result = dao.noticeDelete(input);
						
						out.result(result, "삭제 성공");
						
						MainClass.crumb.out();
					} else if(input == 4) {
						break;
					} else {
						out.result("다시 입력해 주세요");
					}
				}
				
				MainClass.crumb.out();
			} else if(input == 2) {
				MainClass.crumb.in("문의사항 관리");
				while(true) {
					out.title("문의사항 관리");
					
					out.menu(Util.CUSTMERCENTERMANAGE2);
					input = scan.nextInt("선택");
				
					if(input == 1) {
						MainClass.crumb.in("답변하기");
						out.title("답변하기");
						
						ArrayList<QuestionAnswerDTO> list = dao.questionList();

						int page = 1;
						while (true) {
							int onePage = 7;
							int index = (page * onePage) - onePage;
							
							out.header(new String[] {"번호","날짜","고객번호","제목","내용"});
								
							for (int i = index; i < index + onePage; i++) {
								if (i >= list.size()) {
									break;
								}

								out.data(new Object[] {list.get(i).getSeq(),
												list.get(i).getDay(),
												list.get(i).getCustomer(),
												list.get(i).getTitle(),
												list.get(i).getContent()});
							}
								
							for(int i =0 ; i<30; i++) {
								System.out.print(" ");
							}
							System.out.println("(0:돌아가기)\t\t" + page + "/"
									+ (list.size() % onePage == 0 ? list.size() / onePage : list.size() / onePage + 1));
							page = scan.nextInt(">>페이지");
								
							if (page == 0) {
								break;
							}
						}		
						
						input = scan.nextInt("문의사항 번호 선택");					
						String content = scan.next("내용물");
						
						int result = dao.addQuestion(input, content);
						
						out.result(result, "답변 성공");
						MainClass.crumb.out();
					} else if(input == 2) {
						MainClass.crumb.in("삭제하기");
						out.title("삭제하기");
						
						ArrayList<QuestionAnswerDTO> list = dao.questionList();

						int page = 1;
						while (true) {
							int onePage = 7;
							int index = (page * onePage) - onePage;
							
							out.header(new String[] {"번호","날짜","고객번호","제목","내용"});
								
							for (int i = index; i < index + onePage; i++) {
								if (i >= list.size()) {
									break;
								}

								out.data(new Object[] {list.get(i).getSeq(),
												list.get(i).getDay(),
												list.get(i).getCustomer(),
												list.get(i).getTitle(),
												list.get(i).getContent()});
							}
								
							for(int i =0 ; i<30; i++) {
								System.out.print(" ");
							}
							System.out.println("(0:돌아가기)\t\t" + page + "/"
									+ (list.size() % onePage == 0 ? list.size() / onePage : list.size() / onePage + 1));
							page = scan.nextInt(">>페이지");
								
							if (page == 0) {
								break;
							}
						}		
						
						input = scan.nextInt("삭제할 번호 선택");
						
						int result = dao.questionDelete(input);
						
						out.result(result, "삭제 성공");
						
						MainClass.crumb.out();
					} else if(input == 3) {
						break;
					} else {
						out.result("다시 입력해 주세요");
					}
				}
			} else if(input == 3) {
				break;
			} else {
				out.result("다시 입력해 주세요");
			}
		}
	}

	/**
	 * 주문/배송 관리 전체적인 틀
	 */
	private void orderManage() {
		MainClass.crumb.in("주문/배송 관리");
		
		while(true) {
			out.title("주문/배송 관리");
			
			out.menu(Util.ORDERMANAGE);
			int input = scan.nextInt("선택");
			
			if(input == 1) {
				MainClass.crumb.in("주문 상품 보기");
				out.title("주문 상품 보기");
				
				ArrayList<HistoryDTO> list = dao.orderStatus(input);

				int page = 1;
				while (true) {
					int onePage = 7;
					int index = (page * onePage) - onePage;
					
					out.header(new String[] {"회원번호","날짜","상품번호","구매갯수"});
						
					for (int i = index; i < index + onePage; i++) {
						if (i >= list.size()) {
							break;
						}

						out.data(new Object[] {list.get(i).getCustomer(),
								list.get(i).getDay(),
								list.get(i).getProduct(),
								list.get(i).getAmount()});
					}
						
					for(int i =0 ; i<30; i++) {
						System.out.print(" ");
					}
					System.out.println("(0:돌아가기)\t\t" + page + "/"
							+ (list.size() % onePage == 0 ? list.size() / onePage : list.size() / onePage + 1));
					page = scan.nextInt(">>페이지");
						
					if (page == 0) {
						break;
					}
				}		
				
				MainClass.crumb.out();
			} else if(input == 2) {
				MainClass.crumb.in("배송중 상품 보기");
				out.title("배송중 상품 보기");
				
				ArrayList<HistoryDTO> list = dao.orderStatus(input);

				int page = 1;
				while (true) {
					int onePage = 7;
					int index = (page * onePage) - onePage;
					
					out.header(new String[] {"회원번호","날짜","상품번호","구매갯수"});
						
					for (int i = index; i < index + onePage; i++) {
						if (i >= list.size()) {
							break;
						}

						out.data(new Object[] {list.get(i).getCustomer(),
								list.get(i).getDay(),
								list.get(i).getProduct(),
								list.get(i).getAmount()});
					}
						
					for(int i =0 ; i<30; i++) {
						System.out.print(" ");
					}
					System.out.println("(0:돌아가기)\t\t" + page + "/"
							+ (list.size() % onePage == 0 ? list.size() / onePage : list.size() / onePage + 1));
					page = scan.nextInt(">>페이지");
						
					if (page == 0) {
						break;
					}
				}		
				
				MainClass.crumb.out();
			} else if(input == 3) {
				MainClass.crumb.in("배송완료 상품 보기");
				out.title("배송완료 상품 보기");
				
				ArrayList<HistoryDTO> list = dao.orderStatus(input);

				int page = 1;
				while (true) {
					int onePage = 7;
					int index = (page * onePage) - onePage;
					
					out.header(new String[] {"회원번호","날짜","상품번호","구매갯수"});
						
					for (int i = index; i < index + onePage; i++) {
						if (i >= list.size()) {
							break;
						}

						out.data(new Object[] {list.get(i).getCustomer(),
								list.get(i).getDay(),
								list.get(i).getProduct(),
								list.get(i).getAmount()});
					}
						
					for(int i =0 ; i<30; i++) {
						System.out.print(" ");
					}
					System.out.println("(0:돌아가기)\t\t" + page + "/"
							+ (list.size() % onePage == 0 ? list.size() / onePage : list.size() / onePage + 1));
					page = scan.nextInt(">>페이지");
						
					if (page == 0) {
						break;
					}
				}		
				
				MainClass.crumb.out();
			} else if(input == 4) {
				MainClass.crumb.in("반품 상품 보기");
				out.title("반품 상품 보기");
				
				ArrayList<HistoryDTO> list = dao.orderStatus(input);

				int page = 1;
				while (true) {
					int onePage = 7;
					int index = (page * onePage) - onePage;
					
					out.header(new String[] {"회원번호","날짜","상품번호","구매갯수"});
						
					for (int i = index; i < index + onePage; i++) {
						if (i >= list.size()) {
							break;
						}

						out.data(new Object[] {list.get(i).getCustomer(),
								list.get(i).getDay(),
								list.get(i).getProduct(),
								list.get(i).getAmount()});
					}
						
					for(int i =0 ; i<30; i++) {
						System.out.print(" ");
					}
					System.out.println("(0:돌아가기)\t\t" + page + "/"
							+ (list.size() % onePage == 0 ? list.size() / onePage : list.size() / onePage + 1));
					page = scan.nextInt(">>페이지");
						
					if (page == 0) {
						break;
					}
				}		
				
				MainClass.crumb.out();
			} else if(input == 5) {
				break;
			} else {
				out.result("다시 입력해 주세요");
			}
		}
		MainClass.crumb.out();
	}

	/**
	 * 상품 관리 전체적인 틀
	 */
	private void productManage() {
		MainClass.crumb.in("상품 관리");
		
		while(true) {
			out.title("상품 관리");
			
			out.menu(Util.PRODUCTMANAGE);
			int input = scan.nextInt("선택");
			
			if(input == 1) {
				MainClass.crumb.in("상품 목록");
				
				ArrayList<productSeeDTO> list = new ArrayList<>();
				
				while(true) {
					out.title("상품 목록");
					out.menu(Util.PRODUCTMANAGE1);
					input = scan.nextInt("선택");
					
					if(input == 1) {
						MainClass.crumb.in("카테고리 별 보기");
						out.title("카테고리 별 보기");
						out.menu(Util.BIGCATE);
						input = scan.nextInt("선택");
						
						String big = "";
						
						switch (input) {
						case 1:
							big = "상의";
							break;
						case 2:
							big = "하의";
							break;
						case 3:
							big = "아우터";
							break;
						case 4:
							big = "악세사리";
							break;
						case 5:
							big = "신발";
							break;
						}
						
						list = dao.productManage(big);
						

						int page = 1;
							while (true) {
								int onePage = 7;
								int index = (page * onePage) - onePage;
							
								out.header(new String[] {"상품번호","상품명","가격","재고량"});
								
								for (int i = index; i < index + onePage; i++) {
									if (i >= list.size()) {
										break;
									}

									out.data(new Object[] {list.get(i).getProductSeq(),list.get(i).getProductName()
												,list.get(i).getPrice(),list.get(i).getAmount()});
								}
								
								for(int i =0 ; i<30; i++) {
									System.out.print(" ");
								}
								System.out.println("(0:돌아가기)\t\t" + page + "/"
										+ (list.size() % onePage == 0 ? list.size() / onePage : list.size() / onePage + 1));
								page = scan.nextInt(">>페이지");
								
								if (page == 0) {
									break;
								}
							}						
						out.pause("엔터를 입력해주세요");
						
						MainClass.crumb.out();
					} else if(input == 2) {
						MainClass.crumb.in("인기 상품 보기");
						out.title("인기 상품 보기");
						
						list = dao.productManage();
						
						out.header(new String[] {"상품번호","상품명","가격","카테고리"});
						
						for(productSeeDTO psDTO : list) {
							out.data(new Object[] {psDTO.getProductSeq(),psDTO.getProductName()
										,psDTO.getPrice(),psDTO.getBigName()});
						}
						out.pause("엔터를 입력해주세요");
						MainClass.crumb.out();
					} else if(input == 3) {
						MainClass.crumb.in("상품 검색");
						
						while(true) {
							out.title("상품 검색");
							
							list = dao.productAllManage(cate());
							
							int page = 1;
							while (true) {
								int onePage = 7;
								int index = (page * onePage) - onePage;
							
								out.header(new String[] {"상품번호","상품명","가격","재고량"});
								
								for (int i = index; i < index + onePage; i++) {
									if (i >= list.size()) {
										break;
									}

									out.data(new Object[] {list.get(i).getProductSeq(),list.get(i).getProductName()
												,list.get(i).getPrice(),list.get(i).getAmount()});
								}
								
								for(int i =0 ; i<30; i++) {
									System.out.print(" ");
								}
								System.out.println("(0:돌아가기)\t\t" + page + "/"
										+ (list.size() % onePage == 0 ? list.size() / onePage : list.size() / onePage + 1));
								page = scan.nextInt(">>페이지");
								
								if (page == 0) {
									break;
								}
							}		
							
							String prdouctInput = scan.next("상품번호");
							
							out.menu(Util.PRODUCTMANAGE1_4);
							input = scan.nextInt("선택");
							
							if(input == 1) {
								MainClass.crumb.in("상품 수정");
								out.title("상품 수정");
								
								out.menu(Util.PRODUCTMANAGE1_4_1);
								input = scan.nextInt("선택");
								
								String change = scan.next("수정 할 값");
								
								int result = dao.prdouctUpdate(prdouctInput, input,change);
								
								out.result(result, "상품 수정 완료");
								
								out.pause("엔터키를 입력해주세요");
								MainClass.crumb.out();
							} else if(input == 2) {
								MainClass.crumb.in("상품 삭제");
								out.title("상품 삭제");
								
								int result = dao.prdouctDelete(prdouctInput);
								
								out.result(result, "상품 삭제 완료");
								
								out.pause("엔터키를 입력해주세요");
								MainClass.crumb.out();
							} else if(input == 3) {
								break;
							} else {
								out.result("다시 입력해 주세요");
							}
						}
						
						MainClass.crumb.out();
					} else if(input == 4) {
						MainClass.crumb.in("입고 부족 상품 보기");
						list = dao.addProduct();
						
						out.header(new String[] {"상품번호","재고량","가격","상품명"});
						
						for(productSeeDTO psDTO : list) {
							out.data(new Object[] {psDTO.getProductSeq(),psDTO.getAmount()
										,psDTO.getPrice(),psDTO.getProductName()});
						}
						
						out.menu(Util.PRODUCTMANAGE1_5_1);
						input = scan.nextInt("번호");
						
						if(input == 1) {
							out.title("상품 추가");
							
							input = scan.nextInt("상품 번호");
							
							String addAmount = scan.next("추가할 양");
							
							int result = dao.productAmountUpdate(input, addAmount);
							
							out.result(result, "추가하였습니다.");
						} else if(input == 2) {
							break;
						} else {
							out.result("다시 입력해 주세요");
						}
						
						MainClass.crumb.out();
					} else if(input == 5) {
						break;
					} else {
						out.result("다시 입력해 주세요");
					}
				}
				
				MainClass.crumb.out();
			} else if(input == 2) {
				MainClass.crumb.in("새로운 상품 구매");
				
				String cate = cate();
				
				ArrayList<productSeeDTO> list = dao.productAllManage(cate);
				
				out.header(new String[] {"상품번호","가격","상품명"});
				
				for(productSeeDTO psDTO : list) {
					out.data(new Object[] {psDTO.getProductSeq()
								,psDTO.getPrice(),psDTO.getProductName()});
				}
				 
				out.menu(Util.PRODUCTMANAGE1_5_1);
				input = scan.nextInt("번호");
				
				if(input == 1) {
					out.title("상품 추가");
					
					input = scan.nextInt("상품 번호");
					String addAmount = scan.next("추가할 양");
					String big = scan.next("대분류");
					String small = scan.next("소분류");
					
					int result = dao.newAddProduct(input, addAmount, big, small);
					
					out.result(result, "추가 완료");
				} else if(input == 2) {
					break;
				} else {
					out.result("다시 입력해 주세요");
				}
				MainClass.crumb.out();
			} else if(input == 3) {
				break;				
			} else {
				out.result("다시 입력해 주세요");
			}
		}
		MainClass.crumb.out();
	}

	/**
	 * 회원 관리 전체적인 틀
	 */
	private void custmoerManage() {
		MainClass.crumb.in("회원 관리");

		while (true) {
			out.title("회원 관리");

			out.menu(Util.CUSTMERMANAGE);
			int input = scan.nextInt("선택");

			if (input == 1) {
				MainClass.crumb.in("회원 조회");
				while (true) {
					out.title("회원 조회");

					out.menu(Util.CUSTMERMANAGE1);
					input = scan.nextInt("선택");
					
					ArrayList<CustomerInfoLoginDTO> list = new ArrayList<>();
					
					if (input == 1) {
						MainClass.crumb.in("등급 검색");
						out.title("등급 검색");
						
						String grade = scan.next("등급을 입력해주세요");
						
						list = dao.customerManage(grade,input);
						
						MainClass.crumb.out();
					} else if (input == 2) {
						MainClass.crumb.in("연령 검색");
						out.title("연령 검색");
						
						String age = scan.next("연령대을 입력해주세요");
						
						list = dao.customerManage(age,input);
						
						MainClass.crumb.out();
					} else if (input == 3) {
						MainClass.crumb.in("아이디 검색");
						out.title("아이디 검색");
						
						String id = scan.next("아이디을 입력해주세요");
						
						list = dao.customerManage(id,input);
						
						MainClass.crumb.out();
					} else if (input == 4) {
						break;
					} else {
						out.result("다시 입력해 주세요");
					}
					
					if(input == 1 || input == 2 || input ==3) {

						int page = 1;
							while (true) {
								int onePage = 7;
								int index = (page * onePage) - onePage;
							
								out.header(new String[] {"회원명","생년월일","전화번호","아이디"});
								
								for (int i = index; i < index + onePage; i++) {
									if (i >= list.size()) {
										break;
									}

									out.data(new Object[] {list.get(i).getName(),list.get(i).getSsn(),list.get(i).getTel(),list.get(i).getId()});
								}
								
								for(int i =0 ; i<30; i++) {
									System.out.print(" ");
								}
								System.out.println("(0:돌아가기)\t\t" + page + "/"
										+ (list.size() % onePage == 0 ? list.size() / onePage : list.size() / onePage + 1));
								page = scan.nextInt(">>페이지");
								
								if (page == 0) {
									break;
								}
							}						
						out.pause("엔터를 입력해주세요");
					}
				}
				MainClass.crumb.out();
			} else if (input == 2) {
				MainClass.crumb.in("회원 삭제");
				out.title("회원 삭제");
				
				MainClass.crumb.out();
			} else if (input == 3) {
				break;
			} else {
				out.result("다시 입력해 주세요");
			}
		}
		MainClass.crumb.out();
	}
	
	/**
	 * 대분류 소분류 나누는 메소드
	 * 
	 * @return 소분류명
	 */
	private String cate() {
		out.menu(Util.BIGCATE);
		int input = scan.nextInt("선택");
		
		String small = "";
		
		if(input == 1) {
			out.menu(Util.SMALLCATE1);
			input = scan.nextInt("선택");
			if(input == 1) small = "맨투맨";
			else if(input == 2) small = "셔츠";
			else if(input == 3) small = "조끼";
			else if(input == 4) small = "후드";
			else if(input == 5) small = "반팔";
		} else if(input == 2) {
			out.menu(Util.SMALLCATE2);
			input = scan.nextInt("선택");
			if(input == 1) small = "청바지";
			else if(input == 2) small = "면바지";
			else if(input == 3) small = "슬랙스";
			else if(input == 4) small = "반바지";
		} else if(input == 3) {
			out.menu(Util.SMALLCATE3);
			input = scan.nextInt("선택");
			if(input == 1) small = "가디건";
			else if(input == 2) small = "청자켓";
			else if(input == 3) small = "코트";
			else if(input == 4) small = "항공점퍼";
		} else if(input == 4) {
			out.menu(Util.SMALLCATE4);
			input = scan.nextInt("선택");
			if(input == 1) small = "목도리";
			else if(input == 2) small = "장갑";
		} else if(input == 5) {
			out.menu(Util.SMALLCATE5);
			input = scan.nextInt("선택");
			if(input == 1) small = "워커";
			else if(input == 2) small = "단화";
			else if(input == 3) small = "구두";
		}
		
		return small;
	}
	
	private String numCate(String cate) {
		String small = "";
		
		if(cate.equals("맨투맨")) small = "a1";
		else if(cate.equals("셔츠")) small = "a2";
		else if(cate.equals("조끼")) small = "a3";
		else if(cate.equals("후드")) small = "a4";
		else if(cate.equals("반팔")) small = "a5";
		else if(cate.equals("청바지")) small = "b1";
		else if(cate.equals("면바지")) small = "b2";
		else if(cate.equals("슬랙스")) small = "b3";
		else if(cate.equals("반바지")) small = "b4";
		else if(cate.equals("가디건")) small = "c1";
		else if(cate.equals("청자켓")) small = "c2";
		else if(cate.equals("코트")) small = "c3";
		else if(cate.equals("항공점퍼")) small = "c4";
		else if(cate.equals("목도리")) small = "d1";
		else if(cate.equals("장갑")) small = "d2";
		else if(cate.equals("워커")) small = "e1";
		else if(cate.equals("단화")) small = "e2";
		else if(cate.equals("구두")) small = "e3";
		
		
		return small;
	}
}

