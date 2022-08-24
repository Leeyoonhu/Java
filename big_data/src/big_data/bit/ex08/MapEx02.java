package big_data.bit.ex08;

import java.util.HashMap;
import java.util.Map;

public class MapEx02 {
	public static void main(String[] args) {
		Map<Integer, String> hMap = new HashMap<Integer, String>();
		hMap.put(1, "바나나");
		hMap.put(2, "사과");
		hMap.put(3, "오렌지");
		hMap.put(1, "포도"); // 동일 key값 중복! 마지막에 넣은 key값에 저장된 value로 저장됨
		
		System.out.println("===============삭제전================");
		for(Map.Entry<Integer, String> map : hMap.entrySet()) {
			System.out.println(map.getKey() + " : " + map.getValue());
		}
		hMap.remove(1);
		// 키값 1에 저장된 value 값 삭제
		System.out.println("===============삭제후================");
		for(Map.Entry<Integer, String> map : hMap.entrySet()) {
			System.out.println(map.getKey() + " : " + map.getValue());
		}
	}
	
}
