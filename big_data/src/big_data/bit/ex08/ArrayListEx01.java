package big_data.bit.ex08;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListEx01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int count = 0;
		ArrayList<String> nameList = new ArrayList<String>();
		for(int i = 0; i < 4; i++) {
			System.out.print("이름을 입력하세요>>");
			nameList.add(scan.next());
		}
		count = nameList.get(0).length();
		for(int i = 0; i < nameList.size(); i++) {
			System.out.print(nameList.get(i) + " ");
			if(count < nameList.get(i).length()) {
				count = nameList.get(i).length();
			}
		}
		System.out.println();
		for(int i = 0; i < nameList.size(); i++) {
			if(nameList.get(i).length() == count) {
				System.out.println("가장 긴 이름은 : " + nameList.get(i));
			}
		}
	}
}
