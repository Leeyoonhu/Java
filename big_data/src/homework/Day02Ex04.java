package homework;

import java.util.Scanner;

public class Day02Ex04 {
	public static void main(String[] args) {
		// 버스 전용차로 단속 프로그램
		// 버스 전용차로에 다른 차종 주행할경우 단속
		// 단 공휴일 및 토요일은 단속하지않음
		Scanner scan = new Scanner(System.in);
		System.out.println("1.월~금 2.토요일 3.공휴일");
		System.out.print("요일을 선택하세요(1~3) --> ");
		int num = scan.nextInt();
		if(num == 1) {
			System.out.println("버스 전용차로 단속 중입니다.");
			System.out.println("1.버스 2.승용차");
			System.out.print("차종을 선택하세요(1,2) --> ");
			int num2 = scan.nextInt();
			if(num2 == 1) {
				System.out.println("버스임");
			}
			else {
				System.out.println("버스 전용차로 위반!!");
			}
		}
		else {
			System.out.println("토요일, 공휴일은 단속하지 않아요~");
		}
		
		
	}
}
