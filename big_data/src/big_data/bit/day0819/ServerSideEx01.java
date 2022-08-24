package big_data.bit.day0819;

import java.net.*;
import java.io.*;

public class ServerSideEx01 {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9999); // 1. 서버를 만들고 대기
			System.out.println("접속을 기다립니다.");
			Socket socketOfServer = server.accept(); // 2. 클라이언트 서버의 요청을 서버가 수락
			BufferedReader br = new BufferedReader(new InputStreamReader(socketOfServer.getInputStream()));
			String line = br.readLine();
			System.out.println("받은 문자열 : " + line);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
