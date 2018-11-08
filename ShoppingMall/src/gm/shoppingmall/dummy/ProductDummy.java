package gm.shoppingmall.dummy;

import java.util.Random;

public class ProductDummy {
	private static Random rnd = new Random();
	
	private static String color[] = {"빨간색","노란색","주황색","하얀색","파란색"
			,"검정색","초록색","브라운","네이비","보라색","오버핏","루즈핏","예쁜핏"
			,"줄무늬"
	};
	
	private static String pro[]= {"맨투맨","셔츠","조끼","후드","반팔","청바지","면바지","슬랙스"
			,"반바지","가디건","청자켓","코트","항공점퍼","목도리","장갑","스니커즈"
			,"워커","단화","구두"
	};
	
	private static String price[] = {
		"25000","27000","29000","21000","23000","24000",
		"35000","37000","39000","31000","33000","34000",
		"15000","17000","19000","11000","13000","14000",
		"45000","47000","49000","41000","43000","44000"
	};
	
	public static void main(String[] args) {
		String name = "";
		String pri = "";
		int a = 1;
		int b = 1;
		for(int i=0; i< color.length; i++) {
			for(int j =0; j<pro.length; j++) {
				name= color[i]+pro[j];
				pri = price[rnd.nextInt(price.length)];
				System.out.println("insert into Product values(productSeq.nextval,'"+name+"',"+pri+","+a+","+b+");");

				b++;
				if(b==20) {
					b = 1;
				}
			}
		}
		
	}
}
