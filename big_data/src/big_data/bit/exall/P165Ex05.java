package big_data.bit.exall;

// 길이 속성만 지닌 직선을 모델링한 Line클래스 
class Line {
	int line;

	public Line(int line) {
		this.line = line;
	}
	
	public boolean isSameLine(Line n) {
		// 두 라인이 같은지 비교
		if(this.line == n.line) {
			return true;
		}
		else {
			return false;
		}
	}
	
}

public class P165Ex05 {
	public static void main(String[] args) {
		Line a = new Line(1);
		Line b = new Line(1);
		
		System.out.println(a.isSameLine(b));
		System.out.println(a == b);
	}
}
