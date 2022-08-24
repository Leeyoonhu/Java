package backjoon.bronze;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num;
		while(true) {
			num = scan.nextInt();
			if(num < 100000 && num > 9999) {			
				if((num / 10000 == num % 10) && ((num / 1000) % 10 == (num / 10) % 10)) {
					System.out.println("yes");
				}
				else {
					System.out.println("no");
				}
			}
			else if(num > 999) {
				if((num / 1000 == num % 10) && ((num / 100) % 10 == (num / 10) % 10)) {
					System.out.println("yes");
				}
				else {
					System.out.println("no");
				}
			}
			else if(num > 99) {
				if((num / 100 == num % 10)) {
					System.out.println("yes");
				}
				else {
					System.out.println("no");
				}
			}
			else if(num > 9) {
				if((num / 10 == num % 10)) {
					System.out.println("yes");
				}
				else {
					System.out.println("no");
				}
			}
			else if(num >= 1) {
				System.out.println("yes");
			}
			if(num == 0) {
				break;
			}
		}
	}
}
