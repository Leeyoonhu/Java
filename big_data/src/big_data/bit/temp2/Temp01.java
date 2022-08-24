package big_data.bit.temp2;


import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;
import java.util.StringTokenizer;



public class Temp01 {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		String[] Noon = {"오전", "오후"};
		System.out.printf("%d.0%d.%d %s %d:%d:%d\n", 
				c.get(c.YEAR), c.get(c.MONTH) + 1, c.get(c.DATE), 
				Noon[c.get(c.AM_PM)], c.get(c.HOUR), c.get(c.MINUTE), c.get(c.SECOND));
		System.out.printf("오늘은 %d월의 %d번째 날\n", c.get(c.MONTH) + 1, c.get(c.DAY_OF_MONTH));
		System.out.printf("오늘은 %d년의 %d번째 날\n", c.get(c.YEAR), c.get(c.DAY_OF_YEAR));
		
		System.out.printf("%d의 %d승은 %.0f입니다.\n", 2, 5, Math.pow(2, 5));
		System.out.printf("%d의 제곱근은 %.0f입니다.\n", 625, Math.sqrt(625));
	}	
}
