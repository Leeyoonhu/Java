package big_data.bit.exall;

import java.util.Scanner;

public class P81Ex08 {
	public static void main(String[] args) {
		// 키보드로 0부터 999사이의 정수를 입력받아 각 자릿수를 더한 결과값 출력 프로그램
		Scanner scan = new Scanner(System.in);
		System.out.print("0~999 사이의 정수를 입력하세요 : ");
		int num = scan.nextInt();
		int num100 = num / 100;
		int num10 = num / 10;
		int num1 = num % 10 -(( num / 100 ) * 10 );
		int totalNum = num100 + num10 + num1;
		System.out.printf("각 자릿수의 합 = %d", totalNum);
	}
}
