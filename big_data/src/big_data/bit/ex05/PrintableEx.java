package big_data.bit.ex05;

interface Printable1{
	// 인터페이스는 public abstract 생략됨
	int MIN = 5;
	void print();
}

public class PrintableEx {
	public static void main(String[] args) {
		Printable p;	// 인터페이스는 참조 변수로 사용 가능
//		p = new Printable(); 인터페이스 및 추상 클래스는 객체생성 불가능
	}
}
