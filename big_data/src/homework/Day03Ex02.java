package homework;

import java.util.Scanner;

public class Day03Ex02 {
	public static void main(String[] args) {
		//교통카드 잔액 줄이기
		// 버스 1회당 사용요금은 1250원
		// 카드 사용시마다 사용횟수와 잔액 출력프로그램 생성
		// 잔액이 0원 미만이되면 출력종료
		int count = 1, lastMoney;
		Scanner scan = new Scanner(System.in);
		System.out.print("최초 충전금액 -->> ");
		int firstMoney = scan.nextInt();
		System.out.println(firstMoney + "원이 충전되었음");
		lastMoney = firstMoney - 1250;
		while(true) {
			System.out.printf("%d회 사용한 후 현재 잔액은 %d원\n", count, lastMoney);
			count++;
			lastMoney -= 1250;
			if(lastMoney < 0) {
				break;
			}
		}
	}
}
