package big_data.bit.ex1;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Temp11 {
	public static void main(String[] args) {
		Collection<String> list = Arrays.asList("다람쥐", "개구리", "나비");
		// Collection 에서 Iterator 객체를 가져와 List 컬렉션의 모든 요소 출력
		Iterator<String> ir = list.iterator();
		while(ir.hasNext()) {
			System.out.print(ir.next() + "-");
		}
		System.out.println();
		// Stringtokenizer 처럼 값이 있으면 순차적으로 꺼냄
		ir = list.iterator();
		while(ir.hasNext()) {
			System.out.print(ir.next() + "+");
		}
		System.out.println();
		

	}
}
