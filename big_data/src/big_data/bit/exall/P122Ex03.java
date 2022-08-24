package big_data.bit.exall;

import java.util.Scanner;

public class P122Ex03 {
	public static void main(String[] args) {
		// 키보드로 입력된 양의 정수중 짝수만 덧셈해서 출력하는 do~while문 작성
		// 단, 입력된 정수가 양의 정수가 아닐 경우 입력 종료
		Scanner scan = new Scanner(System.in);
		int sum = 0;
		System.out.print("양의 정수를 입력하세요 : ");
		int num = scan.nextInt();
		do {
			if (num % 2 == 0) {
				sum += num;
			}
			System.out.print("양의 정수를 입력하세요 : ");
			num = scan.nextInt();
		} while (num >= 0);
		System.out.printf("입력한 양의 정수 중에서 짝수의 합은 %d", sum);
	}
}
