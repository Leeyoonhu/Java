package big_data.bit.exall2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P471Ex05 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int score = 0;
		ArrayList<Integer> sList = new ArrayList<Integer>(); 
		// �Էµ� ������ �����϶����� ���� ���� �Է�
		for(int i = 0; ; i++) {
			System.out.print("������ �Է��ϼ��� : ");
			score = scan.nextInt();
			if(score < 0) {
				break;
			}
			sList.add(score);
		}
		System.out.println("��ü �л��� " + sList.size() + "���̴�.");
		System.out.print("�л����� ���� : ");
		int max = Collections.max(sList);
		// �����߿��� �ְ��� �̱�
		for(int i = 0; i < sList.size(); i++) {
			System.out.print(sList.get(i) + " ");
		}
		System.out.println();
		String grade = null;
		// ���� �� - �ְ������� �������� ���ǿ� ���� grade ����
		for(int i = 0; i < sList.size(); i++) {
			if(sList.get(i) - max >= -10) {
				grade = "A";
				System.out.printf("%d�� �л��� ������ %d���̸�, ����� %s�̴�.\n", i, sList.get(i), grade);
			}
			else if(sList.get(i) - max >= -20) {
				grade = "B";
				System.out.printf("%d�� �л��� ������ %d���̸�, ����� %s�̴�.\n", i, sList.get(i), grade);
			}
			else {
				grade = "C";
				System.out.printf("%d�� �л��� ������ %d���̸�, ����� %s�̴�.\n", i, sList.get(i), grade);
			}
		}
	}
}
