package Luxury_java.part02;
// 사칙연산을 입력받아 계산하는 프로그램
import static Luxury_java.part02.Ex01.scan;
public class Ex12 {
	public static void main(String[] args) {
		System.out.print("연산>>");
		int num1 = scan.nextInt();
		String operator = scan.next();
		int num2 = scan.nextInt();
		// 1. 연산자 구분 if-else
//		if(operator.equals("+")) {
//			System.out.printf("%d%s%d의 결과는 %d", num1, operator, num2, num1+num2);
//		}
//		else if(operator.equals("-")) {
//			System.out.printf("%d%s%d의 결과는 %d", num1, operator, num2, num1+num2);
//		}
//		else if(operator.equals("*")) {
//			System.out.printf("%d%s%d의 결과는 %d", num1, operator, num2, num1+num2);
//		}
//		else if(operator.equals("/")) {
//			if(num2 == 0) {
//				System.out.println("0으로 나눌 수 없습니다.");
//			}
//			else {
//				System.out.printf("%d%s%d의 결과는 %d", num1, operator, num2, num1+num2);
//			}
//		}
		
		// 2. 연산자 구분 switch-case
		switch(operator) {
		case "+":
			System.out.printf("%d%s%d의 결과는 %d", num1, operator, num2, num1+num2);
			break;
		case "-":
			System.out.printf("%d%s%d의 결과는 %d", num1, operator, num2, num1+num2);
			break;
		case "*":
			System.out.printf("%d%s%d의 결과는 %d", num1, operator, num2, num1+num2);
			break;
		case "/":
			if(num2 == 0) {
				System.out.println("0으로 나눌 수 없습니다.");
			}
			else {
				System.out.printf("%d%s%d의 결과는 %d", num1, operator, num2, num1+num2);
			}
			break;
		}
	}
}
