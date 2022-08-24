package big_data.bit.ex04;

class Person {
	public void speak() {
		System.out.println("말하다");
	}
	
	public void eat() {
		System.out.println("먹다");
	}
	
	public void walk() {
		System.out.println("걷다");
	}
}

class Student extends Person {
	public void study() {
		System.out.println("공부하다");
	}
}

class StudentWorker extends Student {
	public void work() {
		System.out.println("일하다");
	}
}

public class PersonEx {
	public static void main(String[] args) {
		Student s = new Student();
		s.eat();
		s.walk();
		if(s instanceof Person) {
			s.study();
		}
		
	}
}
