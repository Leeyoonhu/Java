package big_data.bit.exall;

import java.util.Scanner;

public class P80Ex04 {
	public static void main(String[] args) {
		//초를 입력하면, 시간, 분, 초로 환산해주는 프로그램
		Scanner scan = new Scanner(System.in);
		System.out.printf("초 단위 정수를 입력하세요 : ");
		int second = scan.nextInt();
		int hour = second / (60 * 60);
		int min = (second / 60) - (hour * 60);
		second = second % 60;
		System.out.printf("%d시간 %d분 %d초", hour, min, second);
	}
}
