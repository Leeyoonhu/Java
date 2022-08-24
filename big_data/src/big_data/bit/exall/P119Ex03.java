package big_data.bit.exall;

import java.util.Scanner;

public class P119Ex03 {
	public static void main(String[] args) {
		// 6. 결괏값 출력
		System.out.println(factorial(5));
		System.out.println(factorial(1, 5));
		System.out.println(factorial(3, 5));
		System.out.println(factorial(10, 5));
	}

	// ex 01의 1, 2번을 작성하고 factorial(int x) 메서드 추가
	static int factorial(int x) {
		int r = 1;
		while (true) {
			r *= x;
			x--;
			if (x == 0) {
				break;
			}
		}
		return r;
	}

	// 5. 다른 factorial 메서드 만들기
	static int factorial(int x, int y) {
		int r = 1, min = 1, max = 1;
		
		if (x < y) {
			max = y;
			min = x;
		}

		while (true) {
			r *= min;
			min++;
			if (min > max) {
				break;
			}
		}
		return r;
	}
}
