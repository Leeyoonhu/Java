package Luxury_java.part02;
// 입력받은 두 점으로 만든 사각형이 두 점(100,100) (200,200) 사이에 존재하는지 판별하기
import static Luxury_java.part02.Ex01.scan;
public class Ex08 {
	public static void main(String[] args) {
		System.out.print("첫번째 점>>");
		int x1 = scan.nextInt();
		int y1 = scan.nextInt();
		System.out.print("두번째 점>>");
		int x2 = scan.nextInt();
		int y2 = scan.nextInt();
		if(((x1 >= 100 && x1 <= 200) && (x2 >= 100 && x2 <= 200)) && ((y1 >= 100 && y1 <= 200) && (y2 >= 100 && y2 <= 200))) {
			System.out.println("사각형이 두 점 사이에 존재합니다.");
		}
		else {
			System.out.println("사각형이 두 점 사이에 존재하지 않습니다..");
		}
	}
}
