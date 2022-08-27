package bit_commit_exercise.day04;
// 입출금 송금 프로그램 작성
import static utils.scan.scan;
class Account {
	private String id, name;
	private int balance = 0;
	public Account(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public Account(String id, String name, int balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getBalance() {
		return balance;
	}
	public int deposit(int amount) {
		System.out.println(this.name + "님이 " + amount + "원을 입금하였음");
		return this.balance += amount;
	}
	public int withdraw(int amount) {
		System.out.println(this.name + "님이 " + amount + "원을 출금하였음");
		return this.balance -= amount;
	}
	public int transferTo(Account another, int amount) {
		
		if(this.balance >= amount) {
			System.out.println(this.name + "님이 " + another.name + "님에게 "
					+ amount + "원을 송금하였음");
			this.balance -= amount;
			another.balance += amount;
		}
		else {
			System.out.println(this.name + "이 " + another.name + "에게 "
				+ amount + "원 송금 시도");
			System.out.println("송금액이 잔액초과!!");
		}
		return this.balance;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", balance=" + balance + "]";
	}
	
	
}
public class Ex04 {
	public static void main(String[] args) {
		System.out.println("초기 계좌 정보");
		Account conan = new Account("11-111-1111", "코난", 20000);
		System.out.println(conan);
		Account rose = new Account("22-222-2222", "장미", 100000);
		System.out.println(rose);
		Account ran = new Account("33-333-3333", "미란", 50000);
		System.out.println(ran);
		System.out.println("----------------------------------------------------");
		conan.transferTo(rose, 30000);
		conan.deposit(50000);
		conan.transferTo(rose, 30000);
		ran.withdraw(4500);
		System.out.println("----------------------------------------------------");
		System.out.println(conan);
		System.out.println(rose);
		System.out.println(ran);
		System.out.println("----------------------------------------------------");
	}
}
