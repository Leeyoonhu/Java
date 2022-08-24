package big_data.bit.ex1;

public class CompareLogicEx {
	public static void main(String[] args) {
		// 비교 & 논리 연산자
		System.out.println(3 < 5);// true
		System.out.println(3 > 5);// false
		System.out.println(1 <= 0);// false
		System.out.println(10 >= 10);// true
		System.out.println(1 == 3);// false
		System.out.println(1 != 3);// true

		// 논리합 &&, ~이고
		System.out.println((3 < 5) && (1 == 1));// t && t => t
		System.out.println((3 < 5) && (1 == 2));// t && f => f
		System.out.println((3 > 5) && (1 == 1));// f && t => f
		System.out.println((3 > 5) && (1 == 2));// f && f => f
		
		// 논리곱 ||, ~이거나
		
		// not 연산자 !, !=
	}
}
