package big_data.bit.ex1;

public class LabelEx {
	public static void main(String[] args) {
		Loops: 
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if (j == 5) {
					System.out.println(i + " * " + j + " = " + i * j);
					// break Loops; --> Loops: 까지 반복문 빠져나감
					// break; --> 반복문, switch
					// continue Loops; --> 조건에 맞을경우 첫 for문으로 가서 이후 실행
					// continue; --> 조건에 맞을경우에는 이후 실행안하고 증감식으로 감

				}
			}
		}
	}
}
