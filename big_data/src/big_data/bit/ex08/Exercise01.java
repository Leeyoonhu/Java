package big_data.bit.ex08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Map<String, String> hMap = new HashMap<String, String>();
		hMap.put("love", "사랑");
		hMap.put("apple", "사과");
		hMap.put("baby", "아기");
		
		while(true) {
			System.out.print("찾고 싶은 단어는? ");
			System.out.println(hMap.get(scan.next()));
		}
		
		
//		for(Map.Entry<String, String> map : hMap.entrySet()) {
//			System.out.print("찾고 싶은 단어는?");
//			String check = scan.next();
//			hMap.get(check).equals(check){
//				
//			}
			// check가 map안에있는 key값과 같을때 map안에있는 key값 전체
//		}
		
	}
}
