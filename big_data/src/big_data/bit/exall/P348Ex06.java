package big_data.bit.exall;

import java.util.Calendar;

public class P348Ex06 {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		String[] noonName = {"오전", "오후"};
		
		int year = c.get(Calendar.YEAR); 
		int month = c.get(Calendar.MONTH); 
		int day = c.get(Calendar.DATE);
		String noon = noonName[c.get(Calendar.AM_PM)];
		int hour = c.get(Calendar.HOUR); 
		int minute = c.get(Calendar.MINUTE); 
		int second = c.get(Calendar.SECOND);
		int dayOfYear = c.get(Calendar.DAY_OF_YEAR);
		
		// 오늘 날짜 다양한 방식으로 출력하기
		System.out.printf("%d.0%d.0%d %s %d:%d:%d\n", year, month, day, noon, hour, minute, second);
		System.out.printf("오늘은 %d월의 %d번째 날\n", month, day);
		System.out.printf("오늘은 %d년의 %d번째 날", year, dayOfYear);
	}
}
