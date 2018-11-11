package gm.shoppingmall.main.product;

public class ProductDTO {
	private String seq;
	private String name;
	private String price;
	private String big;
	private String small;
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
	public String getSmall() {
		return small;
	}
	public void setSmall(String small) {
		this.small = small;
	}
	@Override
	public String toString() {
		return "ProductDTO [seq=" + seq + ", name=" + name + ", price=" + price + ", big=" + big + ", small=" + small
				+ "]";
	}
	
	
}
