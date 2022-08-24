package big_data.bit.exall;

class Parent {
	String name = "영조";
	void print() {
	
	}
}

class Child extends Parent {
	String name = "사도세자";
	void print() {
		System.out.printf("나는 %s이다", name);
	}
}

public class P261Ex04 {
	public static void main(String[] args) {
		Parent p = new Child();
		System.out.println(p.name);
		p.print();
	}
}
