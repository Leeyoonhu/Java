package big_data.bit.day0819;

import java.net.*;
import java.io.*;

public class EchoClient {
	public static void main(String[] args) {
		try {
			// 클라이언트는 먼저 쓰고 읽음
			// 먼저 쓰려고 키보드를 만들었다
			// 
			Socket socketOfClient = new Socket("127.0.0.1", 9999);
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			// keyboard Scanner처럼 입력받겠다는 의미 
			OutputStream os = socketOfClient.getOutputStream();
			InputStream is = socketOfClient.getInputStream();
			// 
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(os));
			// 소켓에서 받은 내용 프린터 변수 pw에 쓰기
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			String line = null;
			 
			while((line = keyboard.readLine()) !=null) {
				// 키보드로 받은 행의 값이 null이 아니면
				
				pw.println(line); // 행의 값을 pw에 쓴다
				pw.flush(); // 저장된 버퍼에 있는 값 출력
				String echo = br.readLine();
				System.out.println("서버로부터 전달받은 문자열 " + echo);
				// echo 는 소켓에서 읽은 애를 저장
				if(line.equals("quit")) {
					// 키보드로 받은 행의 값이 quit 이면
					break;
				}
			}
		pw.close();	// 클라이언트 소켓에 쓰는거 닫고
		br.close();	// 클라이언트 소켓에 읽는거 닫고
		socketOfClient.close();	// 클라이언트 소켓 닫고
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
