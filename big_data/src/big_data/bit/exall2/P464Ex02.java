package big_data.bit.exall2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class P464Ex02 {
	// HashMap클래스로 영단어 키, 한단어 값 객체 생성
	public static void main(String[] args) {
		Map<String, String> dic = new HashMap<String, String>();
		// 5개이상의 영단어-한단어 등록
		dic.put("head", "대가빠리");
		dic.put("teacher", "쌤");
		dic.put("cat", "꼬네이");
		dic.put("aunt", "아지매");
		dic.put("noodle", "국시");
		dic.put("child", "얼라");
		//반복자를 사용해 키 값 출력, for-each문 사용할 것	
		for(String key : dic.keySet()) {
			System.out.printf("%s=%s ", key, dic.get(key));
		}
	}
}
