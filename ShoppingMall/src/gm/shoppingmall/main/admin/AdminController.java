package gm.shoppingmall.main.admin;

import gm.shoppingmall.main.MainClass;
import gm.shoppingmall.main.util.MyPrint;
import gm.shoppingmall.main.util.MyScanner;
import gm.shoppingmall.main.util.Util;

public class AdminController {
	private MyScanner scan;
	private MyPrint out;
	public static AdminDTO adto;
	private AdminDAO adao;

	public AdminController() {
		this.scan = new MyScanner();
		this.out = new MyPrint();
		adao = new AdminDAO();
	}

	public void main() {
		while (true) {

			MainClass.crumb.in("관리자");

			out.title("관리자");

			out.menu(Util.adminMenu);
			int input = scan.nextInt("선택");

			if (input == 1) {
				MainClass.crumb.in("회원 관리");
				// 회원 관리
				custmoerManage();
				MainClass.crumb.out();
			} else if (input == 2) {
				MainClass.crumb.in("상품 관리");
				// 상품 관리
				MainClass.crumb.out();
			} else if (input == 3) {
				MainClass.crumb.in("주문/배송 관리");
				// 주문/배송 관리
				MainClass.crumb.out();
			} else if (input == 4) {
				MainClass.crumb.in("고객 센터 관리");
				// 고객 센터 관리
				MainClass.crumb.out();
			} else if (input == 5) {
				MainClass.crumb.in("매출 관리");
				// 매출 관리
				MainClass.crumb.out();
			} else if (input == 6) {
				// 로그아웃
				// logout();
				return;
			} else if (input == 7) {
				break;
			} else {
				out.result("다시 입력해주세요");
			}
		}
	}

	/**
	 * 회원 관리
	 */
	private void custmoerManage() {
		out.title("관리자 회원 관리");

	}
}
