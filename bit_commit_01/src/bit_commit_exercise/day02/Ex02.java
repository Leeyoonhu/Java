package bit_commit_exercise.day02;

// 교통카드 잔액 출력
// 1회 사용당 1250원, 잔액이 부족하면 출력종료

import static bit_commit_exercise.day02.Ex01.scan;

public class Ex02 {
	public static void main(String[] args) {
		System.out.print("최초 충전금액 -->> ");
		int money = scan.nextInt();
		System.out.printf("%d원이 충전되었음\n", money);
		int cnt = 0;
		while(true) {
			if(money >= 1250) {
				cnt++;
				money-= 1250;
				System.out.printf("%d회 사용한 후 현재 잔액은 %d원\n",cnt, money);
			}
			if(money < 1250) {
				break;
			}
		}
	}
}
