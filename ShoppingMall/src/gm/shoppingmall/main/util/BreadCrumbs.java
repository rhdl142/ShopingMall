package gm.shoppingmall.main.util;

import java.util.Iterator;
import java.util.Stack;

import gm.shoppingmall.main.MainClass;

public class BreadCrumbs{
	private  Stack<String> stack;
	
	public BreadCrumbs() {
		this.stack = new Stack<String>();
	}
	
	/**
	 * 스택 삽입
	 * @param title 제목
	 */
	public void in(String title) {
		stack.push(title);
	}
	
	/**
	 * 스택 제거
	 */
	public void out() {
		stack.pop();
	}
	
	/**
	 * 스택 현재
	 */
	public void now() {
		//stack loop 출력
		Iterator<String> iter = stack.iterator();
		
		System.out.println();
		
		String temp = String.format("[%s 접속중] ", MainClass.isAuth != null ? MainClass.isAuth : "guest");
		
		while(iter.hasNext()) {
			temp = temp + iter.next() + "▶";
		}
		
		System.out.println(temp.substring(0,temp.length()-1));
	}
	/**
	 * 스택사이즈 반환
	 * @return size 스택사이즈
	 */
	public int size() {
		return stack.size();
	}
}
