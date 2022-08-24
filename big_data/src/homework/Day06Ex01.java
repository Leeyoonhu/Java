package homework;

import java.util.Scanner;

class Author {
	private String name;
	private String email;
	private String gender;
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
		// TODO Auto-generated method stub
		return String.format("Author[name=%s, email=%s, gender=%s]", name, email, gender);
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
		// TODO Auto-generated method stub
		return String.format("Book[title=%s, %s, price=%.1f, qty=%d", title, author.toString(), price, qty);
	}
	
	
	
}
public class Day06Ex01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Book[] b = new Book[10];
		
		for(int i =0; ; i++) {
			System.out.println("1.도서 정보 입력 | 2.도서 목록 보기 | 3.검색하기(제목) | 4.수량정보(여성작가수량/보유도서수량) | 5. 프로그램종료");
			
			int choice = scan.nextInt();
			if(choice == 1) {
				System.out.println("책제목, 저자이름, 이메일, 성별, 가격, 수량 순으로 입력하시요 -->> ");
				String titleName = scan.next();
				String authorName = scan.next();
				String emailAddr = scan.next();
				String gender = scan.next();
				double price = scan.nextDouble();
				int count = scan.nextInt();
					
				b[i] = new Book(titleName, new Author(authorName, emailAddr, gender), price, count);
			}
			
			if(choice == 2) {
				for(int j = 0; j < b.length; j++) {
					if(b[j] != null) {
						System.out.println(b[j].toString());
					}
				}
			}
			
			if(choice == 3) {
				System.out.print("제목을 입력하세요 -->> ");
				String title = scan.next();
				for(int j = 0; j < b.length; j++) {
					try {
						if(title.equals(b[j].getTitle())) {
							System.out.println(b[j].toString());
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						continue;
					}
				}
			}
			
			if(choice == 4) {
				int fCount = 0, allCount = 0;
				for(int j = 0; j < b.length; j++) {
					try {
						if(b[j].getAuthor().getGender().equals("f")) {
							fCount++;
						}
						if(b[j].getQty() != 0) {
							allCount++;
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						continue;
					}
				}
				System.out.printf("여성작가도서/총보유도서 : (%d/%d)\n", fCount, allCount);
			}
				
			if(choice == 5) {
				break;
			}
				
			}
			
		}
	
}
