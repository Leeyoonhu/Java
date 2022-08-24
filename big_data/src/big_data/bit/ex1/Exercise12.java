package big_data.bit.ex1;

public class Exercise12 {
	public static void main(String[] args) {
		// 1부터 10까지의 합을 구하기
		// do-while 문 사용
		int i = 1, sum = 0;
		do {
			sum += i;
			i++;
		} while(i < 11);
		System.out.println(sum);
	}
}
