package Temp01;

import java.net.*;
import java.io.*;

public class EchoClient {
	   public static void main(String[] args) {
		      try {
		         Socket socketOfClient = new Socket("127.0.0.1", 9999);
		         BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		        
		         OutputStream out = socketOfClient.getOutputStream();
		         InputStream in = socketOfClient.getInputStream();
		         
		         PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
		         BufferedReader br = new BufferedReader(new InputStreamReader(in));
		         String line = null;
		        
		         while ((line = keyboard.readLine()) != null) {
		            if (line.equals("quit")) {
		               break;
		            }
		            pw.println(line);
		            pw.flush();
		            String echo = br.readLine();
		            System.out.println("서버로부터 전달받은 문자열 : " + echo);
		         }
		        
		         pw.close();
		         br.close();
		         socketOfClient.close();
		      } catch (Exception e) {
		         // TODO Auto-generated catch block
		         e.printStackTrace();
		      }

		   }
}
