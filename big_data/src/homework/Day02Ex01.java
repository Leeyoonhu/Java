package homework;

import java.util.Scanner;

public class Day02Ex01 {
	public static void main(String[] args) {
		// 해수면에서 10m 내려갈때마다 수온 0.7감소
		// 수심입력하면 수온 계산프로그램 작성
		Scanner scan = new Scanner(System.in);
		System.out.print("수심을 입력하세요 : ");
		int seaLevel = scan.nextInt();
		double waterTemper = 20.0;
		int num = seaLevel / 10;  
		for(int i = 0; i < num; i++) {
			waterTemper -= 0.7;
		}
		System.out.printf("수온 : %.1f", waterTemper);
	}
}
