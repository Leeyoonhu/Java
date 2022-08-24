package big_data.bit.ex1;

public class SumEx {
	public static void main(String[] args) {
		// 1+2+3..... +10 만들기
		int sum = 0;
		for (int i = 0;; i++) {
			sum += i;	// sum = sum + i;
			if (i == 10) {
				break;
			}
		}
		System.out.println("1부터 10까지의 합은 " + sum);
	}
}
