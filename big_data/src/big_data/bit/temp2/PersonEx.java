package big_data.bit.temp2;

class Person {
	
}

class Student extends Person {
	public static void method(Person p) {
		Student s = (Student)p;
		System.out.println("다운캐스팅 실행");
	}
}

public class PersonEx {
	public static void main(String[] args) {
		Person p1 = new Person();
		Person p2 = new Student(); // 업 캐스팅 (부모 클래스 변수가 자식 클래스 인스턴스를 참조)
		// 단, 업캐스팅된 변수라도 부모클래스에 없는 자식클래스의 맴버를 사용할 수는 없다
		// 또한, 자식클래스에서 부모클래스에있는 맴버가 오버라이딩 된 경우에는 부모 클래스에있는 맴버라 할지라도 오버라이딩 된 맴버값으로 출력
//		Student.method(p1); ClassCastException 오류, 업캐스팅이 되지 않으면 다운캐스팅 불가능
		Student.method(p2);
	}
}
