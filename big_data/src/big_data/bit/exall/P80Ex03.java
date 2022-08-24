package big_data.bit.exall;

import java.util.Scanner;

public class P80Ex03 {
	public static void main(String[] args) {
		// 원기둥 부피 구하는 프로그램
		Scanner scan = new Scanner(System.in);
		System.out.print("원기둥의 밑면 반지름은? ");
		int radius = scan.nextInt();
		System.out.print("원기둥의 높이는? ");
		int height = scan.nextInt();
		double volume = (double)(3.14 * radius * radius * height);
		System.out.printf("원기둥의 부피는 %.1f", volume);
	}
}
