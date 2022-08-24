package big_data.bit.exall;
//영어 성적 배열
//최고점 점수 학생 이름, 점수 출력
class EnglishScore implements Comparable<EnglishScore> {
	String name;
	int score;
	public EnglishScore(String name, int score) {
		this.name = name;
		this.score = score;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	@Override
	public int compareTo(EnglishScore e) {
		// TODO Auto-generated method stub
		if(this.score < e.score) {
			this.score = e.score;
		}
		return this.score;
	}

}

public class P379Ex01 {
	public static void main(String[] args) {
		EnglishScore[] eArray = new EnglishScore[10];
	}
}
