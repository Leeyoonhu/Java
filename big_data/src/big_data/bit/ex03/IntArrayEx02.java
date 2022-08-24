package big_data.bit.ex03;

import java.util.Scanner;

public class IntArrayEx02 {
	public static void main(String[] args) {
		// 학생 성적 관리 프로그램 작성
		// 학생 수(5명)만큼 성적을 입력받아서 평균을 구하는 프로그램을 만들어라
		// 평균 = 값들의 합 / 학생 수
		Scanner scan = new Scanner(System.in);
		int[] scores = new int[5];
		int sum = 0;
		System.out.println("학생 수만큼 성적을 입력하세요... ");
		for(int i = 0; i < scores.length; i++) {
			scores[i] = scan.nextInt(); // 입력받아 배열에 저장하는 작업
			sum += scores[i]; // 배열에 저장된 값을 읽어와서 sum 에 더하는 작업
		}
		double avgScore = (double)sum / scores.length;
		System.out.println("평균 : "+avgScore);
	}
}
