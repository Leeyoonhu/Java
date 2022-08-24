package big_data.bit.ex03;

public class IntArrayEx {
	public static void main(String[] args) {
		int [] scores = {11, 22, 33, 44, 55};
		// scores 배열의 모든 값의 합을 구하라
		int sum = 0;
		for(int i = 0; i < scores.length; i++) {
			sum += scores[i];
		}
		System.out.println("scores 배열 값의 합은 : "+sum);
	}
}
