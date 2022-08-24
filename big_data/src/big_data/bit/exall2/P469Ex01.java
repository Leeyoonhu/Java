package big_data.bit.exall2;

import java.util.ArrayList;
import java.util.List;

public class P469Ex01 {
	// ArrayList를 이용해 갈매기, 나비, 다람쥐, 라마를 원소로 입력 후 
	// 각 원소에서 크기가 2인 단어만 출력
	public static void main(String[] args) {
		List<String> nameList = new ArrayList<String>();
		nameList.add("갈매기");
		nameList.add("나비");
		nameList.add("다람쥐");
		nameList.add("라마");
		for(int i = 0; i < nameList.size(); i++) {
			if(nameList.get(i).length() == 2) {
				System.out.println(nameList.get(i).toString());
			}
		}
	}
}
