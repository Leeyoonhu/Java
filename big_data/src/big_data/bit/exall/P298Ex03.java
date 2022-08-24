package big_data.bit.exall;

// Countable 변경하면 1,2번 오류나므로 Countable01, Bird01, Tree01로 새로 재생성

abstract class Countable01 {
	protected String name;
	protected int num;
	public Countable01(String name, int num) {
		this.name = name;
		this.num = num;
	}
	abstract void count();
}

class Bird01 extends Countable01 {
	Bird01(String s, int i){
		super(s, i);
	}
	
	void fly() {
		if(super.name.equals("뻐꾸기")) {
			System.out.printf("%d마리 %s가 날아간다.\n", super.num, super.name);
		}
		if(super.name.equals("독수리")) {
			System.out.printf("%d마리 %s가 날아간다.\n", super.num, super.name);
		}
	}
	
	@Override
	void count() {
		// TODO Auto-generated method stub
		if(super.name.equals("뻐꾸기")) {
			System.out.printf("%s가 %d마리 있다.\n", super.name, super.num);
		}
		if(super.name.equals("독수리")) {
			System.out.printf("%s가 %d마리 있다.\n", super.name, super.num);
		}
	}
}

class Tree01 extends Countable01 {
	Tree01(String s, int i){
		super(s, i);
	}
	void ripen() {
		if(super.name.equals("사과나무")) {
			System.out.printf("%d그루 %s에 열매가 잘 익었다.\n", super.num, super.name);
		}
		if(super.name.equals("밤나무")) {
			System.out.printf("%d그루 %s에 열매가 잘 익었다.\n", super.num, super.name);
		}
	}
	@Override
	void count() {
		// TODO Auto-generated method stub
		if(super.name.equals("사과나무")) {
			System.out.printf("%s가 %d그루 있다.\n", super.name, super.num);
		}
		if(super.name.equals("밤나무")) {
			System.out.printf("%s가 %d그루 있다.\n", super.name, super.num);
		}
	}
}

public class P298Ex03 {
	public static void main(String[] args) {
		Countable01[] m = {new Bird01("뻐꾸기", 5), new Bird01("독수리", 2), new Tree01("사과나무", 10), new Tree01("밤나무", 7)};
		
		for(Countable01 e : m) {
			e.count();
		}
		for(int i = 0; i < m.length; i++) {
			if(m[i] instanceof Tree01) {
				Tree01 t = (Tree01)m[i];
				t.ripen();
			}
			if(m[i] instanceof Bird01) {
				Bird01 b = (Bird01)m[i];
				b.fly();
			}
		}
	}
}
