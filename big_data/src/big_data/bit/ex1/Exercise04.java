package big_data.bit.ex1;

import java.util.Scanner;

public class Exercise04 {
	public static void main(String[] args) {
		// 가구 인원수에 따른 국가 재난 지원금 수령액 안내하는 프로그램 작성
		// 1인 40, 2인 60, 3인 80, 4인이상 100
		Scanner scan = new Scanner(System.in);
		System.out.printf("인원 수를 입력하시오 -->> ");
		int humanNum = scan.nextInt();
		if(humanNum >= 4) {
			System.out.println("1,000,000원 지원");
		}
		else if(humanNum >= 3) {
			System.out.println("800,000원 지원");
		}
		else if(humanNum >= 2) {
			System.out.println("600,000원 지원");
		}
		else if(humanNum >= 1) {
			System.out.println("400,000원 지원");
		}
	}
}
