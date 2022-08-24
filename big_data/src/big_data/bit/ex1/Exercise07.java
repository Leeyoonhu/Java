package big_data.bit.ex1;

import java.util.Scanner;

public class Exercise07 {
	public static void main(String[] args) {
		// 출생연도(birthYear)을 입력하면 요구사항에 맞춰 마스크 구매 가능한 요일 출력 프로그램 작성
		// 출생연도 끝자리 이용한 5부제 
		// 1,6 >월 - 2,7 >화 - 3,8 >수 - 4,9 >목 - 5,0 >금
		Scanner scan = new Scanner(System.in);
		System.out.print("출생연도를 입력하세요 -->> ");
		int birthYear = scan.nextInt();
		String day = null;
		if((birthYear % 10 == 1 || birthYear % 10 == 6)) {
			day = "월요일";
		}
		else if((birthYear % 10 == 2 || birthYear % 10 == 7)) {
			day = "화요일";
		}
		else if((birthYear % 10 == 3 || birthYear % 10 == 8)) {
			day = "수요일";
		}
		else if((birthYear % 10 == 4 || birthYear % 10 == 9)) {
			day = "목요일";
		}
		else {
			day = "금요일";
		}
		System.out.println(day);
	}
}
