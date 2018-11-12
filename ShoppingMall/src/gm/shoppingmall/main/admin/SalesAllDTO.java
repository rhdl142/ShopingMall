package gm.shoppingmall.main.admin;

public class SalesAllDTO {
	private String all;
	private String cnt;
	public String getAll() {
		return all;
	}
	public void setAll(String all) {
		this.all = all;
	}
	public String getCnt() {
		return cnt;
	}
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "SalesAllDTO [all=" + all + ", cnt=" + cnt + "]";
	}
}
