package big_data.bit.ex08;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListEx {
	public static void main(String[] args) {
		List<String> aL = new ArrayList<String>();
		List<String> lL = new LinkedList<String>();
		DecimalFormat df = new DecimalFormat("#,###.0");
		long startTime, endTime;
		startTime = System.nanoTime();
		for(int i = 0; i < 10000; i++) {
			aL.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.printf("ArrayList에 데이터 저장하는데 걸린 시간 : %s", df.format(endTime - startTime));
		System.out.println();
		startTime = System.nanoTime();
		for(int i = 0; i < 10000; i++) {
			lL.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.printf("LinkedList에 데이터 저장하는데 걸린 시간 : %s", df.format(endTime - startTime));
	}
}
