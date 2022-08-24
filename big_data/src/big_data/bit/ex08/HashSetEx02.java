package big_data.bit.ex08;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HashSetEx02 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Set<String> set = new HashSet<String>();
		set.add(scan.next());
		set.add(scan.next());
		set.add(scan.next());
		
		for(String s : set) {
			System.out.println(s);
		}
	}
}
