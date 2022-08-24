package big_data.bit.ex08;

import java.util.ArrayList;

public class ArrayListEx {
	public static void main(String[] args) {
		ArrayList<String> sList = new ArrayList<String>(); 
		// sList 가 문자열을 참조할 수 있는 공간 생성
		// 앞으로 추가될 래퍼런스들은 문자열을 참조
		// ArrayList는 크기가 가변(배열의 크기를 지정하지 않아도 사용가능하고, 마음대로 늘리거나 줄일 수 있음)
		// 들어가는 값들은 중복 가능하며, 순서대로 저장됨
		// ArrayList에 값을 저장하라면 .add()함수 사용해야하며, 총 크기는 저장한 값의 갯수임
		// ArrayList.size()는 저장된 데이터의 갯수만 나옴
		sList.add("Hello");
		sList.add("Hi");
		sList.add("Java");
		sList.add("사과");
		
		// 저장한 값을 꺼내려면 .get()함수 사용
		System.out.println(sList.get(0));
		System.out.println(sList.get(1));
		System.out.println(sList.get(2));
		System.out.println(sList.get(3));
		// 지정된 객체를 가지고 있는지 확인할때는 .contains()함수 사용
		System.out.println();
		System.out.println(sList.contains("Hello"));
		System.out.println(sList.contains("Python"));
		// 지정된 객체와 같은 객체가 있는 요소(배열번호)의 위치 반환할때는 .indexOf() 함수 사용
		System.out.println();
		System.out.println(sList.indexOf("Java"));
		// 비어있는지 확인할때는 .isEmpty() 함수 사용
		System.out.println();
		System.out.println(sList.isEmpty());
		// 지정한 인덱스 위치의 객체 값 제거할때는 .remove(인덱스번호) or .remove(배열안의 값) 함수 사용
		System.out.println();
		System.out.println(sList.get(0)); // 제거 전 0번째 배열에 있는 값
		System.out.println(sList.remove(0)); // 제거 된 0번째 배열에 있던 값
		System.out.println(sList.get(0)); // 제거 후 0번째 배열에 있는 값
		System.out.println(sList.remove("Hi"));// Hi값을 지닌 배열 삭제
		System.out.println(sList.get(0));
		// ArrayList의 모든 요소를 포함하는 배열 반환
		
	}
}
