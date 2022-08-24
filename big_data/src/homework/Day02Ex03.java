package homework;

import java.util.Scanner;

public class Day02Ex03 {
	public static void main(String[] args) {
		// 장비를 사용하기까지 걸린 시간 입력시 생존률이 출력되는 프로그램 만들기
		Scanner scan = new Scanner(System.in);
		System.out.print("최초 장비를 사용하기까지 걸린 시간을 입력하세요 -->> ");
		int time = scan.nextInt();
		int lifeRatio;
		if(time <= 60) {
			lifeRatio = 85;
		}
		else if(time <= 120) {
			lifeRatio = 76;
		}
		else if(time <= 180) {
			lifeRatio = 66;
		}
		else if(time <= 240) {
			lifeRatio = 57;
		}
		else if(time <= 300) {
			lifeRatio = 47;
		}
		else {
			lifeRatio = 25;
		}
		if(lifeRatio != 25) {
			System.out.print("생존율 : " + lifeRatio + "%");
		}
		else {
			System.out.print("생존율 : " + lifeRatio + "% 미만");
		}
	}
}
