package big_data.bit.ex1;

import java.util.Arrays;
import java.util.List;

public class Temp13 {
	public static void main(String[] args) {
		String[] animals1 = {"사슴", "호랑이", "바다표범", "곰"};
		
		List<String> animals2 = Arrays.asList(animals1); // Arrays 정적 메서드
		animals2.set(1, "앵무새");
		
		for(String s : animals2) {
			System.out.print(s + " ");
		}
		System.out.println();
		
		animals2.sort((x, y) -> x.length() - y.length());
		String[] animals3 = animals2.toArray(new String[0]);
		for(String s : animals3) {
			System.out.print(s + " ");
		}
		System.out.println();
		
		List<String> cars = List.of("그랜저", "소나타", "아반테", "제네시스"); // List.of 불변 리스트, null 값을 가질 수 없음
//		cars.set(1, "싼타페");	// 불변 리스트이므로 원소 내용 변경 x
		for(String s : cars) {
			System.out.print(s + " ");
		}
		System.out.println();
		cars.forEach(s -> System.out.print(s + " "));
		
		
	}
}
