package gm.shoppingmall.main.util;

import gm.shoppingmall.main.customer.CustomerDTO;

/**
 * 유틸클래스
 * @author user
 *
 */
public class Util {
	/**
	 * 첫페이지 상수
	 */
	public final static int FIRSTPAGE=1;
	/**
	 * 페이지 하나에 들어갈 요소의 갯수를 정하는 상수
	 */
	public final static int ONEPAGE=10;
	
	/**
	 * 선의 길이
	 */
	public final static int LONG = 70;
	
	public static CustomerDTO LoginCustomer;
	
	public final static String ELSEMENT = "잘못입력하셨습니다. 다시입력해주시기 바랍니다.";
	
	public final static String[] adminMenu = {"회원 관리","상품 관리","주문/배송 관리","고객 센터 관리","매출 관리","상위 메뉴로 돌아가기","종료"};
	public final static String[] CUSTOMERMENU = {
			"쇼핑하기","회원정보","주문/배송내역 보기","이벤트","고객센터","로그아웃"
	};
	public static final String[] SHOPPING = {
			"인기 상품 모음","상품 보기","상품 검색","장바구니 목록","상위메뉴로 돌아가기"
	};
	
}
