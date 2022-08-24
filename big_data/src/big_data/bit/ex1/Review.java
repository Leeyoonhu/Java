package big_data.bit.ex1;

import java.util.Scanner;

public class Review {
	public static void main(String[] args) {
		// 시작점은 main 메서드
		// 기본 타입 : 8가지
		// 정수형 : byte, short, int, long, char(문자형) -- 문자형이면서 정수값을 지니고있음
		// 실수형 : float, double
		// 논리형 : boolean
		// 자주 쓰는 참조타입 : String --> 문자열 저장 가능
		// 변수를 사용(값을 저장, 이후에 읽기) 하려면
		// 1. 변수를 선언 (저장 후 읽을 수 있음)
		// 2. 변수 초기화 (값을 저장)

		// 변수는 스코프(scope)가 있다
		// 변수 이름은 식별자(클래스, 인터페이스, 메서드, 변수 등)
		// 변수 이름을 짓는 규칙은 영문자(대소), 한글 가능하지만 사용x, 숫자는 맨첫글자x
		// 특수문자(_, $)이외에는 이름에 사용불가
		// 대소문자 식별하니까 a와 A는 다른 변수가 될 수 있으므로 유의

		int d = 3;
		System.out.printf("%5d", d);
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
	}
}
