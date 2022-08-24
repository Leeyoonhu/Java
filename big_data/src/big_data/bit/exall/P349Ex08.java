package big_data.bit.exall;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P349Ex08 {
	public static void main(String[] args) {
		// 주어진 영어 속담을 단어로 분리해 배열에 저장
		// 단어 갯수 출력
		// 정렬 후 모든 단어 출력하는 프로그램
		// 배열 크기는 토큰의 갯수
		
		String list = "Empty vessels make the most sound.";
		int count = 0;
		StringTokenizer st = new StringTokenizer(list, " ");
		String[] strArray = new String[st.countTokens()];
		System.out.print("입력 : " + list);
		while(st.hasMoreTokens()) {
			strArray[count++] = st.nextToken();
		}
	
		System.out.println();
		System.out.println("단어 개수 : " + strArray.length);
		
		System.out.print("정렬된 토큰 : ");
		for(int i = 0; i < strArray.length; i++) {
			try {
				Arrays.sort(strArray);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				continue;
			}
			System.out.print(strArray[i] + ", ");
		}
	}
}
