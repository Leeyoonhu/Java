package big_data.bit.exall;

import java.util.Random;

public class P344Ex10 {
	public static void main(String[] args) {
		int x;
		Random r = new Random(); // 1번 빈칸
		
		for(int i = 0; i < 10; i++) {
			x = (r.nextInt(6) + 1); // 2번 빈칸
			System.out.print(x + " ");
		}
	}
}
