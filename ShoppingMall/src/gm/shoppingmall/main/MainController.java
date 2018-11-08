package gm.shoppingmall.main;

import gm.shoppingmall.main.admin.AdminController;
import gm.shoppingmall.main.customer.CustomerController;
import gm.shoppingmall.main.util.MyPrint;
import gm.shoppingmall.main.util.MyScanner;
import gm.shoppingmall.main.util.Util;

/**
 * 메인파트의 컨트롤러 클래스
 * @author woo
 *
 */
public class MainController {
	private MyPrint out;
	private MyScanner scan;
	private MainDAO mdao;
	private AdminController admin;
	private CustomerController customer;

	public MainController() {
		out = new MyPrint();
		scan = new MyScanner();
		mdao = new MainDAO();
		admin = new AdminController();
		customer=new CustomerController();
	}
	
	/**
	 * 메인 분기문
	 */
	public void main() {
		while (true) {
			out.title("Do you wanna be a fashion leader?");
			out.menu(new String[] { "회원가입", "로그인", "종료" });
			int input = 0;
			try {
				input = scan.nextInt("선택");
			} catch (Exception e) {
				System.out.println("MainController.main :" + e.toString());
			}
			if (input == 1) {
				//회원가입
			} else if (input == 2) {
				//로그인
				login();
			} else if (input == 3) {
				//종료
				out.result("프로그램을 종료하겠습니다.");
				return;
			} else {
				out.result(Util.ELSEMENT);
				continue;
			}
		}
	}

	private void login() {
		out.title("로그인");
		String id = scan.next("아이디");
		String pw = scan.next("비밀번호");
		if(id==AdminController.adto.getId() && pw == AdminController.adto.getPw()) {
			admin.main();
			return;
		}
		
		int result = mdao.logincheck(id,pw);
		if(result ==1) {
			//아이디 비밀번호 1개이면
			
			
			
		}
		
	}

}
