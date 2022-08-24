package Temp01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Temp02 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random r = new Random();
		List<Integer> numList = new ArrayList<Integer>();
		Set<Integer> lottoSet = new HashSet<Integer>();
		while(true) {
			lottoSet.add(r.nextInt(45) + 1);
			if(lottoSet.size() >= 6) {
				break;
			}
		}
		Iterator<Integer> ir = lottoSet.iterator();
		System.out.println("1부터 45까지의 정수 6개를 입력하세요.");
		for(int i = 0; i < lottoSet.size(); i++) {
			System.out.print("Number " + (i + 1) + ": ");
			numList.add(scan.nextInt());
		}
		System.out.print("이번 주 로또 번호 >> ");
		while(ir.hasNext()) {
			System.out.printf("%d ", ir.next());
		}
		
		System.out.println();
		System.out.print("내가 선택한 번호 >> ");
		for(int i = 0; i < numList.size(); i++) {
			System.out.printf("%d ", numList.get(i));
		}
		System.out.println();
		System.out.print("일치하는 숫자 >> ");
		for(int i = 0; i < numList.size(); i++) {
			if(lottoSet.contains(numList.get(i))){
				System.out.printf("%d ", numList.get(i));
			}
		}
			
	}
}
