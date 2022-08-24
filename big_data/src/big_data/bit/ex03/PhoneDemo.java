package big_data.bit.ex03;

class Phone {	// 클래스를 정의할 때 반드시 필요한 것은 생성자
				// 생성자는 객체 생성시에 호출
	// 개발자가 생성자를 정의하지 않는경우, 컴파일러가 디폴트 생성자를 만들어줌
	// 매개변수가 없는 생성자를 디폴트 생성자라고 함
	String model;
	int value;

	void Print() {
		System.out.printf("%d만 원짜리 %s 스마트폰\n", value, model);
	}
}

public class PhoneDemo {
	public static void main(String[] args) {
		Phone myPhone = new Phone();
		myPhone.model = "갤럭시 S3";
		myPhone.value = 100;
		myPhone.Print();
		
		Phone yourPhone = new Phone();
		yourPhone.model = "G6";
		yourPhone.value = 60;
		yourPhone.Print();
	}
}
