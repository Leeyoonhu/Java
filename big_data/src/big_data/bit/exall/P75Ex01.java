package big_data.bit.exall;

import java.util.Scanner;

public class P75Ex01 {
	
		// 직사각형 가로 세로 입력받아 넓이 구하기
		// 조건1. main()메서드 포함
		public static void main(String[] args) {
			// 조건2. 가로, 세로, 넓이 double형
			double x, y, area;
			// 조건3. 키보드를 입력받을수 있는 Scanner 객체 생성
			Scanner scan = new Scanner(System.in);
			// 조건4. 코드 참고해서 입력받는 실행문 추가
			System.out.print("직사각형의 가로 길이를 입력하세요 : ");
			x = scan.nextDouble();
			System.out.print("직사각형의 세로 길이를 입력하세요 : ");
			y = scan.nextDouble();
			// 조건5. 넓이를 계산해 변수에 대입후 화면에 실행
			area = x * y;
			// 조건6. 완성된 클래스 실행해서 결괏값 출력 확인
			System.out.printf("직사각형의 넓이 : %.1f", area);
		}
		
	
}
