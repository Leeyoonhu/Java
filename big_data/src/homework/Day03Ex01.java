package homework;

import java.util.Scanner;

public class Day03Ex01 {
	public static void main(String[] args) {
		//n단의 숫자 피라미드 만들기
		int num = 1;
		Scanner scan = new Scanner(System.in);
		System.out.print("정수를 입력하세요 >> ");
		int n = scan.nextInt();
		int spaceCount = n - 1;
		for(int i = 1; i <= n; i++) {
			for(int k = spaceCount; k > 0; k--) {
				System.out.printf(" ");
			}
			for(int j = 0; j < (2 * i) - 1; j++) {
				System.out.print(num);
			}
			for(int k = spaceCount; k > 0 ; k--) {
				System.out.printf(" ");
			}
			spaceCount--;
			num++;
			if(num >= 10) {
				num %= 10;
			}
			System.out.println();
		}
	}
}
