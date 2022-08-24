package big_data.bit.day0819;

import java.io.*;
import java.net.*;

public class ServerEx02 {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9999);
			Socket socketOfServer = server.accept();
			System.out.println("접속 대기중");
			
			InetAddress ia = socketOfServer.getInetAddress();
			System.out.println("접속한 IP : " + ia.getHostAddress());
			
			InputStream is = socketOfServer.getInputStream();
			OutputStream os = socketOfServer.getOutputStream();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(os));
			
			String line = null;
			while((line = br.readLine()) != null) {
				System.out.println("클라이언트에서 보낸 메세지 : " + line);
				pw.println(line);
				pw.flush();
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
