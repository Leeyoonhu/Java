package big_data.bit.ex08;

import java.util.HashMap;
import java.util.Map;

public class MapEx04 {
	public static void main(String[] args) {
		Map<Integer, Book> m = new HashMap<Integer, Book>();
		// 맵에 키-밸류 저장후 값 반환 put(k, v)
		m.put(1, new Book(100, "어린왕자", "쌩떽쥐베리", 5));
		m.put(2, new Book(200, "행복한왕자", "오스카와일드", 10));
		m.put(3, new Book(300, "셜록홈즈", "코난도일", 8));
		for(Map.Entry<Integer, Book> entry : m.entrySet()) {
			Integer key = entry.getKey();
			Book book = entry.getValue();
			System.out.println(key + "의 세부 항목");
			System.out.println(book.toString());
			System.out.println("==================");
		}
		
	}
}
