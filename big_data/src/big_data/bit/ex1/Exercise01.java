package big_data.bit.ex1;

import java.util.Scanner;

public class Exercise01 {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// 사용자한테 키(m)와 몸무게(kg)를 각각 입력받아서 BMI를 계산하는 프로그램 작성하기)
		double height, weight;
		System.out.print("키(m) : ");
		height = scan.nextDouble();
		System.out.print("몸무게(kg) : ");
		weight = scan.nextDouble();
		double bmi = weight / (height * height);
		System.out.printf("BMI 수치는 %d입니다.", (int) bmi);

	}
}
