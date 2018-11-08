package gm.shoppingmall.main;

import gm.shoppingmall.main.util.BreadCrumbs;

public class MainClass {
	public static String isAuth;
	public static BreadCrumbs crumb;
	
	static {
		crumb = new BreadCrumbs();
	}
	
	public static void main(String[] args) {
		MainController mcontroller = new MainController();
		mcontroller.main();

	}

}
