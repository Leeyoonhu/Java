package big_data.bit.ex03;

public class ArrayEx02 {
	public static void main(String[] args) {
		int[] num = {1, 2, 3, 4, 5};
		int sum = 0;
		for(int i = 0; i < num.length; i++) {
			sum += num[i];
		}
		System.out.println(sum);
		sum = 0;
		for(int k : num) {
			sum += k;
		}
		System.out.println(sum);
		
		String[] names = new String[] {"사과", "배", "바나나", "딸기", "포도"};
		System.out.println("기존의 for문");
		for(int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
		System.out.println("for-each문(향상된 for문)");
		for(String s : names) {
			System.out.println(s);
		}
	}
}
