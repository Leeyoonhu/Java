package big_data.bit.ex08;

import java.util.HashSet;
import java.util.Set;

class Book {
	int id, quantity;
	String title, author;
	public Book(int id, String title, String author, int quantity) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%d %s %s %d", id, title, author, quantity);
	}
	
	
}

public class HashSetEx04 {
	public static void main(String[] args) {
		Set<Book> bSet = new HashSet<Book>();
		bSet.add(new Book(100, "어린왕자", "쌩떽쥐베리", 5));
		bSet.add(new Book(200, "행복한왕자", "오스카와일드", 10));
		bSet.add(new Book(300, "셜록홈즈", "코난도일", 8));
		for(Book b : bSet) {
			System.out.println(b);
		}
		// set은 저장 순서와 관계없이 출력됨
	}
}
