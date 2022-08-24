package big_data.bit.ex1;

import java.util.Scanner;

public class Exercise09 {
	public static void main(String[] args) {
		// 구구단 시작단 끝단 입력 프로그램 작성
		// 단 시작단이 끝단보다 클 경우, 감소하는 방향으로
		int sDan = 0, eDan = 0; // 시작단 끝단
		int count = 1;
		Scanner scan = new Scanner(System.in);
		//sDan과 eDan에 정수가아닌 다른값이 들어오면 재입력(무한반복)
		//try-catch이용할것
		// 예외 발생시에 제대로 입력하면 while문을 빠져나가게...
			System.out.print("구구단의 시작단 입력 -->> ");
			while(true) {
				try {
					sDan = scan.nextInt();
				} catch (Exception e) {
					System.out.println("시작단에는 정수값만 입력해주세요!");
					scan.nextLine();
					System.out.print("구구단의 시작단 재입력 -->> ");
					continue;
				}
				break;
			}
			System.out.print("구구단의 끝단 입력 -->> ");
			while(true) {
				try {
					eDan = scan.nextInt();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("끝단에는 정수값만 입력해주세요!");
					scan.nextLine();
					System.out.print("구구단의 끝단 재입력 -->> ");
					continue;
				}
				break;
			}
			
		if ((sDan > 0 && sDan < 10) && (eDan > 0 && eDan < 10)) { // 유효성 검사
			for (int i = 1; i < 10; i++) {
				for (int j = sDan; j <= eDan; j++) {
					System.out.printf("%d * %d = %d  ", j, i, j * i);
				}
				if (sDan > eDan) {
					for (int j = sDan; j >= eDan; j--) {
						System.out.printf("%d * %d = %d  ", j, i, j * i);
					}
				}
				System.out.println();
			}
			System.out.print("다시 하시겠습니까?(Y/Exit) >> ");
			String choice = scan.next();
			if (choice.equals("Y") || choice.equals("y")) {
				System.out.println("구구단을 다시 실행합니다.");
				System.out.println("현재 실행된 구구단 횟수 : " + count + "번");
				count++;
				main(null);
			} else {
				System.exit(0);
			}
		} else {
			System.out.println("시작단의 범위 (1~9) 끝단의 범위 (1~9). 다시 입력해 주세요");
			main(null);
		}
	}
}
