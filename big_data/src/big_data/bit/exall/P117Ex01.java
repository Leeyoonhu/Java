package big_data.bit.exall;

import java.util.Scanner;

public class P117Ex01 {
	// 1. main()메서드를 포함하는 테스트 프로그램 생성
	public static void main(String[] args) {
		// 2. 정수를 키보드로 입력하라고 출력 후 입력받은 정수를 n에 대입
		Scanner scan = new Scanner(System.in);
		System.out.print("팩토리얼 값을 구할 정수 : ");
		int n = scan.nextInt();
		int result = 1;
		// 3. 팩토리얼 계산을 위한 코드로 구성된 while 문 추가해서 프로그램 완성
		while (true) {
			result *= n;
			n--;
			if(n == 0) {
				break;
			}
		}
		// 4. 프로그램을 실행해 결과 확인
		System.out.println(result);
		// 5. while(true)문으로 수정 후에 동일 결과값 출력
	}
}
