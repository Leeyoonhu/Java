package big_data.bit.day0819;

import java.net.*;
import java.io.*;

public class EchoServer {
	public static void main(String[] args) {
		try {
			// 서버는 먼저 읽고 씀
			// 키보드로 입력하는 것은 클라이언트만 가능, 따라서 먼저 쓸수가없음
			ServerSocket server = new ServerSocket(9999); // 서버 소켓 생성 후 대기
			System.out.println("접속을 기다립니다.");
			Socket socketOfServer = server.accept(); // 서버의 승인받은 socketOfServer
			
			InetAddress inetAddr = socketOfServer.getInetAddress();
			
			System.out.println(inetAddr.getHostAddress() + "로 부터 접속하였습니다.");
			
			OutputStream os = socketOfServer.getOutputStream(); // 서버소켓으로부터 출력
			InputStream is = socketOfServer.getInputStream(); // 서버소켓으로부터 입력
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(os));	// pw는 서버 소켓으로 받은 출력파일(os)을 쓰고
			BufferedReader br = new BufferedReader(new InputStreamReader(is)); // br은 서버 소켓으로 받은 입력파일(is)을 쓰고
			
			String line = null;
			while((line = br.readLine()) !=null) { // 클라이언트 소켓에게서 받은 서버소켓의 행이 없을때까지
				System.out.println("클라이언트로부터 전송 받은 문자열 : " + line);
				pw.println(line);	// 콘솔에 출력
				pw.flush();	// 소켓에 출력
			}
			pw.close(); // 
			br.close();	// 
			socketOfServer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
