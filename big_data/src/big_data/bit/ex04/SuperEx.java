package big_data.bit.ex04;

class A {
	public A() {
		System.out.println("A 객체 생성");
	}
	
	public A(int x) {
		System.out.println("매개변수 있는 생성자 A");
	}
}

class B extends A {
	public B() {
		System.out.println("B 객체 생성");
	}
	// 자식 클래스의 생성자는 항상 부모클래스의 디폴트 생성자를 호출(super())하고, 부모 클래스의 디폴트 생성자 값부터 실행된다
	// 호출 순서 >> B b1 = new B() -->> B(){} -->> A(){} -->> A(){}값 실행 -->> B(){} 값 실행
	public B(int y) {
		super(y); 
		// 부모 생성자 호출, 반드시 첫단에 와야함
		// 부모생성자 A(int x)의 x값에 y값 대입
		// super(parameter)를 사용할 경우 해당 부모 클래스의 오버로딩된 생성자 호출 및 실행 가능
		System.out.println("매개변수 있는 생성자 B");
	}
	// 자식클래스의 매개변수가 있는 오버로딩된 생성자이더라도 부모 클래스의 디폴트 생성자 호출
}

public class SuperEx {
	public static void main(String[] args) {
	
		 B b1 = new B(); // 매개변수 없는 자식 생성자 호출
		 System.out.println("--- super(parameter)로 부모클래스의 오버로딩된 생성자 사용 ---");
		 B b2 = new B(3); // 매개변수 있는 자식 생성자 호출
	}
	
	
}
