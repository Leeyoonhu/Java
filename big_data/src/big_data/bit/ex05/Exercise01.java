package big_data.bit.ex05;

import java.util.Scanner;

public class Exercise01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("나뉨수를 입력하시오: ");
		int num1 = scan.nextInt();
		System.out.print("나눗수를 입력하시오: ");
		int num2 = scan.nextInt();
		int result = 0;
		try {
			result = num1 / num2;
			System.out.printf("%d/%d=%d", num1, num2, result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("0으로 나눌 수 없습니다.");
		}
	}
}
