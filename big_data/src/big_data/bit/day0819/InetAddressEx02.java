package big_data.bit.day0819;

import java.net.*;

public class InetAddressEx02 {
	public static void main(String[] args) {
		InetAddress inetAddr = null;
		
		try {
			inetAddr = InetAddress.getLocalHost();
			// 로컬 호스트를 가져옴
			System.out.println(inetAddr.getHostName());
			// 로컬 호스트의 이름
			System.out.println(inetAddr.getHostAddress());
			// 로컬 호스트의 주소
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
