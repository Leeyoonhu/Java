package big_data.bit.ex04;

class Animal {
	public Animal(String s) {
		System.out.println("동물 : " + s);
	}
	
	public Animal(int age, String s) {
		System.out.println("나이 : " + age + ", 동물 : " + s);
	}
}

class Mammal extends Animal {
	public Mammal(String s) {
		super(0, "사람");
	}
}

public class AnimalDemo {
	public static void main(String[] args) {
		Mammal m = new Mammal("사람");		
	}
}
