package bit_commit_exercise.day05;

import static utils.scan.scan;
class Author {
	private String name, email, gender;
	public Author(String name, String email, String gender) {
		this.name = name;
		this.email = email;
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getGender() {
		return gender;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return String.format("Author [name=%s, email=%s, gender=%s]", 
				this.getName(), this.getEmail(), this.getGender());
	}
}

class Book {
	private String title;
	private Author author;
	private double price;
	private int qty;
	public Book(String title, Author author, double price, int qty) {
		this.title = title;
		this.author = author;
		this.price = price;
		this.qty = qty;
	}
	public String getTitle() {
		return title;
	}
	public Author getAuthor() {
		return author;
	}
	public double getPrice() {
		return price;
	}
	public int getQty() {
		return qty;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	@Override
	public String toString() {
		return String.format("Book [title=%s, %s ,price=%.1f, qty=%s]", 
				this.title, this.author.toString() ,this.price, this.qty);
	}
	
}
public class Ex01 {
	public static void main(String[] args) {
		System.out.println("title, author, email, gender, price, qty 입력>>");
		Book b = new Book(scan.next(), new Author(scan.next(), scan.next(), scan.next()), scan.nextDouble(), scan.nextInt());
		System.out.println(b.toString());
	}
}
