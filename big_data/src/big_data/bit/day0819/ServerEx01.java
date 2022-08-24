package big_data.bit.day0819;

import java.io.*;
import java.net.*;
import java.util.*;

public class ServerEx01 {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9998);
			System.out.println("접속을 기다립니다.");
			Socket serverSocket = server.accept();
			InetAddress ia = serverSocket.getInetAddress();
			System.out.println(ia.getHostAddress() + " 로 부터 접속하였습니다.");
			
			InputStream is = serverSocket.getInputStream();
			OutputStream os = serverSocket.getOutputStream();
			
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(os));
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			String line = null;
			while((line = br.readLine()) != null) {
				System.out.println("클라이언트로부터 전송받은 문자열 : " + line);
				pw.println(calc(line));
				pw.flush();
			}
			pw.close();
			br.close();
			serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String calc(String s) {
		// 문자열을 숫자로만 추려서
		List<String> strList = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(s, " +-/*");
		while(st.hasMoreTokens()) {
			strList.add(st.nextToken());
		}
		if(s.contains("+")) {
			double d = Double.parseDouble(strList.get(0)) + Double.parseDouble(strList.get(1));
			s = String.format("%s = %.1f", s, d);
			return s;
		}
		if(s.contains("-")) {
			double d = Double.parseDouble(strList.get(0)) - Double.parseDouble(strList.get(1));
			s = String.format("%s = %.1f", s, d);
			return s;
		}
		if(s.contains("*")) {
			double d = Double.parseDouble(strList.get(0)) * Double.parseDouble(strList.get(1));
			s = String.format("%s = %.1f", s, d);
			return s;
		}
		if(s.contains("/")) {
			double d = Double.parseDouble(strList.get(0)) / Double.parseDouble(strList.get(1));
			s = String.format("%s = %f", s, d);
			return s;
		}
		return null;
	}
}
