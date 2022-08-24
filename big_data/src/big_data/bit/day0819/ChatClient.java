package big_data.bit.day0819;

import java.net.*;
import java.io.*;

public class ChatClient {
	public static void main(String[] args) {
		try {
			Socket socketOfClient = new Socket("127.0.0.1", 9999);
			
			OutputStream os = socketOfClient.getOutputStream();
			InputStream is = socketOfClient.getInputStream();
			
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(os));
			
			String OutputMessage = null;
			String inputMessage = null;
			while(true) {
				// 클라이언트 ==> 쓰고 읽고
				OutputMessage = keyboard.readLine();
				if(OutputMessage.equalsIgnoreCase("break")) {	// 클라이언트에서 입력한게 break면
					break;
				}
				pw.println("클라이언트>>" + OutputMessage);
				pw.flush();
				inputMessage = br.readLine(); // 서버가 보낸 메세지 저장
				System.out.println(inputMessage); // 서버가 보낸 메세지 출력
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
