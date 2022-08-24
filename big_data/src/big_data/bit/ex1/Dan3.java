package big_data.bit.ex1;

import java.util.Scanner;

public class Dan3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("단을 입력하세요 (1~9) : ");
		int dan = scan.nextInt();
		for(int i = 1; i < 10; i++) {
			System.out.printf("%d * %d = %d\n", dan, i, dan * i);
		}
	}
}
