package big_data.bit.day0819;

import java.net.*;
import java.io.*;

public class URLEx02 {
	public static void main(String[] args) {
		try {
			URL url = new URL("https://en.wikipedia.org");
			URLConnection urlc = url.openConnection();
			// URL 의 .openStream 메서드는 inputStream 형// 
			// 해당 주소의 웹에서 우클릭 -> 페이지 소스 보기 했을때의 결과물
			BufferedReader br = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
//			File file = new File("c:/temp/wikipedia.html");
//			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			String read = null;
			while((read = br.readLine()) != null) {
				System.out.println(read);
//				bw.write(read);
			}
//			bw.flush();
			br.close();
//			bw.close();
			// 원본 이미지가 다른이유는 원본페이지는 이미지나 텍스트의 위치가 정해져있는데
			// 불러온 파일에는 텍스트 정보만 있기때문에 디자인 정보가 없이 텍스트만을 출력함
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("URL에서 데이터를 읽는 중");
		}
		
	}
}
