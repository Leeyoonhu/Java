package big_data.bit.exall2;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class P469Ex03 {
	public static void main(String[] args) {
		Map<String, Integer> map = new Hashtable<String, Integer>();
		map.put("김열공", 80);
		map.put("최고봉", 90);
		map.put("우등생", 95);
		map.put("나자바", 88);
		Scanner scan = new Scanner(System.in);
		System.out.print("이름을 입력하세요 : ");
		System.out.println(map.get(scan.next()));
	}
}
