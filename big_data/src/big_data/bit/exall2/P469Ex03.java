package big_data.bit.exall2;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class P469Ex03 {
	public static void main(String[] args) {
		Map<String, Integer> map = new Hashtable<String, Integer>();
		map.put("�迭��", 80);
		map.put("�ְ��", 90);
		map.put("����", 95);
		map.put("���ڹ�", 88);
		Scanner scan = new Scanner(System.in);
		System.out.print("�̸��� �Է��ϼ��� : ");
		System.out.println(map.get(scan.next()));
	}
}
