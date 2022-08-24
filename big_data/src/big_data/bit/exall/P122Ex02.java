package big_data.bit.exall;

import java.util.Scanner;

public class P122Ex02 {
	public static void main(String[] args) {
		// 키보드로 등수를 입력받아 1등이면 아주 잘했습니다
		// 2~3등이면 잘했습니다
		// 4~6등이면 보통입니다
		// 그 외 노력해야겠습니다 출력
		// switch-case 문 사용할 것
		Scanner scan = new Scanner(System.in);
		System.out.print("등수 입력 : ");
		int rank = scan.nextInt();
		switch (rank) {
		case 1:
			System.out.println("아주 잘했습니다");
			break;
		case 2: case 3:
			System.out.println("잘했습니다");
			break;
		case 4: case 5: case 6:
			System.out.println("보통입니다");
			break;
		default:
			System.out.println("노력해야겠습니다.");
		}
	}
}
