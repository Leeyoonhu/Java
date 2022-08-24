package big_data.bit.exall;

import java.util.Scanner;

public class P209Ex05 {
	public static void main(String[] args) {
		// 0~99 정수를 10개 입력받아 10단위 간격의 히스토그램 출력프로그램
		// 음수를 입력받을 시 무시
		Scanner scan = new Scanner(System.in);
		int[] numArray = new int[10];
		System.out.println("숫자를 10개 입력하세요.");
		for(int i = 0; i < numArray.length; i++) {
			numArray[i] = scan.nextInt();
		}
		int min = 0, max = 9;
		for(int i = 0; i < numArray.length; i++) {
			if(min == 0) {
				System.out.printf(" %d ~  %d : ", min, max);
			}
			else {
				System.out.printf("%d ~ %d : ", min, max);
			}
			for(int j = 0; j < numArray.length; j++) {
				if(numArray[j] >= min && numArray[j] <= max) {
					System.out.print("*");
				}
			}
			min += 10; max += 10;
			System.out.println();
			if(min > 90 && max > 99) {
				break;
			}
		}
	}
}
