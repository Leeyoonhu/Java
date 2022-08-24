package big_data.bit.day0819;

import java.io.*;
import java.net.*;

public class ChatServer {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9999);
			System.out.println("접속을 기다립니다.");
			Socket socketOfServer = server.accept();
			
			//접속하면 확인문구
			InetAddress ia = socketOfServer.getInetAddress();
			System.out.println(ia.getHostAddress() + "로 부터 접속하였습니다.");
			
			InputStream is = socketOfServer.getInputStream();
			OutputStream os = socketOfServer.getOutputStream();
		
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(os));
			
			String inputMessage = null;
			String outputMessage = null;
			while(true) {
				// 서버 ==>> 읽고 쓰고
				inputMessage = br.readLine(); // 클라이언트가 보낸 메세지 저장
				if(inputMessage.equalsIgnoreCase("break")) {	// 클라이언트에게서 받은 문장이 break면 break;
					break;
				}
				System.out.println(inputMessage);	// 클라이언트에게서 받은 메세지 출력
				outputMessage = keyboard.readLine();	// 서버가 채팅 칠 내역 저장
				pw.println("서버>>" + outputMessage);
				pw.flush();
			}
			pw.close();
			br.close();
			keyboard.close();
			socketOfServer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
