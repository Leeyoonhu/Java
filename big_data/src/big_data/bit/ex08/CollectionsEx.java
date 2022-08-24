package big_data.bit.ex08;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CollectionsEx {
	public static void main(String[] args) {
		List<String> sList = new LinkedList<String>();
		sList.add("트랜스포머");
		sList.add("스타워즈");
		sList.add("매트릭스");
		sList.add(0, "터미네이터");
		sList.add(2, "아바타");
		
		for(String s : sList) {
			System.out.print(s + " ");
		}
		System.out.println();
		// 컬렉션 클래스들 정렬
		Collections.sort(sList);
		System.out.println("== 정렬 후 값 == ");
		for(String s : sList) {
			System.out.print(s + " ");
		}
		System.out.println();
		// 컬렉션 클래스들 리버스 정렬
		Collections.reverse(sList);
		System.out.println("== 역 정렬 후 값 ==");
		for(String s : sList) {
			System.out.print(s + " ");
		}
	}
	
	
}
