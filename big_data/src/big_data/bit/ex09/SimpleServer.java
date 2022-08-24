package big_data.bit.ex09;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(5000);
			Socket connection = server.accept();
			InputStream is = connection.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			// 서버에서 인풋
			// ois가 읽은 것을 문자열로 저장
			String str = (String)ois.readObject();
			System.out.println("입력 받은 문자열 : " + str);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("I/O 오류");
		}
		
	}
}
