package gm.shoppingmall.main.admin;

public class CustomerInfoLoginDTO {
	private String seq;
	private String name;
	private String ssn;
	private String tel;
	private String email;
	private String address;
	private String memo;
	private String membership;
	private String id;
	private String pw;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getMembership() {
		return membership;
	}
	public void setMembership(String membership) {
		this.membership = membership;
	}
	@Override
	public String toString() {
		return "CustomerDTO [seq=" + seq + ", name=" + name + ", ssn=" + ssn + ", tel=" + tel + ", email=" + email
				+ ", address=" + address + ", memo=" + memo + ", membership=" + membership + "]";
	}
}
