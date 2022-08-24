package big_data.bit.ex03;

class Person {
	// 클래스에서 반드시 필요한 것 생성자
	// 단, 생성자를 지정해주지않아도 컴파일러가 컴파일하기위해 디폴트 생성자는 하나 만듬
	// 다만, 디폴트 생성자를 오버로딩한 생성자가 있을경우, 디폴트 생성자를 만들어줘야함
	
	// 필드
	public String name;
	public int age;
	
	public Person() {
		// 생성자
	}
	
	public Person(String s) {
		// 매개변수 생성자
		this.name = s;
	}
	
	// 메소드
	public String getName() {
		return name;
	}
}

public class PersonEx {
	public static void main(String[] args) {
//		Person p = new Person();
//	//		참조변수 p1	객체생성(인스턴스화)
//	// 객체 생성은 Person 클래스의 생성자와 관련이 있음
//		System.out.println("이름은 " + p.name);
//		System.out.println("나이는 " + p.age);
//		System.out.println("이름은 " + p.getName());
//		
//		System.out.println("==== 구분선 ====");
//		Person p1 = new Person("conan");
//		System.out.println("이름은 " + p1.name);
//		System.out.println("나이는 " + p1.age);
//		System.out.println("이름은 " + p1.getName());
		
		// 여러 사람객체를 사용할때 배열을 사용
		Person[] pa = new Person[5]; // Person객체를 참조할 수 있는 
		// 래퍼런스 변수 5개를 저장할 수 있는 배열 객체가 생성
		// 현재 pa[0]... [4] = null값
		// 해당 배열에 객체를 넣어주려면 생성자로 객체를 만들어줘야함
		pa[0] = new Person(); 
		pa[1] = new Person(); 
		pa[2] = new Person(); 
		pa[3] = new Person(); 
		pa[4] = new Person(); 
		
		// 위의 과정을 반복문을 통해 간결하게 사용
		for(int i = 0; i < pa.length; i++) {
			pa[i] = new Person();
			pa[i].age = 30 + i;
			// 객체 접근자 .
		}
		for(int i = 0; i < pa.length; i++) {
			System.out.println(pa[i].age);
		}
		
	}
}
