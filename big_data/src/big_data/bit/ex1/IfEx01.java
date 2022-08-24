package big_data.bit.ex1;

import java.util.Scanner;

public class IfEx01 {
	public static void main(String[] args) {
		// 기계 온도 입력
		// 40도 이상이면 팬(fan)가동, 40도 미만이면 팬(fan)중지
		Scanner scan = new Scanner(System.in);
		System.out.print("기계 온도를 입력하세요 : ");
		double temp = scan.nextDouble();
		
		System.out.println((temp >= 40)? "팬(fan)가동" : "팬(fan)중지");
	}
}
