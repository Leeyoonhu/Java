package bit_commit_exercise.day04;
// 상품 정보 출력하기
import static utils.scan.scan;

import java.awt.event.ItemEvent;
class InvoiceItem {
	private String id, desc;
	private int qty;
	private double unitPrice;
	public InvoiceItem(String id, String desc, int qty, double unitPrice) {
		this.id = id;
		this.desc = desc;
		this.qty = qty;
		this.unitPrice = unitPrice;
	}
	public String getId() {
		return id;
	}
	public String getDesc() {
		return desc;
	}
	public int getQty() {
		return qty;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public double getTotal() {
		return qty * unitPrice;
	}
	@Override
	public String toString() {
		return String.format("InvoiceItem [id=%s, desc=%s, qty=%d, unitPrice=%.1f]의 구매총액은 %.1f", 
				id, desc, qty, unitPrice, getTotal());
	}
}
public class Ex03 {
	public static void main(String[] args) {
		InvoiceItem[] iArray = new InvoiceItem[3];
		System.out.println("item 정보 입력 (id, desc, qty, unitPrice)");
		for(int i = 0; i < iArray.length; i++) {
			iArray[i] = new InvoiceItem(scan.next(), scan.next(), scan.nextInt(), scan.nextDouble());
		}
		for(int i = 0; i < iArray.length; i++) {
			System.out.println(iArray[i]);
		}
	}
}
