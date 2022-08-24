package big_data.bit.day0818;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileClassEx01 {
	public static void test01(String[] args) {
		// 파일 객체 생성
		File file = new File("c:/temp/test2.txt");
		
		// 파일인지 디렉토리(경로) 인지 구분
		file = new File("c:/windows/system.ini");
		String res;
		if(file.isFile()) {
			res = "파일";
		}
		else {
			res = "디렉토리";
		}
		System.out.println(file.getPath() + "은 " + res + "입니다.");
		
		// 디렉토리(경로)로 변경
		file = new File("c:/windows/");
		if(file.isFile()) {
			res = "파일";
		}
		else {
			res = "디렉토리";
		}
		System.out.println(file.getPath() + "은 " + res + "입니다.");
	}
	
	public static void test02(String[] args) {
		// file로 지정한 경로 혹은 파일 내의 파일들이 파일인지? 디렉토리인지?
		File file = new File("c:/windows");
		File [] fs = file.listFiles(); // file경로의 파일들을 배열 fs에 저장
		for(File f : fs) {
			if(f.isDirectory()) {
				System.out.println(f.toPath() + "는 디렉토리입니다.");
			}
			else {
				System.out.println(f.toPath() + "는 파일입니다.");
			}
		}
	}
	
	public static void main(String[] args) {
		// 실행 후 종료 시 ctrl + z
		BufferedReader br = null;	// buffer가 달린애들은 .readLine()이 있음 => 한줄씩 읽어오기 // 빈 경우 null값 반환
		// 보통 마지막 줄까지 확인하려면 .readLine() != null 조건을 사용
		PrintWriter pw = null;
		String line = null;	// 입력된 한 라인을 참조할 변수 선언
		
		try {
//			br = new BufferedReader (new InputStreamReader(System.in));	// 콘솔 입력
			br = new BufferedReader (new FileReader("c:/temp/han.txt")); // 파일 입력
			pw = new PrintWriter(new FileWriter("c:/temp/test4.txt"));
			while((line = br.readLine()) != null) {
				System.out.println(line); 	// 콘솔 출력
				pw.println(line);
			}
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
