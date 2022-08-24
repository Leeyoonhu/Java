package big_data.bit.exall2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P473Ex08 {
	public static void main(String[] args) {
		String[] s = {"독수리", "고양이", "강아지"};
		// 1번 빈칸
		List<String> list = new ArrayList<String>();
		list.add("개미");
		list.add("개미");
		//
		System.out.println(list);
		List<String> al1 = new ArrayList<String>(list);	
		System.out.println("nCopies : " + al1);
		// 2번 빈칸
		Collections.replaceAll(al1, "개미", "벌");
		System.out.println("'벌'을 채운 후 : " + al1);
		// 3번 빈칸
		Collections.addAll(al1, s);
		System.out.println("리스트를 모두 추가한 후 : " + al1);
		// 4번 빈칸
		Collections.shuffle(al1);
		System.out.println("리스트를 섞은 후 : " + al1);
		// 5번 빈칸
		Collections.reverse(al1);
		System.out.println("리스트를 역순으로 정렬한 후 : " + al1);
		// 6번 빈칸
		System.out.println("리스트에서 최소 : " + Collections.min(al1));
		// 7번 빈칸
		System.out.println("리스트에서 최대 : " + Collections.max(al1));
		// 8번 빈칸
		System.out.println("리스트에서 '벌'의 빈도 : " + Collections.binarySearch(al1, "벌"));
	}
}
