package big_data.bit.exall;

class Phone {
	protected String owner;
	public Phone(String owner) {
		this.owner = owner;
	}
	void talk() {
		System.out.printf("%s가 통화 중이다.\n", owner);
	}
}

class Telephone extends Phone {
	private String when;
	public Telephone(String owner, String when) {
		super(owner);
		this.when = when;
	}
	void autoAnswering() {
		System.out.printf("%s가 없다. %s 전화 줄래\n", super.owner, when);
	}
}

class Smartphone extends Phone {
	private String game;
	public Smartphone(String owner, String game) {
		super(owner);
		this.game = game;
	}
	void playGame() {
		System.out.printf("%s가 %s 게임을 하는 중이다.\n", super.owner, game);
	}
}

public class P262Ex05 {
	public static void main(String[] args) {
		Phone[] phones = {new Phone("황진이"), new Telephone("길동이", "내일"), new Smartphone("민국이", "갤러그")};
		// 상속개체면 다운캐스팅할것
		// 다운캐스팅해서 해당 출력
		for(int i = 0; i < phones.length; i++) {
			if(phones[i] instanceof Phone == true && phones[i] instanceof Telephone == false && phones[i] instanceof Smartphone == false) {
				phones[i].talk();
			}
			
			else if(phones[i] instanceof Telephone) {
				Phone p1 = phones[i];
				Telephone t1 = (Telephone)p1;
				t1.autoAnswering();
			}
			else if(phones[i] instanceof Smartphone) {
				Phone p2 = phones[i];
				Smartphone s1 = (Smartphone)p2;
				s1.playGame();
			}
			
		}
	}
}
