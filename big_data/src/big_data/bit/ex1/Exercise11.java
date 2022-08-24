package big_data.bit.ex1;

import java.util.Scanner;

public class Exercise11 {
	static int num1, num2;
	static String op;

	public static void main(String[] args) {
		// 무한반복으로 사칙연산을 계산하는 프로그램 작성
		// 연산기호를 quit으로 입력하면 프로그램 종료
		// Scanner 사용
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.print("첫 번째 숫자 입력 : ");
			num1 = scan.nextInt();
			System.out.print("두 번째 숫자 입력 : ");
			num2 = scan.nextInt();
			System.out.print("연산 기호 입력 : ");
			op = scan.next();
//			System.out.println(calc(op, num1, num2));
			int result = 0;
			switch(op) {
			case "+":
				result = num1 + num2;
				break;
			case "-":
				result = num1 - num2;
				break;
			case "*":
				result = num1 * num2;
				break;
			case "/":
				result = num1 / num2;
				break;
			case "quit":
				break;
			}
				if(result != 0) {
					System.out.printf("계산결과는 %d", result);
				}
				else {
					System.out.println("프로그램을 종료합니다.");
					break;
				}
		}
	}

//	static String calc(String str, int num1, int num2) {
//		int result = 0;
//		if (str.equals("+")) {
//			result = num1 + num2;
//		} else if (str.equals("-")) {
//			result = num1 - num2;
//		} else if (str.equals("*")) {
//			result = num1 * num2;
//		} else if (str.equals("/")) {
//			result = num1 / num2;
//		} else if (str.equals("quit")) {
//			System.out.print("사칙연산 프로그램을 종료합니다^^");
//			System.exit(0);
//		}
//		else {
//			return "해당 연산자는 없는 연산자입니다. 연산자 범위 : (+, -, *, /)";
//		}
//		return "계산 결과는 " + result;
//	}
}
