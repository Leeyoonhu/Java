package big_data.bit.exall;

import java.util.Scanner;

public class P76Ex02 {
	public static void main(String[] args) {
		// 입력된 정수 짝수 홀수 출력 프로그램 만들기
		// 조건 연산자 사용
		Scanner scan = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = scan.nextInt();
		System.out.println((num % 2 == 0)? "짝수입니다" : "홀수입니다");
	}
}
