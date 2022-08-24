package big_data.bit.ex05;

abstract class Animal {
	//걷다
	//잠자다
	//공통적인 부분들 작성..
	public abstract void makeSound(); 
	// 추상 메소드는 몸체(블록)가 없음
	// 추상 클래스는 추상 메서드가 없어도 되나, 추상 메서드를 1개라도 가지고있으면 해당 클래스는 무조건 추상 클래스
	// 자식 클래스에서 추상 메소드가 할 일 구현
}

class Cat extends Animal{
	@Override
	public void makeSound() {
		System.out.println("야옹");
	}
}

class Dog extends Animal{
	@Override
	public void makeSound() {
		System.out.println("멍멍");
	}
}

class Mouse extends Animal{
	@Override
	public void makeSound() {
		System.out.println("찍찍");
	}
}

abstract class Car {
	Car(){
		System.out.println("Car() 디폴트 생성자");
	}
	Car(String s1, String s2){
		System.out.printf("%s은 %s입니다\n", s1, s2);
	}
	abstract void run();
	void start() {
		System.out.println("시동을 건다");
	}
}

class Porche extends Car {
	public Porche(String s3, String s4){
		super(s3, s4);
	}
	@Override
	void run() {	// 추상 메서드 구현
		// TODO Auto-generated method stub
		System.out.println("포르셰가 달린다.");
	}
	
}
public class AbstractEx {
	public static void main(String[] args) {
//		Dog dog = new Dog();
//		Cat cat = new Cat();
//		Mouse mouse = new Mouse();
//		dog.makeSound();
//		cat.makeSound();
//		mouse.makeSound();
//		
//		Animal ani = new Dog();
//		Dog d = (Dog)ani;
//		d.makeSound();
		
		Car c = new Porche("차종", "포르셰");
		c.start();
		c.run();
		
	}
}
