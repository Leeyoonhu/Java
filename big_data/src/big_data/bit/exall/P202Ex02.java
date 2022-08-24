package big_data.bit.exall;

import java.util.Scanner;

public class P202Ex02 {
	public static void main(String[] args) {
		// Ex01의 프로그램을 for문과 if~else문을 사용해 학생 등급 출력프로그램으로 확장
		// for~each문도 사용할것
		int numOfStudents = 0;
		int[] scores;
		Scanner scan = new Scanner(System.in);
		// 2. 키보드로 학생수를 입력받고 입력된 수에 해당하는 크기의 배열 생성
		System.out.print("학생 수? ");
		numOfStudents = scan.nextInt();
		scores = new int[numOfStudents];
		// 3. for 문을 이용해 학생 수만큼 키보드로 성적을 입력받은 후 출력하도록 한다
		System.out.printf("%d명의 학생 성적을 입력하세요.\n", numOfStudents);
		for(int i = 0; i < scores.length; i++) {
			scores[i] = scan.nextInt();
		}
		System.out.printf("%d명의 학생 성적은 다음과 같습니다.\n", numOfStudents);
		for(int i = 0; i < scores.length; i++) {
			System.out.print(scores[i] + " ");
		}
		System.out.println();
		// Ex01코드이후 for문 한번 더 사용
		// if~else 문을 통해 scores 배열의 각 원소에 대하여 점수구간별로 등급 출력 코드 추가
		String grade = null;
		for(int i = 0; i < scores.length; i++) {
			if(scores[i] >= 90) {
				grade = "A";
				System.out.printf("%d번 학생의 등급은 %s입니다.\n", i+1, grade);
			}
			else if(scores[i] >= 80) {
				grade = "B";
				System.out.printf("%d번 학생의 등급은 %s입니다.\n", i+1, grade);
			}
			else if(scores[i] >= 70) {
				grade = "C";
				System.out.printf("%d번 학생의 등급은 %s입니다.\n", i+1, grade);
			}
			else if(scores[i] >= 60) {
				grade = "D";
				System.out.printf("%d번 학생의 등급은 %s입니다.\n", i+1, grade);
			}
			else {
				grade = "F";
				System.out.printf("%d번 학생의 등급은 %s입니다.\n", i+1, grade);
			}
		}
	}
}
