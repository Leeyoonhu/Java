package big_data.bit.ex08;

import java.util.HashMap;
import java.util.Map;

public class MapEx01 {
	public static void main(String[] args) {
		// key - value 구조(값을 검색할때는 반드시 key값 사용)
		// key는 중복x, value 는 중복가능
		// key값을 중복 저장할 경우, 마지막에 저장된 key값만 남게됨
		// key값의 순서가 의미있을경우 treeMap, 없으면 hashMap
		
		// map 값을 사용하는 3가지 방법 : 1. k-v 를 저장
		// k만 추려낸 Set을 만든뒤, 향상된 for문을 사용하여 for(Object 변수 : ~.keySet()) 형식으로 사용 (k값만 출력)
		// k- v추려낸 맵.entrySet()만든 뒤, Map.Entry<K, V> 변수선언해서 둘을 향상 for문에서 돌림 ==> for(Map.Entry<K, V> var : 맵.entrySet())
		// 이후 값은 getKey(), getValue() 함수 사용해서 가져옴
		// 요소 삽입 : .put(key, value)메소드 함수 / 검색 : .get(key)메소드
		Map<String, String> hMap = new HashMap<String, String>();
		hMap.put("apple", "사과");
		hMap.put("strawberry", "딸기");
		hMap.put("grape", "포도");
		
		System.out.println("key를 가져와서 value값과 출력하는 법");
		for(Object s : hMap.keySet()) {
			System.out.println(s + " : " + hMap.get(s));
								// key		value
		}
		System.out.println();
		// hMap에 K-V 한줄을 entry에 저장
		System.out.println("k-v쌍을 저장해서 key값과 value값을 출력하는 법");
		for(Map.Entry<String, String> entry : hMap.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		System.out.println();
		System.out.println("해당 키값을 포함하고있는지 확인");
		System.out.println(hMap.containsKey("apple"));
		
		// hMap에 저장된 값 제거(.remove(key)함수 사용)
		System.out.println(hMap.remove("apple"));
		System.out.println();
		System.out.println("제거 된 후 저장된 값");
		for(Object s : hMap.keySet()) {
			System.out.println(s + " : " + hMap.get(s));
								// key		value
		}
	}
}
