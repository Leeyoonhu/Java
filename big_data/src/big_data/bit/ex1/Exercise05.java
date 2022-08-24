package big_data.bit.ex1;

import java.util.Scanner;

public class Exercise05 {
	public static void main(String[] args) {
		// 키와 몸무게를 입력받아 BMI 지수 계산하여 비만도 출력 프로그램 작성
		Scanner scan = new Scanner(System.in);
		System.out.print("키(m)를 입력하세요 : ");
		double height = scan.nextDouble();
		System.out.print("몸무게(kg)를 입력하세요 : ");
		double weight = scan.nextDouble();
		double bmi = weight / (height * height);
		System.out.println(bmi);
		if(bmi >= 40) {
			System.out.println("3단계 비만");
		}
		else if(bmi >= 30) {
			System.out.println("2단계 비만");
		}
		else if(bmi >= 25) {
			System.out.println("1단계 비만");
		}
		else if(bmi >= 18.5) {
			System.out.println("정상체중");
		}
		else {
			System.out.println("저체중");
		}
	}
}
