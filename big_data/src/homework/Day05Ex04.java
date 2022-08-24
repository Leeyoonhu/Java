package homework;

class Account {
	private String id;
	private String name;
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
	// amount 를 balance 에 더해서 balance 반환
	public int deposit(int amount) {	
		return balance += amount;
	}
	// if(amount <= balance)면 발란스에서 어마운트 빼기
	// else 면 출금액이 잔액초과 출력
	public int withdraw(int amount) {
		if(amount <= balance) {
			return balance -= amount;
		}
		else {
			System.out.println("출금액이 잔액초과");
			return balance;
		}
	}
	// if(amount <= balance)면 발란스에서 어마운트 빼기
	// else 면 송금액이 잔액초과 출력
	public int transferTo(Account another, int amount) {
		if(amount <= balance) {
			balance -= amount; 
			another.balance += amount;	
			return balance;
		}
		else {
			System.out.println("송금액이 잔액초과");
			return balance;
		}
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Account[id=%s, name=%s, balance=%d]", id, name, balance);
	}
	
}

public class Day05Ex04 {
	public static void main(String[] args) {
		Account[] accArray = new Account[3];
		accArray[0] = new Account("11-111-111", "코난", 20000);
		accArray[1] = new Account("22-222-222", "장미", 100000);
		accArray[2] = new Account("33-333-333", "미란", 50000);
		System.out.println("초기 계좌 정보");
		for(int i = 0; i < accArray.length; i++) {
			System.out.println(accArray[i].toString());
		}
		System.out.println("--------------------------------------------------");
		System.out.println("코난이 장미에게 30000원 송금 시도");
		accArray[0].transferTo(accArray[1], 30000);
		System.out.println("코난님이 50000원을 입금하였음");
		accArray[0].deposit(50000);
		System.out.println("코난이 장미님에게 30000원을 송금하였음");
		accArray[0].transferTo(accArray[1], 30000);
		System.out.println("미란님이 4500원을 출금하였음");
		accArray[2].withdraw(4500);
		System.out.println("--------------------------------------------------");
		System.out.println("은행 업무 이후 계좌 정보");
		for(int i = 0; i < accArray.length; i++) {
			System.out.println(accArray[i].toString());
		}
		System.out.println("--------------------------------------------------");
	}
}
