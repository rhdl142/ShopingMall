package gm.shoppingmall.main.admin;

public class HistoryDTO {
	private String seq;
	private String customer;
	private String day;
	private String prduct;
	private String amount;
	private String status;
	private String statusName;
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
	public String getPrduct() {
		return prduct;
	}
	public void setPrduct(String prduct) {
		this.prduct = prduct;
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
		return "HistoryDTO [seq=" + seq + ", customer=" + customer + ", day=" + day + ", prduct=" + prduct + ", amount="
				+ amount + ", status=" + status + "]";
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
}
