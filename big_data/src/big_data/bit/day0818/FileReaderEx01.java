package big_data.bit.day0818;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx01 {
	public static void main(String[] args) {
		BufferedReader br = null;
		String line = null;
		
		try {
			br = new BufferedReader(new FileReader("c:/temp/dorian.txt"));
			while(br.readLine() != null) {
				line = br.readLine();
				System.out.println(line);
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
