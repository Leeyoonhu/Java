package big_data.bit.exall;

import java.util.Arrays;

class Book {
	int price;

	public Book(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Book [price=%d]", this.price);
	}
	
	
}

public class P302Ex03 {
	public static void main(String[] args) {
		Book[] b = new Book[3];
		int[] priceArray = new int[3];
		b[0] = new Book(15000);
		b[1] = new Book(50000);
		b[2] = new Book(20000);
		
		System.out.println("정렬 전");
		for(int i = 0; i < b.length; i++) {
			System.out.println(b[i].toString());
			priceArray[i] = b[i].price;
		}
		System.out.println("정렬 후");
		for(int i = 0; i < b.length; i++) {
			Arrays.sort(priceArray);
			b[i].price = priceArray[i];
			System.out.println(b[i].toString());
		}
	}
}
