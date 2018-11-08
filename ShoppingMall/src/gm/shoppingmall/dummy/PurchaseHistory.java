package gm.shoppingmall.dummy;

import java.util.Random;

public class PurchaseHistory {
	
	private static String month[] = {
			"01","02","03","04","05","06","07","08","09","10","11","12"
			,"01","03","04","05","06","07","08","09","10","11","12"
			,"01","03","04","05","06","07","08","09","10","11","12"
	};
	
	private static String day[] = {
			"01","02","03","04","05","06","07","08","09","10","11","12",
			"13","14","15","16","17","18","19","20","21","22","23","24",
			"25","26","27","28","29","30","31"
	};
	
	private static String year[] = {
			"2018","2017","2016","2015","2014","2017","2016","2015","2014",
			"2017","2016","2015","2014","2013"
	};
	
	public static void main(String[] args) {
		Random rnd = new Random();
		
		int num = 0; 
		String date = "";
		int product = 0;
		int amount = 0;
		int status = 0;
		
		for(int i=0; i<1000; i++) {
			num =  rnd.nextInt(490)+1;
			date = year[rnd.nextInt(year.length)]+"-"+month[rnd.nextInt(month.length)]+"-"+day[rnd.nextInt(day.length)];
			product = rnd.nextInt(100)+1;
			amount = rnd.nextInt(5)+1;
			status = rnd.nextInt(3)+1;
			
			System.out.println(
				"insert into History values(HistorySeq.nextval,"+num+",'"+date+"',"+product+","+amount+","+ status+");"
			);
		}
	}
}
