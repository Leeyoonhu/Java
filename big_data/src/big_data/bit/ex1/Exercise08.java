package big_data.bit.ex1;

import java.util.Scanner;

public class Exercise08 {
	public static void main(String[] args) {
		// 음료수 자판기.
		// 1번 coke 2번 sprite 3번 redbull
		// 나머지 번호는 wrong choice
		// switch-case 문 사용할 것
		Scanner scan = new Scanner(System.in);
		System.out.print("메뉴를 선택하시오 (1-3) ");
		int menuNum = scan.nextInt();
		String menu = null;
		switch (menuNum) {
		case 1:
			menu = "coke";
			break;
		case 2:
			menu = "sprite";
			break;
		case 3:
			menu = "redbull";
			break;
		default:
			menu = "wrong choice";
		}
		System.out.println(menu);
	}
}
