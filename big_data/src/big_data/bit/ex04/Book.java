package big_data.bit.ex04;

public class Book {
	String title; // null
	String author; // null
	int ISBN; // 0
	
	public Book(String title, String author, int ISBN) {
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
	}
	
	public Book(String title, int ISBN) {
		// this 사용
		// 오버로딩된 다른 생성자 불러올때 사용
		// 단 무조건 생성자 안에서 첫번째로 사용되야함
		this(title, null, ISBN);
		System.out.printf("%s, %s, %d\n", title, this.author, ISBN);
	}

	public Book(String title) {
		this(title, null, 0);
	}

	public Book(int ISBN) {
		this.ISBN = ISBN;
	}
	
	public Book() {
		this(null, null, 0);
		System.out.println("디폴트 생성자가 호출 되었음");
	}

	public static void main(String[] args) {
		Book javaBook = new Book("날개", "이상", 3333);
		Book holyBook = new Book("Holy Bible", 1);
		Book emptyBook = new Book();
	}
}
