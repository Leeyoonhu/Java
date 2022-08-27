package bit_commit_exercise.day03;
// Student 클래스를 사용해서 학생의 모든 정보, 필드, 총점, 평균 출력 프로그램
// 조건1. Student 정보를 반드시 배열로 저장
import static utils.scan.scan;

class Student {
	int ban, no, kor, eng, math;
	String name;
	int getTotal() {
		return kor + eng + math;
	}
	double getAverage() {
		return (double)getTotal() / 3;
	}
	void showInfo() {
		System.out.printf("%s  %d  %d  %d  %d  %d  %d  %.1f\n", name, ban, no, kor, eng, math, getTotal(), getAverage());
	}
}

public class Ex01 {
	public static void main(String[] args) {
		Student[] sArray = new Student[3];
		sArray[0] = new Student();
		sArray[1] = new Student();
		sArray[2] = new Student();
		for(int i = 0; i < sArray.length; i++) {
			System.out.println("학생 정보 입력(이름, 반, 번호, 국, 영, 수)");
			sArray[i].name = scan.next();
			sArray[i].ban = scan.nextInt();
			sArray[i].no = scan.nextInt();
			sArray[i].kor = scan.nextInt();
			sArray[i].eng = scan.nextInt();
			sArray[i].math = scan.nextInt();
		}
		System.out.println("========================================");
		System.out.println("학생이름 반  번호  국어  영어  수학  총점  평균");
		System.out.println("----------------------------------------");
		for(int i = 0; i < sArray.length; i++) {
			sArray[i].showInfo();
		}
		System.out.println("========================================");
		
	}
}
