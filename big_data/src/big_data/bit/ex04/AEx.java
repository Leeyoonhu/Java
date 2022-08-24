package big_data.bit.ex04;

class A1 {
	int a;
	// 컴파일러는 생성자가 정의된게 없는경우 디폴트 생성자를 생성해줌
	// 단, 하나라도 다른 종류의 생성자가 존재하는경우(생성자 오버로딩) 디폴트 생성자 생성x
	A1(int a){ // 매개변수 생성자
		this.a = a;
	}
}
	// this()
// 같은클래스의 다른 생성자 호출(오버로딩된 생성자 호출)
// 단, 제일 첫 단에 있어야함
public class AEx {
	public static void main(String[] args) {
//		A a = new A();
	}
}
