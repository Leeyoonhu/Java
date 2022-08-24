package Temp01;

import java.net.*;
import java.io.*;

public class ClientEx01 {
	public static void main(String[] args) {
		try {
			Socket socketOfClient = new Socket("127.0.0.1", 9998);
			
			OutputStream os = socketOfClient.getOutputStream();
			InputStream is = socketOfClient.getInputStream();
			
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(os));
//			PrintWriter pw2 = new PrintWriter(new OutputStreamWriter(System.out));
			
			String chat1 = null;
			String chat2 = null;
			
			while((chat1 = keyboard.readLine()) != null) {
				for(int i = 0; i < chat1.length(); i++) {
					pw.write(chat1);
				}
				pw.flush();
				
				chat2 = br.readLine();
				System.out.println("서버로 부터 받은 메세지 : " + chat2);
			}
		
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
