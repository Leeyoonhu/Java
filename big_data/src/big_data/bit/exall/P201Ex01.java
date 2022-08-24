package big_data.bit.exall;

import java.util.Scanner;

public class P201Ex01 {
	public static void main(String[] args) {
		//성적관리 프로그램 만들기
		//문자열 연산, 배열 연산, for ~ each, 열거 타입 적용
		// 학생 수와 점수를 입력하면 각 학생의 성적을 출력하는 프로그램
		// 1. 학생 수와 점수를 위한 배열 변수 선언, Scanner 클래스 선언
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
	}
}
