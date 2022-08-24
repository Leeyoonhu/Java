package big_data.bit.exall;

import java.util.Calendar;


public class P346Ex03 {
	public static void main(String[] args) {
		String[] weekName = {"일", "월", "화", "수", "목", "금", "토"};
		String[] noonName = {"오전", "오후"};
		Calendar c = Calendar.getInstance();
		// 코드 추가
		int year = c.get(Calendar.YEAR); 
		int month = c.get(Calendar.MONTH); 
		int day = c.get(Calendar.DATE);
		String week = weekName[c.get(Calendar.DAY_OF_WEEK) - 1]; 
		String noon = noonName[c.get(Calendar.AM_PM)];
		int hour = c.get(Calendar.HOUR); 
		int minute = c.get(Calendar.MINUTE); 
		int second = c.get(Calendar.SECOND);
		
		System.out.println(year + "년 " + month + "월 " + day + "일 ");
		System.out.println(week + "요일 " + noon);
		System.out.print(hour + "시 " + minute + "분 " + second + "초 ");
	}
}
