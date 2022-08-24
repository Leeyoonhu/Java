package big_data.bit.ex05;

import java.util.Random;

public class RandomEx {
	public static void main(String[] args) {
		Random r = new Random();
		// 로또번호 추첨
		for(int i = 0; i < 10; i++) {
			System.out.println(r.nextInt(45)+1);	
		}
		
		
	}
}
