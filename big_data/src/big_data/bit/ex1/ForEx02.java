package big_data.bit.ex1;

public class ForEx02 {
	public static void main(String[] args) {
		// 구구단 출력
		for(int j = 1; j < 10; j++) {
			for(int i = 2; i < 10; i++) {
				System.out.printf("%d * %d = %d\t", i, j, i*j);
			}
			System.out.println();
		}
	}
}
