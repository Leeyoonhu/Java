package big_data.bit.exall2;

import java.util.Collections;
// 1. 매개변수가 숫자라면 큰 수 반환..
		// 1-1. 매개변수가 숫자라면...
		// 1-2. 숫자면서 정수이면.. 
		// 1-3. 숫자면서 실수이면..
		// 1-4. 두 값중 최대인 놈 반환
		// 2. 매개변수가 문자라면 긴 문자열 반환..
class Max<T> {
	T max;
	public T max(T t1, T t2) {
		if(t1 instanceof Number && t2 instanceof Number) { // t1과 t2가 숫자일때
			// t1이 정수일때
			if(t1 instanceof Integer) {
				Integer i1 = (Integer)t1;
				if(t2 instanceof Integer) {
					Integer i2 = (Integer)t2;
					if(i1 > i2) {
						return (T) i1;
					}
					else {
						return (T) i2;
					}
				}
				if(t2 instanceof Double) {
					Double d2 = (Double)t2;
					if(i1 > d2) {
						return (T) i1;
					}
					else {
						return (T) d2;
					}
				}
			}
			// t1이 실수일때
			if(t1 instanceof Double) {
				Double d1 = (Double)t1;
				if(t2 instanceof Integer) {
					Integer i2 = (Integer)t2;
					if(d1 > i2) {
						return (T) d1;
					}
					else {
						return (T) i2;
					}
				}
				if(t2 instanceof Double) {
					Double d2 = (Double)t2;
					if(d1 > d2) {
						return (T) d1;
					}
					else {
						return (T) d2;
					}
				}
			}
	
		}
		if(t1 instanceof String && t2 instanceof String) { // t1과 t2가 문자일때
			String str1 = (String)t1;
			String str2 = (String)t2;
			if(str1.length() > str2.length()) {
				return (T) str1;
			}
			else {
				return (T) str2;
			}
		}
		return this.max;
	}
}

public class P389Ex06 {
	public static void main(String[] args) {
		Max<Number> n = new Max();
		System.out.println(n.max(10.0, 8.0));
		System.out.println(n.max(5, 8.0));
		
		Max<String> s = new Max();
		System.out.println(s.max("Hello", "Hi"));
		System.out.println(s.max("Good", "morning"));
	}
}
