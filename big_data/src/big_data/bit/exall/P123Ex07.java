package big_data.bit.exall;

import java.util.Scanner;

public class P123Ex07 {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		String c = input("철수");
		String y = input("영희");
		whosWin(c,y);
	}

	public static String input(String name) {
		// TODO Auto-generated method stub
		return name;
	}
	
	public static void whosWin(String c, String y) {
		System.out.print(c + " : ");
		String chul = scan.next();
		System.out.print(y + " : ");
		String young = scan.next();
		
		if(chul.equals(young)) {
			System.out.println("비겼습니다.");
		}
		else if(((chul.equals("r") && young.equals("s"))) || ((chul.equals("s") && young.equals("p"))) || ((chul.equals("p") && young.equals("r")))) {
			System.out.println(c + ", 승!");
		}
		else {
			System.out.println(y + ", 승!");
		}
	}
}
