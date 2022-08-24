package big_data.bit.ex05;

import java.util.Calendar;

public class CalendarEx {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		System.out.println("현재는 : " + c.getTime());
		c.add(c.DATE, -15); // 15일전
		System.out.println("15일 전은 : " + c.getTime());
		c.add(c.MONTH, 5); // 4개월 후
		System.out.println("4개월 후는 : " + c.getTime());
		c.add(c.YEAR, 2); // 2년 후
		System.out.println("2년 후는 : " + c.getTime());
	}
	
	public static void Test01(String[] args) {
		// Calendar 클래스는 추상 클래스
		// 따라서 객체를 만들때는 .getInstance() 함수 사용
		Calendar c = Calendar.getInstance();
		// 현재 날짜와 시간
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		System.out.println("현재 날짜는 " + year + "년 " + month + "월입니다.");
		
		
		
	}
}
