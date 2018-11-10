package gm.shoppingmall.main.customer;

import gm.shoppingmall.main.util.MyPrint;
import gm.shoppingmall.main.util.MyScanner;
import gm.shoppingmall.main.util.Util;

public class CustomerController {
	private MyScanner scan;
	private MyPrint out;
	private CustomerDAO cdao;
	
	
	
	public CustomerController() {
		scan = new MyScanner();
		out = new MyPrint();
		cdao = new CustomerDAO();
	}
	
	/**
	 * 회원 메인 분기문
	 */
	public void main() {
		while(true) {
			out.title("회원 메뉴");
			out.menu(Util.CUSTOMERMENU);
			int input = 0;
			try {
				input = scan.nextInt("선택");
			} catch (Exception e) {
				out.result(Util.ELSEMENT);
				continue;
			}
			if(input == 1) {
				//쇼핑하기
				
				
			}else if(input == 2) {
				//회원 정보
				
				
			}else if(input == 3) {
				//주문 배송내역 보기
				
				
			}else if(input == 4) {
				//이벤트
				
				
			}else if(input == 5) {
				//고객센터
				
				
			} else if(input == 6) {
				//상위 메뉴로 돌아가기
				return;
			}
			
			
			
		}
		
	}
	
}
