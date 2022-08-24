package big_data.bit.exall;

// Person, Person의 자식 Student, Student의 자식 ForeignStudent
class Person {
	String name;
	int age;

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	void show(){
		System.out.printf("사람[이름 : %s, 나이 : %d]\n", name, age);
	}
}

class Student extends Person {
	int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student(String name, int age, int id) {
		super(name, age);
		this.id = id;
	}

	@Override
	void show() {
		// TODO Auto-generated method stub
		System.out.printf("사람[이름 : %s, 나이 : %d, 학번 : %d]\n", getName(), getAge(), id);
	}
}

class ForeignStudent extends Student {
	String national;

	public String getNational() {
		return national;
	}

	public void setNational(String national) {
		this.national = national;
	}

	public ForeignStudent(String name, int age, int id, String national) {
		super(name, age, id);
		this.national = national;
	}

	@Override
	void show() {
		// TODO Auto-generated method stub
		System.out.printf("사람[이름 : %s, 나이 : %d, 학번 : %d, 국적 : %s]\n", getName(), getAge(), getId(), national);
	}

	
	
}

public class P260Ex02 {
	public static void main(String[] args) {
		Person[] pArray = new Person[3];
		pArray[0] = new Person("길동이", 22);
		pArray[1] = new Student("황진이", 23, 100);
		pArray[2] = new ForeignStudent("Amy", 30, 200, "U.S.A");
		
		for(Person p : pArray) {
			p.show();
		}
	}
}
