package big_data.bit.day0819;

public class CilentServerExplain {
	/*
	 * 서버 : 서비스 제공 프로그램
	 * 웹, FTP, DBMS, 메신저 (현재 mysql의 ip주소를 다른 pc로 바꾸면 그쪽에서 조인가능)
	 * 클라이언트 연결 수락, 요청 처리, 응답 보내는 역할(response)
	 * 
	 * 클라이언트 : 서비스를 받는 프로그램 
	 * 브라우저, FTP 클라이언트, 메신저 (ex, 카카오톡 디스코드..)
	 * 
	 * 클라이언트 연결 요청 >> 서버 연결 수락 >> 클라이언트 처리(검색, 삽입 등) 요청 >> 서버에서의 요청 처리 >> 요청 결과 클라이언트에게 전송
	 * OSI 7 Layer (응용, 표현, 세션, 전송, 네트워크, 데이터링크, 물리 계층) ==> 전반적인 통신과정
	 * 
	 * 1 layer 응용 계층 
	 * SMTP, FTP, DNS, HTTP..
	 * 
	 * TCP (Transmission Control Protocol)
	 * 전화와 유사한 연결 지향
	 * 데이터 전달한 순서가 보장(받는 순서도 동일)
	 * 데이터 손실x, 에러 없이 원격지 도달
	 * 
	 * UDP (User Datagram Protocol)
	 * 편지와 유사한 비연결 지향
	 * 데이터 손실o, 신뢰성 저하
	 * 
	 * IP => 컴퓨터에 부여된 고유한 주소
	 * 네트워크 어댑터마다 할당되어있음
	 * cmd > ipconfig 시 IPv4(4byte) 주소
	 * 실내에 있는 사람들끼리는 LAN(근거리 통신망)안에있기때문에 근거리안에서만 식별할 수 있는 IP주소부여
	 * 
	 * DNS (Domain Name System)
	 * IP주소와 도메인 이름 사이에서의 변환 수행 시스템
	 * 도메인 이름을 IP주소로 변경
	 * 숫자로 된 주소는 기억하기 어려우므로 IP주소를 www.naver.com처럼 도메인 이름으로 바꿔서 사용
	 * 
	 * cmd의 nslookup 명령어
	 * 도메인 주소나 IP주소 입력시, IP주소나 도메인 주소를 볼 수 있음
	 * 
	 * Port 번호
	 * 응용프로그램 식별 번호 (0~65,535), 
	 * 예시) mySQL 응용프로그램의 포트번호는 3306
	 * (0~1,023) 은 인터넷 주소 관리기구가 특정 프로그램에 예약
	 * 서버 프로그램은 고정된 포트번호 사용
	 * 예시) 메일 서버 = 25번, 웹 서버 = 80번
	 * 포트번호로 응용프로그램을 실행중인 상태에서 다른 응용프로그램의 번호를 동일한 번호로만들어서 충돌할 시 에러 발생
	 * 단, 동일한 환경이 아닐경우는 식별가능 (첫 프로그램 TCP실행, 다른 응용 프로그램 UDP실행)
	 * 
	 * InetAddress 클래스
	 * nslookup의 기능(도메인 -> ip / ip -> 도메인) 구현된 클래스
	 * 로컬 컴퓨터의 InetAddress 얻기 
	 * InetAddres ia = InetAddress.getLocalHost;
	 * .getByName(args[0]) => 1개만 
	 * .getAllbyName(args[1]) => 전부
	 *
	 * 
	 * URL (Uniform Resource Locator)
	 * 원하는 페이지, 검색결과, 데이터베이스, 파일 등이 위치한 곳
	 * 근래에는 identifier 의미로 사용됨
	 * URL 형식
	 * <프로토콜명> :// <도메인명> / 파일이름
	 * https :// www.oracle.com / index.html (https에서의 s는 보안을 의미)
	 * 
	 * 클래스 생성자(4개)
	 * URL(String 도메인주소)
	 * 
	 * URL의 메소드
	 * .openStream() => URL 연결을 설정하고, 연결로 입력받을수있는 inputStream 객체 반환
	 * 
	 * URL 객체에서 데이터 읽기
	 * URL 객체가 가리키는 주소에서 데이터를 가져올 때는 .openStream()메소드
	 * 
	 * 
	 * URLConnection 클래스(상황에 따라서 URL, URLConnection 클래스 맞춰쓰기)
	 * URL 클래스 변수의 .openConnection() 함수로 값 지정
	 * .getInputStream() => URL 연결을 설정하고, 연결로 입력받을수있는 inputStream 객체 반환
	 * 
	 * 
	 * 소켓 (socket)
	 * 단말기 역할 (특정 포트 번호와 연결되어있음)
	 * TCP에서 데이터를 보낼 응용프로그램 식별 가능 (어떤데이터가 어느방향으로 가야할지 식별하는 애)
	 * 소켓 종류 : server, client
	 * 대화를 할때는 클라이언트 소켓 사용
	 * 
	 * 
	 * Socket 클래스
	 * 클라이언트(Client) 소켓에 사용되는 클래스
	 * 읽어올때는 .inputStream(), 출력할떄는 .outputStream()
	 * 두 소켓(Client, Server)이 연결되어있는지 확인하는 .isBound() => boolean 형 반환값, 연결되어있으면 true
	 * 데이터 읽기 타임아웃 시간지정 메소드 .setTimeout(int timeout) => 0이면 타임아웃 해제
	 * 
	 * ServerSocket 클래스
	 * 서버(Server) 소켓에 사용되는 클래스
	 * ServerSocket은 Socket을 만들기위한 클래스임
	 * 주요 생성자 ServerSocket()
	 * 
	 * 
	 * 
	 * 1. 서버 소켓을 만들어서 대기  // server = new ServerSocket(바인딩 포트 : 9999); 
	 * 2. 클라이언트의 요청이 들어오면
	 * 2-1. 서버에서 .accept()함 // [Socket] socketOfServer = server.accept();
	 * 3. 승인이 나면 Socket을 만듬 (client, server) // 클라이언트와 소통하기 위해서(통신) // 
	 * [Socket] socketOfServer = new Socket("127.0.0.1", 9999); // 소통하기 위해 IP주소 만듬 
	 * 4. 각 Socket에서 I/O생성
	 * 5. 클라이언트의 소켓에서 write() 먼저 
	 * 6. 서버의 소켓에서 해당 write()를 read()하고, 다시 write()해서 클라이언트에 보냄
	 * 7. 클라이언트에서 서버에게 받은 write() 를 read()함
	 * 
	 * 
	 * 클라이언트가 서버를 찾을때는 ip주소와 포트번호 참조(Connect to로 연결)
	 * 
	 * 1서버 다클라를 하려면 쓰레드(Thread)를 구현해야함
	 * thread 는 인터페이스를 사용하거나, 상속받아서 사용하는 방법이있다
	 * 
	 */
}
