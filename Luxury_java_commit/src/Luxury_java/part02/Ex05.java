package Luxury_java.part02;

// Scanner 를 이용하여 정수 3개를 입력받고 삼각형이 되는지 판별
import static Luxury_java.part02.Ex01.scan;
public class Ex05 {
	public static void main(String[] args) {
		System.out.print("정수 3개 입력>>");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		int num3 = scan.nextInt();
		if(isTriangle(num1, num2, num3)) {
			System.out.println("삼각형이 됩니다.");
		}
		else {
			System.out.println("삼각형이 안됩니다.");
		}	
	}
	static boolean isTriangle(int a, int b, int c) {
		if(a < (b + c) && b < (a + c) && c < (a + b)) {
			return true;
		}
		return false;
	}
}
