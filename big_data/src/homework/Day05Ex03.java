package homework;

import java.util.Scanner;

class InvoiceItem {
	private String id;
	private String desc;
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
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public double getTotal() {
		return qty * unitPrice;
	}
	@Override
	public String toString() {
		return String.format("InvoiceItem[id=%s, desc=%s, qty=%d, unitPrice=%.1f]의 구매총액은 %.1f", id, desc, qty, unitPrice, getTotal());
	}
}

public class Day05Ex03 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		InvoiceItem[] iArray = new InvoiceItem[3];
		for(int i = 0; i < iArray.length; i++) {
			String id= scan.next();
			String desc = scan.next();
			int qty = scan.nextInt();
			double unitPrice = scan.nextDouble();
			iArray[i] = new InvoiceItem(id, desc, qty, unitPrice);
		}
		for(int i = 0; i < iArray.length; i++) {
			System.out.println(iArray[i].toString());
		}
	}
}
