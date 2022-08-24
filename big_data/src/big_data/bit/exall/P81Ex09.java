package big_data.bit.exall;

import java.util.Scanner;

public class P81Ex09 {
	public static void main(String[] args) {
		// 대학 졸업하려면 최소 140학점
		// 전공은 70학점 이상이여야하며
		// 교양 일반은 각 30학점 이상이거나 둘다 80학점 이상이어야 한다
		// 졸업 가능 여부 판단 프로그램 작성
		Scanner scan = new Scanner(System.in);
		System.out.print("전공 이수 학점 : ");
		int score1 = scan.nextInt();
		System.out.print("교양 이수 학점 : ");
		int score2 = scan.nextInt();
		System.out.print("일반 이수 학점 : ");
		int score3 = scan.nextInt();
		int total = score1 + score2 + score3;
		System.out.println(total >= 140 && (score1 >= 70) && ((score2 >= 30 && score3 >= 30 || score2 + score3 >= 80))? "졸업 가능" : "졸업 불가능");
	}
}
