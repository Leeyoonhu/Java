package big_data.bit.ex1;

import java.util.Scanner;
import static java.lang.System.exit;

public class SimpleIfDemo {
	public static void main(String[] args) {
		// 짝수 홀수 판별 프로그램
		Scanner scan = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 : ");
		int num = scan.nextInt();

		if (num % 2 == 0) {
			System.out.println("짝수!");
		}
		if (num % 2 == 1) {
			System.out.println("홀수!");
		}
		if (num == 0) {
			System.out.println("0!");
		}
		if (num < 0) {
			System.out.println("음수!");
		}
		System.out.println("종료");
		exit(0);
	}
}
