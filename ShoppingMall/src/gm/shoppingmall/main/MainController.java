package gm.shoppingmall.main;

import gm.shoppingmall.main.admin.AdminController;
import gm.shoppingmall.main.customer.CustomerController;
import gm.shoppingmall.main.util.MyPrint;
import gm.shoppingmall.main.util.MyScanner;
import gm.shoppingmall.main.util.Util;

/**
 * 메인파트의 컨트롤러 클래스
 * 
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
		customer = new CustomerController();
		AdminController.adto = mdao.getAdminDTO();
		// MainClass.isAuth =
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
				// 회원가입
				MainClass.crumb.in("회원가입");
				join();
				MainClass.crumb.out();
			} else if (input == 2) {
				// 로그인
				MainClass.crumb.in("로그인");
				login();
				MainClass.crumb.out();
			} else if (input == 3) {
				// 종료
				out.result("프로그램을 종료하겠습니다.");
				return;
			} else {
				out.result(Util.ELSEMENT);
				continue;
			}
		}
	}
	
	/**
	 * 회원가입 진행 메소드
	 */
	private void join() {
		while (true) {
			out.title("회원가입");
			System.out.println("/'▶/'은 필수사항!\r\n");
			String id = scan.next("▶ 아이디");
			int result = mdao.idDoubleCheck(id);
			if (result == 1) {
				out.result("중복된 아이디가 존재합니다. 다른 아이디를 입력해주세요.");
				continue;
			}else if(result==0) {
				out.pause("해당 아이디를 사용하셔도 좋습니다. 계속하시려면 엔터키를 눌러주세요");
			}
			String pw = scan.next("▶ 비밀번호");
			String name = scan.next("▶ 이름");
			String ssn = scan.next("▶ 주민등록번호");
			String tel = scan.next("▶ 전화번호");
			String email = scan.next("▶ 이메일");
			String address = scan.next("▶ 주소");
			
			result = mdao.join(id,pw,name,ssn,tel,email,address);
			out.result(result, "회원가입을 성공적으로 완료했습니다.");
		}
	}

	/**
	 * 로그인해서 관리자와 사용자를 분기하는 메소드
	 */
	private void login() {
		out.title("로그인");
		String id = scan.next("아이디");
		String pw = scan.next("비밀번호");

		if (id.equals(AdminController.adto.getId()) && pw.equals(AdminController.adto.getPw())) {
			MainClass.isAuth = id;
			admin.main();
			return;
		}

		int result = mdao.logincheck(id, pw);
		if (result == 1) {
			// 아이디 비밀번호 1개이면
			// 로그인 성공
			MainClass.isAuth = id;
			MainClass.crumb.in("회원 메뉴");
			customer.main();
			MainClass.crumb.out();
			return;
		}

	}

}
