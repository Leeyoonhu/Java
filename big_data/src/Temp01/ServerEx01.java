package Temp01;

import java.net.*;
import java.io.*;

public class ServerEx01 {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9998);
			System.out.println("접속 대기중 입니다.");
			Socket socketOfServer = server.accept();
			InetAddress ia = socketOfServer.getInetAddress();
			System.out.println("접속 IP : " + ia.getHostAddress());
			
			InputStream is = socketOfServer.getInputStream();
			OutputStream os = socketOfServer.getOutputStream();
			
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(os));
			
			String chat1 = null; String chat2 = null;
			while((chat1 = br.readLine()) != null) {
				System.out.println("클라이언트로부터 받은 메세지 : " + chat1);
				
				chat2 = keyboard.readLine();
				for(int i = 0; i < chat1.length(); i++) {
					pw.write(chat2);
				}
				pw.flush();
			}
			pw.close();
			br.close();
			keyboard.close();
			socketOfServer.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
