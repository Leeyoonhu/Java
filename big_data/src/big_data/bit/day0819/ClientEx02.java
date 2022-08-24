package big_data.bit.day0819;

import java.io.*;
import java.net.*;

public class ClientEx02 {
	public static void main(String[] args) {
		try {
			Socket socketOfClient = new Socket("127.0.0.1", 9999);
			
			OutputStream os = socketOfClient.getOutputStream();
			InputStream is = socketOfClient.getInputStream();
			
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(os));
			
			String line = null;
			String line2 = null;
			while((line = keyboard.readLine()) != null) {
				pw.println(line);
				pw.flush();
				line2 = br.readLine();
				System.out.println("서버에서 받은 메세지 : " + line2);
			}
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
