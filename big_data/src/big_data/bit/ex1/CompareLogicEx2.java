package big_data.bit.ex1;

import static big_data.bit.ex1.Exercise01.scan;

public class CompareLogicEx2 {
	static int count = 1;
	public static void main(String[] args) {
		// 놀이동산 범퍼카 사용 기준 신장 125cm 이상이고 165cm 미만인 어린이만 탑승 가능
		while (count < 3) {
			System.out.printf("* %d회차 *\n", count);
			System.out.print("어린이의 신장(cm)을 입력하세요 : ");
			int height = scan.nextInt();
			System.out.println(height >= 125 && height < 165);
			if (count == 2) {
				System.out.println("입력 횟수가 모두 소진되었습니다.");
			}
			System.out.println();
			count++;
		}
	}
}
