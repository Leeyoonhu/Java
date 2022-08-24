package big_data.bit.ex1;

import static big_data.bit.ex1.Exercise01.scan;

public class CompareLogicEx1 {
	public static void main(String[] args) {
		// 놀이동산 범퍼카는 신장 125cm 이상 어린이만 탑승가능
		int count = 0;
		while (count < 2) {
			System.out.print("어린이의 신장(cm)을 입력하세요 : ");
			int height = scan.nextInt();
			System.out.println(height >= 125);
			count++;
		}
	}
}
