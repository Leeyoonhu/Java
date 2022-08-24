package homework;

import java.util.Scanner;

public class ChangeDay02Ex05 {
	// 05 문제를 score를 받아 출력하는 프로그램으로 바꾸기
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("점수를 입력하시오 -->> ");
		int score = scan.nextInt();
		if(score >= 80) {
			System.out.println("참 잘했음");
		}
		else if(score >= 60) {
			System.out.println("좀 더 노력해");
		}
		else {
			System.out.println("다음 학기에 다시 만나요!");
		}
	}
}
