package gm.shoppingmall.main.admin;

public class BasketDTO {
	private String seq;
	private String customer;
	private String product;
	private String amount;
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
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "BasketDTO [seq=" + seq + ", customer=" + customer + ", product=" + product + ", amount=" + amount + "]";
	}	
}
