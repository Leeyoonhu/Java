package big_data.bit.day0818;

public class StreamExplain {
	/*
	 * 모든 스트림은 단반향 (input / output)
	 * 입출력 기본단위 : byte
	 * 바이트 기반 스트림 : InputStream / OutputStream ==> 이미지나 동영상 파일 처리 유용
	 * 문자 기반 스트림 : Reader / Writter
	 * input, output 스트림의 사용 갯수는 상관없음 (연결해서 사용 => 파이프라이닝)
	 * 
	 * I/O는 속도가 느려서 한꺼번에 데이터를 모아뒀다가(=버퍼에 저장) 읽어옴
	 * Input / OutputStream
	 * 
	 * .read()
	 * .read() 반환값은 1byte, 더 이상 읽을 데이터가없으면 -1, int타입 함수
	 * 입력 스트림으로 부터 1byte 읽고 int 타입(4byte)으로 리턴, 리턴된 4byte중 1byte에만 데이터가 들어있음
	 *
	 * .write()
	 * .write() 에서 인수가 배열이면 byte[], int타입(4byte) 함수 
	 * 1byte만 출력 스트림으로 보냄 
	 * 버퍼를 비우기 위해(모아뒀던 데이터를 출력) .flush() 호출 필요
	 * BufferedInput / OutputStream => Stream에 버퍼를 붙임
	 * 
	 * 
	 * 
	 */
}
