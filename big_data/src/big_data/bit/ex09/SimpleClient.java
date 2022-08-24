package big_data.bit.ex09;

import java.io.*;
import java.net.*;


public class SimpleClient {

	public static void main(String[] args) {
		try
		// Socket 생성시 자동으로 클라이언트가 서버에 연결 요청을 함
		// Socket client = new Socket();
		// client.connect(new InetAddress("localhost", 5000));
			(Socket client = new Socket("localHost", 5000);
			OutputStream os = client.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);)
			{
			
			oos.writeObject("안녕, 단순 서버야");
			oos.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("예외 처리 입니다.");
		}
		
	}
}
