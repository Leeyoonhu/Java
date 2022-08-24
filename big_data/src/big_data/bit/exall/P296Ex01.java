package big_data.bit.exall;

interface Countable {
	void count();
}

class Bird implements Countable {
	String name;
	public Bird(String s){
		name = s;
	}
	void fly() {
		System.out.printf("2마리 %s가 날아간다.\n", this.name);
	}
	@Override
	public void count() {
		// TODO Auto-generated method stub
		System.out.printf("%s가 2마리 있다\n", this.name);
	}
}

class Tree implements Countable {
	String name;
	public Tree(String s){
		name = s;
	}
	@Override
	public void count() {
		// TODO Auto-generated method stub
		System.out.printf("%s가 5그루 있다\n", this.name);
	}
	
	void ripen() {
		System.out.printf("%s에 열매가 잘 익었다.\n", this.name);
	}
	
}


public class P296Ex01 {

	public static void main(String[] args) {
		Countable[] m = {new Bird("뻐꾸기"), new Bird("독수리"), new Tree("사과나무"), new Tree("밤나무")};
		
		for(Countable e : m) {
			e.count();
		}
	}
}
