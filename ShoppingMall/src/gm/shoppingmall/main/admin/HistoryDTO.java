package gm.shoppingmall.main.admin;

public class HistoryDTO {
	private String seq;
	private String customer;
	private String day;
	private String product;
	private String amount;
	private String status;
	private String productPrice;
	
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getProduct() {
		return product;
	}
	public void setPrduct(String prduct) {
		this.product = prduct;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "HistoryDTO [seq=" + seq + ", customer=" + customer + ", day=" + day + ", prduct=" + product + ", amount="
				+ amount + ", status=" + status + "]";
	}
}
