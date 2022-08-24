package big_data.bit.ex08;

import java.util.*;

public class HashSetEx {
	public static void main(String[] args) {
		
		HashSet<String> hSet = new HashSet<String>();
		hSet.add("one");
		hSet.add("two");
		hSet.add("three");
		hSet.add("four");
		hSet.add("two");
		// set은 index가 없어서 값 꺼내려면 순환자 iterator 사용
		// 중복된 값 저장x
		// 객체 저장 전 객체의 hashCode()를 메소드 호출하여 해시코드를 얻어내고, 이미 저장된 해시코드와 비교하여 중복인지 아닌지 판단
		System.out.println("=========String=========");
		Iterator<String> ir = hSet.iterator();
		while(ir.hasNext()) {
			System.out.print(ir.next() + " ");
		}
		System.out.println();
		System.out.println("=========Integer=========");
		Set<Integer> set1 = new HashSet<Integer>();
		set1.add(1);
		set1.add(3);
		set1.add(5);
		set1.add(7);
		Iterator<Integer> ir2 = set1.iterator();
		while(ir2.hasNext()) {
			System.out.print(ir2.next() + " ");
		}
		System.out.println();
		System.out.println("ArrayList 원소로 HashSet 만들기");
		ArrayList<String> aL = new ArrayList<String>();
		aL.add("코난");
		aL.add("장미");
		aL.add("미란");
		aL.add("코난");
		
		Set<String> set2 = new HashSet<String>(aL);
		set2.add("키드");
		Iterator<String> ir3 = set2.iterator();
		while(ir3.hasNext()) {
			System.out.print(ir3.next() + " ");
		}
		System.out.println();
		List<String> aL2 = new ArrayList<String>(set2);
		aL2.add("유명한");
		Iterator<String> ir4 = aL2.iterator();
		while(ir4.hasNext()) {
			System.out.print(ir4.next() + " ");
		}
	}
}
