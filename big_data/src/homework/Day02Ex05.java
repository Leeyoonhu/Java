package homework;

import java.util.Scanner;

public class Day02Ex05 {
	public static void main(String[] args) {
		//학점(A~F)를 입력받아 출력 프로그램 작성
		//A,B => 참 잘했음
		//C,D => 좀 더 노력해
		//F => 다음 학기에 다시 만나요
		Scanner scan = new Scanner(System.in);
		System.out.printf("학점을 입력하시오 -->> ");
		String grade = scan.next();
		if(grade.equals("A") || grade.equals("B")) {
			System.out.println("참 잘했음");
		}
		else if(grade.equals("C") || grade.equals("D")) {
			System.out.println("좀 더 노력해");
		}
		else {
			System.out.println("다음 학기에 다시 만나요");
		}
		
	}
}
