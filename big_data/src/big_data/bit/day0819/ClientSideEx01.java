package big_data.bit.day0819;

import java.net.*;
import java.io.*;

public class ClientSideEx01 {
	public static void main(String[] args) {
		try {
			Socket socketOfServer = new Socket("127.0.0.1", 9999); // 3. 서버와 소통하기 위해 IP주소, 포트번호로 연결
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socketOfServer.getOutputStream()));
			pw.println("Hi, Server"); // 서버에 연결되어있는 소켓에 출력
			pw.flush(); // 버퍼에 저장된 프린트문 출력
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
