package big_data.bit.temp;

class Person{
	String name = "사람";
	void showInfo() {
		System.out.println("나는 " + name);
	}
}

class Student extends Person{
	String major = "컴퓨터";
	void work() {
		System.out.println(major + "를 공부한다");
	}
}

public class PersonEx {
	public static void main(String[] args) {
		Student s1 = new Student();	// 자식 객체 생성되었지만 부모 클래스로 형 변환
		Person p1 = s1; // 업캐스팅(자동 형 변환), Person생략 가능
		p1.showInfo();
		Student s2 = (Student)p1;	// 다운캐스팅(명시적 형 변환), 단 무조건 업캐스팅이 된 것을 원래대로 돌리는것
		s2.major = "english";	// 이유는 부모객체에 없는 맴버를 참조할 수 없기때문
		s2.work();
		
		System.out.println(s1 instanceof Student);
		System.out.println(s1 instanceof Person);
		System.out.println(p1 instanceof Student);
		System.out.println(p1 instanceof Person);
	}
}
