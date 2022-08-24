package big_data.bit.ex1;

public class WhileEx {
	public static void main(String[] args) {
		int i = 1;
		// 1부터 10까지 출력
		while (i < 11) {
			System.out.printf("%d\t",i);
			i++;
		}
		int sum = 0;
		while (i < 21) {
			sum += i;
			i++;
		}
		System.out.println(sum);
	}
}
