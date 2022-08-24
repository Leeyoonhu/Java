package big_data.bit.day0819;

import java.io.*;
import java.net.*;

class EchoThread extends Thread {
	private Socket socketOfServer;

	public EchoThread(Socket socketOfServer) {
		this.socketOfServer = socketOfServer;
	}

	@Override
	public void run() { // 쓰레드가 할 일 작성
		// TODO Auto-generated method stub
		try {
			InetAddress inetAddr = socketOfServer.getInetAddress();
			
			System.out.println(inetAddr.getHostAddress() + "로 부터 접속하였습니다.");
			
			OutputStream os = socketOfServer.getOutputStream();
			InputStream is = socketOfServer.getInputStream();
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(os));
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			String line = null;
			while((line = br.readLine()) !=null) {
				System.out.println("클라이언트로부터 전송 받은 문자열 : " + line);
				pw.println(line);
				pw.flush();
			}
			pw.close();
			br.close();	
			socketOfServer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


public class ThreadServer {
	// 서버는 꺼지면 안되기때문에 무한루프에 넣음
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9999); // 서버 소켓 생성 후 대기
			System.out.println("접속을 기다립니다.");	
			while(true) {
				Socket socketOfServer = server.accept(); // 서버의 승인받은 socketOfServer
				EchoThread echoThread = new EchoThread(socketOfServer);
				echoThread.start() ;//==> 반드시 run()안에 작업들을 실행하게 하는 메서드 
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
