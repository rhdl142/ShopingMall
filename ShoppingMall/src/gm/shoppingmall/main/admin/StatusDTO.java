package gm.shoppingmall.main.admin;

public class StatusDTO {
	private String seq;
	private String state;
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "StatusDTO [seq=" + seq + ", state=" + state + "]";
	}
}
