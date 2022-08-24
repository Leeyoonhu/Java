package big_data.bit.exall;

import java.util.Scanner;

abstract class Echoer {
	void start() {
		System.out.println("시작합니다.");
	}
	
	abstract void echo();
	
	void stop() {
		System.out.println("종료합니다.");
	}
}

public class P306Ex08 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Echoer e = new Echoer() {
			@Override
				void echo() { //입력한 값 그대로 반복.. 끝 나오면 out.. 띄어쓰기 값도 저장해야함..
				// TODO Auto-generated method stub
				String str1 = null, str2 = null;
				for(int i = 0; ; i++) {
					str1 = in.next();
					System.out.print(str1);
					str2 = in.nextLine();
					System.out.println(str2);
					if(str1.equals("끝") || str2.equals("끝")) {
						break;
					}
				}
			}
		};
		
		e.start();
		e.echo();
		e.stop();
	}
}
