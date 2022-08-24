package big_data.bit.ex1;

public class Exercise14 {
	public static void main(String[] args) {
		// for와 continue문을 사용하여 1부터 100까지 짝수의 합 구하기
		int sum = 0;
		for(int i = 0; i < 101; i++) {
			if(i % 2 == 1) {
				continue;
			}
			sum += i;
		}
		System.out.println(sum);
	}
}
