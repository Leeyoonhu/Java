package homework;

public class Day03Ex03 {
	public static void main(String[] args) {
		// 가로세로 길이의 변화에 따른 삼각형의 넓이 구하는 무한루프 프로그램
		// 가로는 2의배수, 세로는 3의 배수로 증가
		// 넓이가 150보다 크면 프로그램 종료
		double width = 2, height = 3, area = 0;
		while(true) {
			area = ((width * height) / 2);
			if(area > 150) {
				break;
			}
			System.out.printf("삼각형의 넓이 : %.1f\n", area);
			width += 2; height += 3;
		}
	}
}
