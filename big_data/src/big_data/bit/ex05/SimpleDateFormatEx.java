package big_data.bit.ex05;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatEx {
	public static void main(String[] args) {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("E요일 yyyy년 MM월 dd일 'at' hh시 mm분 ss초 a z");
		System.out.println(sdf.format(d));
			
	}
}
