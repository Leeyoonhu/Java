package big_data.bit.exall2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P471Ex06 {
	//HashMap �� ���� �빮�ڷ� �ٲٱ�
	public static void main(String[] args) {
		HashMap<String, String> aniMap = new HashMap<String, String>();
		aniMap.put("ȣ����", "tiger");
		aniMap.put("ǥ��", "leopard");
		aniMap.put("����", "lion");
		
		System.out.printf("���� �� : %s\n", aniMap.entrySet());
		List<String> vList = new ArrayList<String>(aniMap.values());
		for(int i = 0; i < vList.size(); i++) {
			Collections.replaceAll(vList, vList.get(i), vList.get(i).toUpperCase());
		}
		for(String key : aniMap.keySet()) {
			if(key.equals("ȣ����")) {
				aniMap.put(key, vList.get(0));
			}
			if(key.equals("ǥ��")) {
				aniMap.put(key, vList.get(1));
			}
			if(key.equals("����")) {
				aniMap.put(key, vList.get(2));
			}
		}
		System.out.printf("���� �� : %s\n", aniMap.entrySet());
	}
}
