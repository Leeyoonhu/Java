package Luxury_java.part02;
// 두 원의 좌표 및 반지름을 입력하고 서로 겹치는지 판단
import static Luxury_java.part02.Ex01.scan;
public class Ex10 {
	public static void main(String[] args) {
		System.out.print("첫번째 원의 중심과 반지름 입력>>");
		int x1 = scan.nextInt();
		int y1 = scan.nextInt();
		int r1 = scan.nextInt();
		System.out.print("두번째 원의 중심과 반지름 입력>>");
		int x2 = scan.nextInt();
		int y2 = scan.nextInt();
		int r2 = scan.nextInt();
		// x좌표의 차이가 <= 반지름의 합보다
		// y좌표의 차이가 <= 반지름의 합
		// x좌표 절대값의 합의 제곱 + y좌표 절대값의 합의 제곱 =< 반지름 합의 제곱
		int r = r1 + r2;
		double x = Math.abs(Math.abs(x1) - Math.abs(x2));
		double y = Math.abs(Math.abs(y1) - Math.abs(y2));
		if(x <= r && y <= r) {
			if(Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(r, 2)) {
				System.out.println("두 원은 서로 겹친다");
			}
			else {
				System.out.println("두 원은 서로 겹치지 않는다");
			}
		}
		else {
			System.out.println("두 원은 서로 겹치지 않는다");
		}
	}
}
