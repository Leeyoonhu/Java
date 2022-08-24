package big_data.bit.exall;

// 동일 클래스명있으므로  재생성
class Student02 {
	String name;

	public Student02(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("학생[%s]", name);
	}
}

public class P345Ex02 {
	// 실행결과에 적합한 Student 클래스 만들기
	public static void main(String[] args) {
		System.out.println(new Student02("김삿갓"));
		System.out.println(new Student02("홍길동"));
	}
}
