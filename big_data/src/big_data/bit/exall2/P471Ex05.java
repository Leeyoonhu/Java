package big_data.bit.exall2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P471Ex05 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int score = 0;
		ArrayList<Integer> sList = new ArrayList<Integer>(); 
		// 입력된 정수가 음수일때까지 점수 무한 입력
		for(int i = 0; ; i++) {
			System.out.print("점수를 입력하세요 : ");
			score = scan.nextInt();
			if(score < 0) {
				break;
			}
			sList.add(score);
		}
		System.out.println("전체 학생은 " + sList.size() + "명이다.");
		System.out.print("학생들의 성적 : ");
		int max = Collections.max(sList);
		// 점수중에서 최고점 뽑기
		for(int i = 0; i < sList.size(); i++) {
			System.out.print(sList.get(i) + " ");
		}
		System.out.println();
		String grade = null;
		// 현재 값 - 최고점에서 뺏을때의 조건에 따른 grade 설정
		for(int i = 0; i < sList.size(); i++) {
			if(sList.get(i) - max >= -10) {
				grade = "A";
				System.out.printf("%d번 학생의 성적은 %d점이며, 등급은 %s이다.\n", i, sList.get(i), grade);
			}
			else if(sList.get(i) - max >= -20) {
				grade = "B";
				System.out.printf("%d번 학생의 성적은 %d점이며, 등급은 %s이다.\n", i, sList.get(i), grade);
			}
			else {
				grade = "C";
				System.out.printf("%d번 학생의 성적은 %d점이며, 등급은 %s이다.\n", i, sList.get(i), grade);
			}
		}
	}
}
