package bit_commit_exercise.day01;

// 해수면에서 10m 내려갈때마다 수온이 0.7도씩 내려간다
// 수심을 입력하면 수심 계산하는 프로그램
// 0m에서의 수심은 20도
import java.util.*;

public class ex01 {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("수심을 입력하세요 : ");
		int depthOfWater = scan.nextInt();
		double waterTemp = 20.0 - (0.7 * ((int)depthOfWater / 10));
		System.out.printf("수온 : %.1f", waterTemp);
	}
}
