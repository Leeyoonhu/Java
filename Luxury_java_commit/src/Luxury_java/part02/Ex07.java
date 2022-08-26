package Luxury_java.part02;
// 두 점(100,100) (200,200) 사이에 사각형이 존재하는지 판별하기
import static Luxury_java.part02.Ex01.scan;
public class Ex07 {
	public static void main(String[] args) {
		System.out.print("점 (x,y)의 좌표를 입력하시오>>");
		int x = scan.nextInt();
		int y = scan.nextInt();
		if((x >= 100 && x <= 200) && (y >= 100 && y <= 200)) {
			System.out.printf("(%d, %d)는 사각형 안에 있습니다.", x, y);
		}
		else {
			System.out.printf("(%d, %d)는 사각형 안에 없습니다.", x, y);
		}
	}
}
