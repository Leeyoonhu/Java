package backjoon.bronze;

import java.util.Scanner;

/** 128�ް� ����
 *	8���� ��ǥ ������ ��
 */

// ���簢�� �ΰ����ϰ� ��ġ�� ���� ����

class Area {
	int x1, x2, y1, y2;

	public Area(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	public int calc(){
		return Math.abs(x1 - x2) * Math.abs(y1 - y2);
	}
	
	public int duplicate(Area a) {
		int x3 = 0, y3 = 0;
		if(a.x1 < x1) {
			if(x1 < a.x2 && a.x2 < x2) {
				x3 = a.x2 - x1;
			}
			if(a.x2 > x2) {
				x3 = x2 - x1;
			}
		}
		if(x1 < a.x1 && a.x1 < x2) {
			if(a.x2 < x2) {
				x3 = a.x2 - a.x1;
			}
			if(a.x2 > x2) {
				x3 = x2 - a.x1;
			}
		}
		
		if(a.y1 < y1) {
			if(y1 < a.y2 && a.y2 < y2) {
				y3 = a.y2 - y1;
			}
			if(a.y2 > y2) {
				y3 = y2 - y1;
			}
		}
		if(y1 < a.y1 && a.y1 < y2) {
			if(a.y2 < y2) {
				y3 = a.y2 - a.y1;
			}
			if(a.y2 > y2) {
				y3 = y2 - a.y1;
			}
		}
		return x3 * y3;
	}
		
}

public class Ex01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int totalArea = 0;
		int duplicateArea = 0;
		Area[] areaArray = new Area[4];
		for(int i = 0; i < areaArray.length; i++) {
			int x1 = scan.nextInt();
			int y1 = scan.nextInt();
			int x2 = scan.nextInt();
			int y2 = scan.nextInt();
			areaArray[i] = new Area(x1, y1, x2, y2);
		}
		
		// 전체 사각형 면적의 합
		for(int i = 0; i < areaArray.length; i++) {
			totalArea += areaArray[i].calc();
		}
		// 0번 인덱스 사각형과 겹치는 사각형 넓이
		for(int i = 0; i < areaArray.length; i++) {
			totalArea -= areaArray[i].duplicate(areaArray[0]);
		}
		// 1번 인덱스 사각형과 겹치는 사각형 넓이
		for(int i = 1; i < areaArray.length; i++) {
			totalArea -= areaArray[i].duplicate(areaArray[1]);
		}
		// 2번 인덱스 사각형과 겹치는 사각형 넓이
		for(int i = 2; i < areaArray.length; i++) {
			totalArea -= areaArray[i].duplicate(areaArray[2]);
		}
		// 3번 인덱스 사각형과 겹치는 사각형 넓이
		for(int i = 3; i < areaArray.length; i++) {
			totalArea -= areaArray[i].duplicate(areaArray[3]);
		}
		// 중복으로 뺀 부분의 넓이를 더해줘야하는데...
		
		System.out.println(totalArea);
	}
}
