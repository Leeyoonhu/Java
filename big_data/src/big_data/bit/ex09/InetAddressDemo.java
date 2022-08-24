package big_data.bit.ex09;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class InetAddressDemo {
	public static void main(String[] args) {
		InetAddress addr1 = null;
		InetAddress addr2 = null;
		System.out.print("호스트 이름을 입력하세요 : ");
		Scanner scan = new Scanner(System.in);
		String url = scan.next();

		try {
			addr1 = InetAddress.getByName(url);	// 지정한 url의 이름을 문자열로 반환
			addr2 = InetAddress.getLocalHost();	// 현재 PC IP 이름을 문자열로 반환
		} catch (UnknownHostException e) {

		} // TODO Auto-generated catch block
		System.out.print(url + "의 IP 주소 : ");
		System.out.println(addr1.getHostAddress()); // url의 IP주소를 문자열로 반환
		System.out.print("로컬 IP 주소 : ");
		System.out.println(addr2.getHostAddress()); // 현재 PC IP주소

	}
}
