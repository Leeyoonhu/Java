package big_data.bit.ex1;

public class ForExTemp {
	public static void main(String[] args) {
		// 3단씩끊기
		for(int i = 2; i < 10; i += 3) {
			System.out.print("****" + i + "단****\t");
			System.out.print("****" + (i+1) + "단****\t");
			if(i + 2 <= 9) {
				System.out.print("****" + (i+2) + "단****\n");
			}
			else if (i + 2 > 9) {
				System.out.println();
			}
			for(int j = 1; j < 10; j++) {
				System.out.printf("%d * %d = %d\t", i, j, i * j);
				System.out.printf("%d * %d = %d\t", i + 1, j, (i + 1) * j);
				if(i + 2 <= 9) {
					System.out.printf("%d * %d = %d\n", i + 2, j, (i + 2) * j);
				}
				else if (i + 2 > 9) {
					System.out.println();
				}
			}
			System.out.println();
		}
	}
}
