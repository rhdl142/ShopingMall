package gm.shoppingmall.main.admin;

public class AdminController {
	public static AdminDTO adto;
	private AdminDAO adao;
	
	public AdminController() {
		adto = adao.getAdminDTO();
	}
	
	
}
