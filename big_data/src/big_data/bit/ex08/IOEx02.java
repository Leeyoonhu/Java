package big_data.bit.ex08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOEx02 {
	// 파일을 스트림 단위로 복사하기
	public static void main(String[] args) {
		String src = "c:/windows/system.ini"; // 이 파일을 1바이트씩 읽어서 그대로 옮길예정
		//			==	c:\\windows\\system.ini
		String dest = "c:/temp/system_copy.ini";
		try {
			FileInputStream fis = new FileInputStream(src);	//원본 src
			FileOutputStream fos = new FileOutputStream(dest); //카피본 dest
			int c;
			while((c = fis.read()) != -1) { // 원본(src)에 읽을게 있다면, 원본에서 읽어서 카피본(dest)에 씀
				// 1=> 읽을게 남아있음, -1=> 읽을게 없음
				fos.write(c); // 아웃풋 스트림의 파일에 c를 쓴다
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
