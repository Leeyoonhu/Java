package big_data.bit.exall;

import java.util.Scanner;

public class P118Ex02 {
	// 1. main()메서드를 포함하는 테스트 프로그램 생성
	public static void main(String[] args) {
		// 2. 정수를 키보드로 입력하라고 출력 후 입력받은 정수를 n에 대입
		Scanner scan = new Scanner(System.in);
		System.out.print("팩토리얼 값을 구할 정수 : ");
		int n = scan.nextInt();
		int result = 1;
		// 3. main() 메서드에서 factorial(int x) 메서드 호출
		result = factorial(n);
		// 4. 프로그램 실행해서 결과값 확인
		System.out.println(result);
	}
	// ex 01의 1, 2번을 작성하고 factorial(int x) 메서드 추가
	static int factorial(int x) {
		int r = 1;
		while (true) {
			r *= x;
			x--;
			if(x == 0) {
				break;
			}
		}
		return r;
	}
}
