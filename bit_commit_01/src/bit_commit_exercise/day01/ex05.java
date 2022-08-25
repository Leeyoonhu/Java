package bit_commit_exercise.day01;
// 학점에 따른 문구 출력 프로그램

import static bit_commit_exercise.day01.ex01.scan;

public class ex05 {
	public static void main(String[] args) {
		System.out.print("점수를 입력하시오 -->> ");
		int score = scan.nextInt();
		String grade = null;
		if (score >= 90 && score <= 100) {
			grade = "A";
		}
		else if (score >= 80) {
			grade = "B";
		}
		else if (score >= 70) {
			grade = "C";
		}
		else if (score >= 60) {
			grade = "D";
		}
		else if (score >= 0) {
			grade = "E";
		}
		
		switch(grade) {
		case "A": case "B":
			System.out.println("참 잘했음");
			break;
		case "C": case "D":
			System.out.println("좀 더 노력해");
			break;
		case "E":
			System.out.println("다음 학기에 다시 만나요!");
			break;
		}
	}
}
