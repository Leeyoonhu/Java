package big_data.bit.temp;

abstract class Animal {
	public Animal() {
		System.out.println("동물입니다.");
	}
	
	abstract int add(int a, int b);
}

class Human extends Animal{
	public Human() {
		System.out.println("그러면서 사람입니다.");
	}

	@Override
	public String toString() {
		return String.format("나는 사람이다");
	}

	@Override
	int add(int a, int b) {
		// TODO Auto-generated method stub
		return a + b;
	}
	
	
}

class Tiger extends Animal {
	public Tiger() {
		System.out.println("그러면서 호랑이입니다.");
	}

	@Override
	int add(int a, int b) {
		// TODO Auto-generated method stub
		return a - b;
	}
}

abstract class Hello {
	void hi(){
		System.out.println("hi");
	}
	void bye() {
		System.out.println("bye");
	}
}

public class AnimalTest {
	public static void main(String[] args) {
		Animal a = new Human();
//		Tiger t = (Tiger)a; 다운 캐스팅시 업 캐스팅 당시에 사용했던 인스턴스형으로 사용해야함
		Human h = (Human)a;
		System.out.println(h);
		
	}
}
