package gm.shoppingmall.main.admin;

public class productSeeDTO {
	//상품명, 가격, 재고량, 대분류번호, 대분류명,상품 구매 갯수
	private String productSeq;
	private String productName;
	private String price;
	private String big;
	private String bigSeq;
	private String bigName;
	private String historySeq;
	private String amount;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getBig() {
		return big;
	}
	public void setBig(String big) {
		this.big = big;
	}
	public String getBigSeq() {
		return bigSeq;
	}
	public void setBigSeq(String bigSeq) {
		this.bigSeq = bigSeq;
	}
	public String getBigName() {
		return bigName;
	}
	public void setBigName(String bigName) {
		this.bigName = bigName;
	}
	public String getHistorySeq() {
		return historySeq;
	}
	public void setHistorySeq(String historySeq) {
		this.historySeq = historySeq;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "productSeeDTO [productName=" + productName + ", price=" + price + ", big=" + big + ", bigSeq=" + bigSeq
				+ ", bigName=" + bigName + ", historySeq=" + historySeq + ", amount=" + amount + "]";
	}
	public String getProductSeq() {
		return productSeq;
	}
	public void setProductSeq(String productSeq) {
		this.productSeq = productSeq;
	}	
}
