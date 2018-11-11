package gm.shoppingmall.main.util;

import java.util.Scanner;

import gm.shoppingmall.main.MainClass;

/**
 * 출력기능을 담당하는 클래스
 * @author user
 *
 */
public class MyPrint {	

	/**
	 * "="선을 긋기위한 메소드
	 */
	public void eline() {
		for (int i = 0; i < Util.LONG; i++) {
			System.out.print("=");
		}
		System.out.println();
	}

	/**
	 * "-"선을 긋기위한 메소드
	 */
	public void line() {
		for (int i = 0; i < Util.LONG; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	

	/**
	 * 출력할 메뉴를 출력
	 * 
	 * @param str
	 *            메뉴리스트
	 */
	public void menu(String[] str) {
		line();
		for (int i = 1; i <= str.length; i++) {
			System.out.printf("%s. %s\n", i, str[i - 1]);
		}
		line();
	}

	/**
	 * 헤더는 문자열 타입이므로 데이터의 헤더 출력
	 * 
	 * @param list
	 *            문자열 배열
	 */
	public void header(String[] list) {
		for (int i = 0; i < list.length; i++) {
			if(list[i].equals(" ")) {
				System.out.print("\t");
				continue;
			}
			System.out.printf("[%s]\t", list[i]);
		}
		System.out.println();
	}

	/**
	 * 데이터를 콘솔창에 출력하기 위한 메소드
	 * 
	 * @param datas
	 *            오브젝트 배열
	 */
	public void data(Object[] datas) {
		line();
		for (Object data : datas) {
			System.out.printf("%s\t", data);
		}
		System.out.println();
		
	}

	/**
	 * 흐름을 잠시 멈추기 위한 메소드
	 */
	public void pause() {
		line();
		System.out.println("\t\t\t★계속하시려면 엔터키를 입력하세요★");
		line();
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
	}

	/**
	 * 잠시 흐름을 멈추기 위한 메소드
	 * 
	 * @param label
	 *            중지메시지
	 */
	public void pause(String label) {
		line();
		System.out.println("\t\t\t" + label);
		line();
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
	}

	/**
	 * 1일때 결과 출력 0 일때 결과 미출력
	 * 
	 * @param result
	 * @param msg
	 */
	public void result(int result, String msg) {
		if (result > 0) {
			eline();
			for(int i =0; i<(Util.LONG/2)-(msg.length()); i++) {
				System.out.print(" ");
			}
			System.out.println("[결과]" + msg);
			eline();
		} else {
			eline();
			System.out.println("\t\t\t실패하였습니다. 관리자에게 문의해주세요.");
			eline();
		}
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
	}

	/**
	 * 결과 메시지 출력 메소드
	 * 
	 * @param msg
	 *            메시지
	 */
	public void result(String msg) {
		eline();
		System.out.println("\t\t\t[결과]" + msg);
		eline();
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
	}
	

	
	


	/**
	 * 타이틀 출력 메소드
	 * 
	 * @param label 타이틀 문자열
	 */
	public void title(String label) {
		  
		  MainClass.crumb.now();
	      eline();
	      
	      for (int i = 0; i < (Util.LONG / 2)-label.length(); i++) {
	         System.out.print(" ");
	      }
	      System.out.println(label);
	      
	      eline();
	}

}
