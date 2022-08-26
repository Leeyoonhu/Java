package Luxury_java.part02;
// 원의 중심과 반지름이 주어질때, 점의 좌표를 입력하여 해당 점이 원 안에있는지 판별
import static Luxury_java.part02.Ex01.scan;
public class Ex09 {
	public static void main(String[] args) {
		System.out.print("원의 중심과 반지름 입력>>");
		int x1 = scan.nextInt();
		int y1 = scan.nextInt();
		double r = scan.nextDouble();
		System.out.print("점 입력>>");
		int x2 = scan.nextInt();
		int y2 = scan.nextInt();
		if(((x2 >= x1 - r) && (x2 <= x1 + r)) && ((y2 >= x1 - r) && (y2 <= x1 + r))) {
			if(Math.pow(x2, 2) + Math.pow(y2, 2) <= Math.pow(r, 2)) {
				System.out.printf("점 (%.1f, %.1f)는 원 안에 있다.", (double)x2, (double)y2);
			}
			else {
				System.out.printf("점 (%.1f, %.1f)는 원 밖에 있다.", (double)x2, (double)y2);
			}
		}
		else {
			System.out.printf("점 (%.1f, %.1f)는 원 밖에 있다.", (double)x2, (double)y2);
		}
			
	}
}
