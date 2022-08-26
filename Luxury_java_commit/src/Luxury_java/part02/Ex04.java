package Luxury_java.part02;
// Scanner 로 정수 3개 입력받고, 3개의 숫자중 중간값 출력

import static Luxury_java.part02.Ex01.scan;
public class Ex04 {
	public static void main(String[] args) {
		System.out.print("정수 3개 입력>>");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		int num3 = scan.nextInt();
		int mid = 0;
		int max = num1; int min = num3;
		if(num1 > num3) {
			if(num1 < num2) {
				mid = num1;
			}
			if(num1 > num2) {
				if(num2 > num3) {
					mid = num2;
				}
				else {
					mid = num3;
				}
			}
		}
		if(num1 < num3) {
			min = num1;
			max = num3;
			if(num1 < num2) {
				if(num2 < num3) {
					mid = num2;
				}
				else {
					mid = num3;
				}
			}
			if(num1 > num2) {
				mid = num1;
			}
		}
		System.out.printf("중간값은 : %d", mid);
	}
}
