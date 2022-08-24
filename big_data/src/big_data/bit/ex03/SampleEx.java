package big_data.bit.ex03;

class Sample {
	int id; // field

	public Sample(int id) {	// Constructor
		this.id = id;	// 객체를 생성할 때 호출
		// new 와 함께 호출
		// 클래스 이름과 동일한 메소드 형태
		// 객체를 생성하면서 초기화됨
		// 객체를 생성해서 반환하기 때문에 특별하게 반환타입 지정 필요 x
		// 내가가진 필드 값을 매개변수 값으로 바꾸겠단 의미
	}

	public void set(int id) {	// 필드를 새로운 값으로 설정
		this.id = id;
	}
	
	public int get() {	// 현재 필드에 저장된 값을 반환
		return id;
	}
}

public class SampleEx {
	public static void main(String[] args) {
		Sample s = new Sample(11);	// 아이디가 11인 객체생성
		System.out.println("변경 전 아이디 : " + s.get());
		s.set(33);	// 아이디 값을 33으로 설정
		System.out.println("변경 후 아이디 : " + s.get());
	}
}
