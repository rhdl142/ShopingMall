package gm.shoppingmall.main.admin;

public class NoticeDTO {
	private String seq;
	private String content;
	private String day;
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
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
	@Override
	public String toString() {
		return "NoticeDTO [seq=" + seq + ", content=" + content + ", day=" + day + "]";
	}
}
