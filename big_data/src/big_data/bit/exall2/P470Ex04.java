package big_data.bit.exall2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class P470Ex04 {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.addAll(Arrays.asList("������", "����", "����", "�����", "����", "����"));
		System.out.println("hashSet" + set);
		// ���ĵ� TreeSet
		TreeSet<String> set2 = new TreeSet<String>(set);
		System.out.println("TreeSet" + set2);
		// ù��° ���� .first()����
		System.out.println("ù ��° ���� : " + set2.first());
		// ������ ���� .last()����
		System.out.println("������ ���� : " + set2.last());
		// ~�տ� �ִ� �� �����ö� .lower()����
		System.out.println("���� �տ� �ִ� ���� : " + set2.lower("����"));
	}
}
