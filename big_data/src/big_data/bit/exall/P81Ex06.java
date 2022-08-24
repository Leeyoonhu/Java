package big_data.bit.exall;

import java.util.Scanner;

public class P81Ex06 {
	public static void main(String[] args) {
		//화씨온도 입력받아 섭씨온도로 환산해 출력하는 프로그램 작성
		Scanner scan = new Scanner(System.in);
		System.out.print("화씨온도를 입력하세요 : ");
		double ft = scan.nextDouble();
		double ct = (double)((double)5/9 * (ft - 32));
		System.out.printf("화씨온도 %f를 섭씨온도 %f로 환산하였습니다.", ft, ct);
	}
}
