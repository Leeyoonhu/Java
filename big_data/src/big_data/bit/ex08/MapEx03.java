package big_data.bit.ex08;

import java.util.HashMap;
import java.util.Map;

public class MapEx03 {
	public static void main(String[] args) {
		// 문자열 안에 포함된 단어의 빈도 계산
		String[] sample = {"to", "be", "or", "not", "to", "be", "is", "a", "problem"};
		// 배열 안의 단어를 key, 중복 횟수를 value로 해보자
		// Key는 단어를 받을테니 String, Value는 횟수니까 Integer
		Map<String, Integer> m = new HashMap<String, Integer>();
		for(String s : sample) {
			Integer num = m.get(s); // 단어의 출현 빈도수를 저장하는 변수 num, 맵의 키값을 s로 저장
			m.put(s, (num == null)? 1 : num + 1); // 맵의 Value값이 없을 경우 1을 넣고, 해당 key값의 value가 null이 아닐 경우 num + 1; 
		}
		System.out.println(m.size() + " 단어가 있습니다.");
		System.out.println(m.containsKey("to"));
		System.out.println(m.isEmpty());
		System.out.println(m);
		
		for(String key : m.keySet()) {
			System.out.printf("%s : %d회 \n", key, m.get(key));
		}
	}
}
