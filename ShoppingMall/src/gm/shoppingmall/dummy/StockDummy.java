package gm.shoppingmall.dummy;

import java.util.Random;

public class StockDummy {
	public static void main(String[] args) {
		Random rnd = new Random();
		
		int ammount = 0;
		
		for(int i=1; i<=266; i++) {
			ammount = rnd.nextInt(99)+1;
			
			System.out.println("insert into Stock values(stockSeq.nextval,"+ammount+","+i+");");
		}
	}
}
