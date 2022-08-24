package big_data.bit.exall2;

// P379Ex01

public class EnglishScore implements Comparable<EnglishScore> {
	String name;
	int score;
	public EnglishScore(String name, int score) {
		this.name = name;
		this.score = score;
	}
	@Override
	public String toString() {
		return name + ", " + score;
	}
	@Override
	public int compareTo(EnglishScore e) {
		if(this.score > e.score) {
			return this.score;
		}
		else {
			return e.score;
		}
	}
	
	public static EnglishScore findBest(EnglishScore[] a) {
		EnglishScore best = a[0];
		for(int i = 0; i < a.length; i++) {
			if(best.score < a[0].compareTo(a[i])) {
				best = a[i];
			}
		}
		return best;
	}
	public static void main(String[] args) {
		EnglishScore[] ea = {new EnglishScore("���", 77), new EnglishScore("�念��", 88),
				new EnglishScore("ȫ�浿", 99)};
		
		System.out.println("���� �ְ� ���� : " + findBest(ea));
	}

	
}
