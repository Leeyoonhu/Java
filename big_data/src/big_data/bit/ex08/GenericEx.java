package big_data.bit.ex08;

//자료형이 서로 다른것들을 일반화해서 쓸 수 있도록 도와주는것이 제네릭
//필요한 타입이 있을때마다 클래스를 만들 필요없이 제네릭 안의 타입만 변경
class MyClass <T> {
	// 타입 매개변수 <A~Z>, E >> 원소 K >> 키 V >> 값 T >> 타입(자료형) N >> 숫자
	// 타입이 정해져 있지 않기때문에 필드나 메서드의 자료타입도 T타입으로 만들어 주어야 함
	// 타입으로는 기본형(int, double...)을 받을 수 없음, 무조건 객체(Integer, Double...)여야함 
	// 제네릭 타입의 객체 생성 및 배열, Arraylist 생성 불가
	// 제네릭 타입에 상속되어있는지 비교하는 instanceof 사용 불가
	T val;
	void set(T val) {
		this.val = val;
	}
	
	T get(){
		return this.val;
	}
}

class MyClass2 {
	Person01 val;
	void set(Person01 val) {
		this.val = val;
	}
	
	Person01 get(){
		return this.val;
	}
}

class Person{
	String name;
}


public class GenericEx {
	public static void main(String[] args) {
		// 제네릭 클래스 메인 메서드 안에서 무슨 타입의 클래스를 사용할 것인지 구체화 
		MyClass<Integer> c = new MyClass<Integer>();
		c.set(10);
		System.out.println(c.get());
		
		MyClass<String> s = new MyClass<String>();
		s.set("conan");
		System.out.println(s.get());
		// 컴파일 할때 컴파일러가 타입을 보고 해당 제네릭클래스의 타입이 무슨 타입으로 구현됬는지 알 수 있음
		
		
	}
}
