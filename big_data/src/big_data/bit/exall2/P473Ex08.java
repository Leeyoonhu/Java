package big_data.bit.exall2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P473Ex08 {
	public static void main(String[] args) {
		String[] s = {"������", "�����", "������"};
		// 1�� ��ĭ
		List<String> list = new ArrayList<String>();
		list.add("����");
		list.add("����");
		//
		System.out.println(list);
		List<String> al1 = new ArrayList<String>(list);	
		System.out.println("nCopies : " + al1);
		// 2�� ��ĭ
		Collections.replaceAll(al1, "����", "��");
		System.out.println("'��'�� ä�� �� : " + al1);
		// 3�� ��ĭ
		Collections.addAll(al1, s);
		System.out.println("����Ʈ�� ��� �߰��� �� : " + al1);
		// 4�� ��ĭ
		Collections.shuffle(al1);
		System.out.println("����Ʈ�� ���� �� : " + al1);
		// 5�� ��ĭ
		Collections.reverse(al1);
		System.out.println("����Ʈ�� �������� ������ �� : " + al1);
		// 6�� ��ĭ
		System.out.println("����Ʈ���� �ּ� : " + Collections.min(al1));
		// 7�� ��ĭ
		System.out.println("����Ʈ���� �ִ� : " + Collections.max(al1));
		// 8�� ��ĭ
		System.out.println("����Ʈ���� '��'�� �� : " + Collections.binarySearch(al1, "��"));
	}
}
