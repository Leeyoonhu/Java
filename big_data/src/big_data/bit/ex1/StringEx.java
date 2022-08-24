package big_data.bit.ex1;

public class StringEx {
	public static void main(String[] args) {
		// 단순 리터럴로 생성
		String a = "Hello";
		String b = "Java";
		String c = "Hello";
		System.out.println(a==c);
		// == 참조형을 비교할 때에는 내용이 같은것을 비교한것이 아님
		// 참조하고 있는 대상인 객체가 같은가를 비교
		// 동일하게 힙 메모리에 저장되나 힙 영역에서 문자열 리터럴 테이블로 관리함
		
		
		// String 객체로 생성
		String d = new String("Hello");
		String e = new String("java");
		String f = new String("java");
		// a == c , 기본형인 경우는 둘이 같은지 비교
		// a와 c가 참조형인 경우는 둘이 참조하고있는 대상이 같은가 비교
		System.out.println(e==f); // 변수들이 참조하고있는 대상이 같은가 비교
		System.out.println(e.equals(f)); // 변수들이 참조하고있는 대상의 값이 같은가 비교
		
		char v1 = 'A'; // v1 은 지역변수
		int[] scores = {10, 20, 30}; 
		// scores는 참조변수(기본형이 아닌 참조형으로 생성)
		// 배열, 객체를 생성하면 힙메모리에 저장되고 이값들을 참조하는 변수들을 참조변수라함
		
		
	}
}
