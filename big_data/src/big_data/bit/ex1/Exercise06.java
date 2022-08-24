package big_data.bit.ex1;

import java.util.Scanner;

public class Exercise06 {
	public static void main(String[] args) {
		// 전기를 많이 사용하면 누진율이 적용되어 단가와 기본요금 상승
		// 단가표 kwh 사용량 200이하 단가 99.3 기본료 910
		// 사용량 201~400 단가 187.9 기본료 1600
		// 사용량 400초과 단가 280.6 기본료 7300
		// 전기료 = 기본료 + 사용량 * 단가
		Scanner scan = new Scanner(System.in);
		System.out.print("전기 사용량을 입력하세요 -->> ");
		double usage, unitPrice, base, elecBill;
		usage = scan.nextDouble();

		if (usage <= 200) { // 200이하
			unitPrice = 99.3;
			base = 910;
		}
		else if (usage <= 400) { // 201 ~ 400이하
			unitPrice = 187.9;
			base = 1600;
		}
		else {	// 400초과
			unitPrice = 280.6;
			base = 7300;
		}
		elecBill = base + (unitPrice * usage);
		System.out.printf("사용량 : %.1f kmh\n", usage);
		System.out.printf("기본요금 : %.0f 원\n", base);
		System.out.printf("단가 : %.1f 원\n", unitPrice);
		System.out.printf("전기요금 : %.1f 원\n", elecBill);
	}
}
