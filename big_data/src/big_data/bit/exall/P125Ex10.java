package big_data.bit.exall;

import java.util.Scanner;

public class P125Ex10 {
	public static void main(String[] args) {
		// 주어진 정수가 소수인지 판별하는 프로그램
		// isPrime() 메서드 사용할 것
		System.out.print("양의 정수를 입력하세요 : ");
		int num = new Scanner(System.in).nextInt();
		if(isPrime(num)) {
			System.out.println(num + "는 소수입니다.");
		}
		else {
			System.out.println(num + "는 소수가 아닙니다.");
		}
	}

	private static boolean isPrime(int num) {
		if(num == 2 || num == 3) {
			return true;
		}
		else if (num % 2 != 0 && num % 3 != 0) {
			return true;
		}
		return false;
	}
}
