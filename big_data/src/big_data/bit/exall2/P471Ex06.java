package big_data.bit.exall2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P471Ex06 {
	//HashMap 의 값들 대문자로 바꾸기
	public static void main(String[] args) {
		HashMap<String, String> aniMap = new HashMap<String, String>();
		aniMap.put("호랑이", "tiger");
		aniMap.put("표범", "leopard");
		aniMap.put("사자", "lion");
		
		System.out.printf("변경 전 : %s\n", aniMap.entrySet());
		List<String> vList = new ArrayList<String>(aniMap.values());
		for(int i = 0; i < vList.size(); i++) {
			Collections.replaceAll(vList, vList.get(i), vList.get(i).toUpperCase());
		}
		for(String key : aniMap.keySet()) {
			if(key.equals("호랑이")) {
				aniMap.put(key, vList.get(0));
			}
			if(key.equals("표범")) {
				aniMap.put(key, vList.get(1));
			}
			if(key.equals("사자")) {
				aniMap.put(key, vList.get(2));
			}
		}
		System.out.printf("변경 후 : %s\n", aniMap.entrySet());
	}
}
