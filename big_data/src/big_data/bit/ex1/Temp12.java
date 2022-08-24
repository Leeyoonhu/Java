package big_data.bit.ex1;

import java.util.Random;

public class Temp12 {
	public static void main(String[] args) {
		int x;
		Random r = new Random(); // 1번 빈칸
		
		for(int i = 0; i < 10; i++) {
			x = (r.nextInt(6) + 1); // 2번 빈칸
			System.out.print(x + " ");
		}
	}
}
