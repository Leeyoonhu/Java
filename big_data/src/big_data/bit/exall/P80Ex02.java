package big_data.bit.exall;

import java.util.Scanner;

public class P80Ex02 {
	public static void main(String[] args) {
		// 입력받은 정수의 제곱 출력
		Scanner scan = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int inNum = scan.nextInt();
		System.out.printf("%d의 제곱은 %d", inNum, inNum * inNum);
	}
}
