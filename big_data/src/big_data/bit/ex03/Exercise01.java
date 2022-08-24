package big_data.bit.ex03;

import java.util.Scanner;

public class Exercise01 {
	public static void main(String[] args) {
		// 정수 5개를 입력받아 배열에 저장하고 그중 제일 큰 수를 화면에 출력하는 프로그램
		Scanner scan = new Scanner(System.in);
		int[] numArray = new int[5];
		int max = 0;
		System.out.println("정수 5개를 입력하세요...");
		for (int i = 0; i < numArray.length; i++) {
			numArray[i] = scan.nextInt();
			if (max < numArray[i]) {
				max = numArray[i];
			}
		}
		int min = max;
		for(int i = 0; i < numArray.length; i++) {
			if(min > numArray[i]) {
				min = numArray[i];
			}
		}
		System.out.println("가장 큰 수는 " + max);
		System.out.println("가장 작은 수는 " + min);
	}
}
