package big_data.bit.ex08;

import java.io.IOException;

public class IOEx {
	public static void main(String[] args) throws IOException {
		int b, len = 0;
		int bArray[] = new int[100];
		
		System.out.println("-- 입력 스트림 --");
		// 소스 : 키보드 (표준 입력 장치 --> System.in, console)
		while((b = System.in.read()) != '\n') { // 엔터키를 입력할 때 까지 읽어서 b에 저장
			System.out.printf("%c(%d)", (char)b, b);
			bArray[len++] = b;
		}
		
		System.out.println("-- 출력 스트림 --");
		for(int i = 0; i < len; i++) {
			System.out.write(bArray[i]);
			// 1바이트씩 출력
			// 버퍼에 저장
			// 목적지 : 모니터 (표준 출력 장치 --> System.out, console)
		}
		// 1바이트씩 읽는데 
		System.out.flush();
		// 버퍼에 저장된 값들 한번에 출력
		// System.out.close();
		
	}
}
