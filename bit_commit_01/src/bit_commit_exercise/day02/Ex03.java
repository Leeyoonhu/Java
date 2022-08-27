package bit_commit_exercise.day02;

// 가로와 세로 길이 변화에 따른 삼각형 넓이 구하는 프로그램
// 삼각형의 넓이가 150보다 크면 프로그램 종료
// 가로는 2씩, 세로는 3씩 증가
public class Ex03 {
	public static void main(String[] args) {
		int width = 0;
		int height = 0;
		while(true) {
			width += 2;
			height += 3;
			double area = ((width * height) / 2);
			if(area > 150) {
				break;
			}
			System.out.printf("삼각형의 넓이 : %.1f\n", area);
		}
	}
}
