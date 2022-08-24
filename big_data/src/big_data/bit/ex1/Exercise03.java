package big_data.bit.ex1;

import static big_data.bit.ex1.Exercise01.scan;

public class Exercise03 {
	public static void main(String[] args) {
		// 거리 = 속도 * 시간
		// 속도와 시간을 입력하면 자동차의 주행거리를 구하는 프로그램 작성하기
		System.out.print("주행 속도(km/h) : ");
		int speed = scan.nextInt();
		System.out.print("주행 시간(h) : ");
		int hour = scan.nextInt();
		System.out.printf("주행 이동 거리(km) : %d", speed * hour);
		
	}
}
