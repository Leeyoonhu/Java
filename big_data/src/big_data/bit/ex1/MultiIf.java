package big_data.bit.ex1;

import java.util.Scanner;

public class MultiIf {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.printf("당신의 점수를 입력하세요..\n");
		int score = scan.nextInt();

		if (score >= 90) {
			System.out.println("A");
		} 
		else if (score >= 80) {
			System.out.println("B");
		} 
		else if (score >= 70) {
			System.out.println("C");
		} 
		else if (score >= 60) {
			System.out.println("D");
		} 
		else {
			System.out.println("F");
		}

	}
}
