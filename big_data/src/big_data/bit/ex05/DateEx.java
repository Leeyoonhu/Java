package big_data.bit.ex05;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEx {
	public static void main(String[] args) {
		Date now = new Date();
		String strNow = now.toString();
		System.out.println(strNow);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 a hh시 mm분 ss초");
		String strNow2 = sdf.format(now);
		
		System.out.println(strNow2);
		
	}
}
