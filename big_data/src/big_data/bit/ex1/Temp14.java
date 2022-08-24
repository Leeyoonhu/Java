package big_data.bit.ex1;

import java.util.ArrayList;
import java.util.List;

public class Temp14 {
	public static void main(String[] args) {
		List<String> list = List.of("그랜저", "소나타", "아반테", "제네시스", "소울");
		System.out.println(list.indexOf("소나타"));
		System.out.println(list.indexOf("제네시스"));
		System.out.println(list.contains("소울"));
		
		list.forEach(s -> System.out.print(s + " "));
		System.out.println();
		
		List<String> list2 = new ArrayList<String>(list);
		list2.add("싼타페");
		List<String> list3 = new ArrayList<String>(list);
		list3.remove("제네시스");
		System.out.println(list2.contains(list3));
		
		list2.removeIf(c -> c.startsWith("소"));
		list2.replaceAll(s -> "뉴" + s);
		list2.forEach(s -> System.out.print(s + " "));
		System.out.println();
		
		list2.clear();
		System.out.println(list2.isEmpty());
	}
}
