package gm.shoppingmall.main.admin;

public class QuestionAnswerDTO {
	private String seq;
	private String customer;
	private String content;
	private String day;
	private String title;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "QuestionAnswerDTO [seq=" + seq + ", customer=" + customer + ", content=" + content + ", day=" + day
				+ ", title=" + title + "]";
	}
}
