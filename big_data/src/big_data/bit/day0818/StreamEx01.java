package big_data.bit.day0818;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class StreamEx01 {
	public static void test01(String[] args) throws IOException {
		int b, len = 0;
		int[] bArray = new int[100];
		
		System.out.println("--- 입력 스트림 ---");
		while((b = System.in.read()) != '\n') { // 엔터키를 입력할 때까지, System.in.read()가 읽어올 데이터가 없으면 -1
			System.out.printf("%c(%d)", (char)b, b);
			bArray[len++] = b; // 읽어온 데이터를 배열에 저장
		}
		
		System.out.println("\n\n --- 출력스트림 ---");
		for(int i = 0; i < len; i ++) {
			System.out.write(bArray[i]); // 배열안의 데이터들을 출력버퍼에 저장
		}
		System.out.flush();
	}
	
	public static void test02(String[] args) throws Exception {
		OutputStream os = new FileOutputStream("c:/temp/test1.txt");
		
		os.write((byte)10); 
		os.write((byte)20);
		os.write((byte)30);
		os.flush(); // 출력 버퍼에 있는 모든 바이트를 출력
		os.close();
	}
	
	public static void test03(String[] args) throws Exception {
		InputStream is = new FileInputStream("c:/temp/test1.txt");
		int data;
		while((data = is.read()) != -1) { // c:/temp/test1.txt 파일을 읽어온 int형 data, data에서 읽어올 데이터가 있다면 
			System.out.println(data);	// 출력
		}
		is.close();
	}
	
	public static void test04(String[] args) {
		// 버퍼 유무 비교 예제
		long start, end, duration;
		String org = "C:\\Program Files (x86)\\Internet Explorer\\iexplore.exe";
		String dst = "c:/temp/iexplore1.exe";
		start = System.nanoTime();
		BufferedInputStream bis = null; 
		BufferedOutputStream bos = null;
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			bis = new BufferedInputStream(new FileInputStream(org));
			bos = new BufferedOutputStream(new FileOutputStream(dst));
			while(bis.available() > 0) {
				int b = bis.read();
				bos.write(b);
			}
			bos.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		end = System.nanoTime();
		duration = end - start;
		System.out.println("버퍼를 사용한 경우 : " + duration);
		
		start = System.nanoTime();
		try {
			fis = new FileInputStream(org);
			fos = new FileOutputStream(dst);
			while(fis.available() > 0) {
				int b = fis.read();
				fos.write(b);
			}
			fos.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		end = System.nanoTime();
		duration = end - start;
		System.out.println("버퍼를 사용하지 않은 경우 : " + duration);
	}
	
	public static void test06(String[] args) {
		// 키보드에서 입력받은 내용을 파일에 저장
		InputStreamReader in = new InputStreamReader(System.in);	// 키보드 입력을 위한 장치 준비
		FileWriter fout = null;
		int c;
		
		try {
			fout = new FileWriter("c:/temp/test1.txt");	// 해당 경로의 파일을 만들어 저장하기 위한 준비
			while((c = in.read()) != -1) {
				fout.write(c); // 파일에 쓰기 -> 파일로 저장
			}
			in.close();
			fout.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("입출력 오류");
		}
	}
	
	public static void main(String[] args) {
		//파일에서 읽어서 다른파일에 덧씌우기 (복사)
		InputStreamReader is = null;
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("c:/temp/han1.txt");
			is = new InputStreamReader(fis, "UTF-8");	
			// ANSI의 인코딩방식은 MS949
			// 인코딩, 디코딩 방식에 유의
			int c;
			System.out.println("인코딩 문자 집합은 " + is.getEncoding());
			while ((c = is.read()) != -1) {
				System.out.print((char)c);
			}
			is.close();
			fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("입출력 오류");
		}
	}
}
