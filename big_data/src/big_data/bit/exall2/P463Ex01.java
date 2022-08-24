package big_data.bit.exall2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class P463Ex01 {
	public static void main(String[] args) {
		// 1. ArrayList 생성
		List<String> capitals = new ArrayList<String>();
		// 2. capitals 에 5개이상의 서울과 같은 수도이름 추가 후 for-each문 사용
		capitals.add("서울");
		capitals.add("워싱턴");
		capitals.add("베이징");
		capitals.add("마드리드");
		capitals.add("파리");
		
		for(String s : capitals) {
			System.out.print(s + " ");
		}
		System.out.println();
		// 3. cpaitals 객체에 하나의 수도이름 추가 후 반복자로 출력
		capitals.add("런던");
		Iterator ir = capitals.iterator();
		while(ir.hasNext()) {
			System.out.print(ir.next() + " ");
		}
		System.out.println();
		// 4. 3개이상 문자열로 구성된 원소 제거 후 for-each문으로 출력
		// 5. 테스트 프로그램 실행
		for(int i = 0; i < capitals.size(); i++) {
			if(capitals.get(i).length() >= 3) {
				capitals.remove(i);
				i--;
			}
		}
		for(String s : capitals) {
			System.out.print(s + " ");
		}
	}
}
