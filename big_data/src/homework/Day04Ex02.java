package homework;

import java.util.Scanner;

class Student {
	String name;
	int ban, no, kor, eng, math;

	// 총점 계산 후 반환
	int getTotal() {
		return this.kor + this.eng + this.math;
	}
	// 평균 계산 후 반환
	double getAverage() {
		return ((double)(kor + eng + math) / 3);
	}
	
	void showInfo() {
		System.out.printf("%s  %d  %d  %d  %d  %d  ", name, ban, no, kor, eng, math);
	}
}

public class Day04Ex02 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Student[] stuArr = new Student[3];
		for(int i = 0; i < stuArr.length; i++) {
			stuArr[i] = new Student();
			System.out.println("학생 정보를 이름, 반, 번호, 국어, 영어, 수학 순서대로 입력하세요 -->>");
			stuArr[i].name = scan.next();
			stuArr[i].ban = scan.nextInt();
			stuArr[i].no = scan.nextInt();
			stuArr[i].kor = scan.nextInt();
			stuArr[i].eng = scan.nextInt();
			stuArr[i].math = scan.nextInt();
		}
		System.out.println("==================================================");
		System.out.println("학생이름 반 번호 국어 영어 수학 총점 평균");
		System.out.println("--------------------------------------------------");
		for(int i = 0; i < stuArr.length; i++) {
			stuArr[i].showInfo();
			System.out.print(stuArr[i].getTotal() + "  ");
			System.out.printf("%.1f\n", stuArr[i].getAverage());
		}
		System.out.println("==================================================");
	}
}
