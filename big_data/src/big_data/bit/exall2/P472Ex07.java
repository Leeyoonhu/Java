package big_data.bit.exall2;

import java.util.Collections;
import java.util.HashSet;

public class P472Ex07 {
	public static void main(String[] args) {
		String[] s1 = {"a", "b", "a", "b", "c"};
		String[] s2 = {"c"};
		// 두 배열을 addAll 메서드를 이용해 HashSet으로 생성
		HashSet<String> set1 = new HashSet<String>();
		Collections.addAll(set1, s1);
		HashSet<String> set2 = new HashSet<String>();
		Collections.addAll(set2, s2);
		// 두 HashSet 출력
		System.out.print("set1 : " + set1.toString() + "\n");
		System.out.print("set2 : " + set2.toString() + "\n");
		// 두 HashSet이 같은지 출력
		System.out.print("set1과 set2는 같다 : " + set1.equals(set2) + "\n");
		// s1에 의한 HashSet이 s2에 의한 HashSet의 원소를 포함하는지
		System.out.print("set1은 set2의 모든 원소를 포함한다 : " + set1.containsAll(set2) + "\n");
		// 합집합과 교집합 출력
		set1.addAll(set2);
		System.out.print("합집합 : " + set1 + "\n");
		if(set1.removeAll(set2) != false) {
			System.out.println("교집합 : " + set2 + "\n");
		}
	}
}
