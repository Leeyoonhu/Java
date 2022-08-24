package big_data.bit.ex04;

class Account {
	int accountNo;	//계좌번호
	String name; // 예금주
	double balance; // 잔액
	
	void insert(int accountNo, String name, double amount) {	
		this.accountNo = accountNo;
		this.name = name;
		this.balance = amount;
	}
	// 해당 금액 입금
	void deposit(double amount) {
		this.balance += amount;
	}
	// 해당 금액 출금, 잔액 부족경우 부족메세지 출력
	void withdraw(double amount) {
		if(this.balance >= amount) {
			this.balance -= amount;
		}
		else {
			System.out.println("잔액이 부족하여 출금할 수 없음!");
		}
	}
	// 현 잔액 출력
	void checkBalance() {
		System.out.println(this.name + "님의 잔액은 " + this.balance + "원 입니다.");
	}
	// 계좌정보 출력
	void display() {
		System.out.println("---------------------------");
		System.out.println("계좌번호 : " + this.accountNo);
		System.out.println("예금주 : " + this.name);
		System.out.println("잔액 : " + this.balance + "원");
		System.out.println("---------------------------");
	}
}

public class Exercise01 {
	public static void main(String[] args) {
		Account acc = new Account();
		acc.insert(11111, "코난", 10000);
		acc.display();
		acc.withdraw(20000.0);
		acc.checkBalance();
		acc.deposit(30000.0);
		acc.checkBalance();
		acc.withdraw(1500.0);
		acc.checkBalance();
	}
}
