package big_data.bit.exall2;

import java.util.Collections;
import java.util.HashSet;

public class P472Ex07 {
	public static void main(String[] args) {
		String[] s1 = {"a", "b", "a", "b", "c"};
		String[] s2 = {"c"};
		// �� �迭�� addAll �޼��带 �̿��� HashSet���� ����
		HashSet<String> set1 = new HashSet<String>();
		Collections.addAll(set1, s1);
		HashSet<String> set2 = new HashSet<String>();
		Collections.addAll(set2, s2);
		// �� HashSet ���
		System.out.print("set1 : " + set1.toString() + "\n");
		System.out.print("set2 : " + set2.toString() + "\n");
		// �� HashSet�� ������ ���
		System.out.print("set1�� set2�� ���� : " + set1.equals(set2) + "\n");
		// s1�� ���� HashSet�� s2�� ���� HashSet�� ���Ҹ� �����ϴ���
		System.out.print("set1�� set2�� ��� ���Ҹ� �����Ѵ� : " + set1.containsAll(set2) + "\n");
		// �����հ� ������ ���
		set1.addAll(set2);
		System.out.print("������ : " + set1 + "\n");
		if(set1.removeAll(set2) != false) {
			System.out.println("������ : " + set2 + "\n");
		}
	}
}
