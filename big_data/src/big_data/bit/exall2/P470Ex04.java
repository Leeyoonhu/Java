package big_data.bit.exall2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class P470Ex04 {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.addAll(Arrays.asList("독수리", "나비", "염소", "고양이", "개미", "여우"));
		System.out.println("hashSet" + set);
		// 정렬된 TreeSet
		TreeSet<String> set2 = new TreeSet<String>(set);
		System.out.println("TreeSet" + set2);
		// 첫번째 동물 .first()쓸것
		System.out.println("첫 번째 동물 : " + set2.first());
		// 마지막 동물 .last()쓸것
		System.out.println("마지막 동물 : " + set2.last());
		// ~앞에 있는 셋 가져올때 .lower()쓸것
		System.out.println("나비 앞에 있는 동물 : " + set2.lower("나비"));
	}
}
