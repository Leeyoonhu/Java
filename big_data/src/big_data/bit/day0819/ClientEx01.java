package big_data.bit.day0819;

import java.io.*;
import java.net.*;


public class ClientEx01 {
	public static void main(String[] args) {
		try {
			Socket clientSocket = new Socket("127.0.0.1", 9998);
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			
			OutputStream os = clientSocket.getOutputStream();
			InputStream is = clientSocket.getInputStream();
			
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(os));
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			String line = null;
			while((line = keyboard.readLine()) != null) {
				if(line.equals("quit")) {
					break;
				}
				pw.println(line);
				pw.flush();
				String echo = br.readLine();
				
				System.out.println("서버로부터 받은 문자열 : " + echo);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
