package big_data.bit.day0818;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.net.ssl.SSLContext;

public class FileReaderEx02 {
	// 파일에서 사용된 단어의 사용 빈도수를 알려주는 프로그램
	// 무한 반복 프로그램이며 강제종료외에 종료기능x
	// 단어의 기준은 [.,'"]로 구분되는 토큰
	// 대소문자 구분x
	// 단, 복수는 다른단어
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		List<String> strList = new ArrayList<String>();
		String line = null;
		String word = null;
		int count = 0;
		StringTokenizer st = null;
		BufferedReader br = new BufferedReader(new FileReader("c:/temp/dorian.txt"));
		// 단어로..
		// 열을 구분자로 쪼개
		// 리스트에 넣고 겟한게 대소구분없이 같은지..	
		while((line = br.readLine()) != null) {
			st = new StringTokenizer(line, "[.,'\"] ");
			while(st.hasMoreTokens()) {
				strList.add(st.nextToken());
			}
		}
		
		while(true) {
			System.out.print("찾고 싶은 단어는 무엇 입니까? ");
			word = scan.next();
			for(String s : strList) {
				if(s.equalsIgnoreCase(word)) {
					count++;
				}
			}
			if(count > 0) {
				System.out.printf("%d번 사용됨\n", count);
				count = 0;
			}
			else {
				System.out.println("한번도 사용한적 없음");
			}
		}
	}
}
