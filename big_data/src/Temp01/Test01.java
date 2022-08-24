package Temp01;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Test01 {
	public static void main(String[] args) {
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		String s = "hello";
		pw.write(s);
		pw.flush();
	
	}
}
