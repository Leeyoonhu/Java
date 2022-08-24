package big_data.bit.exall2;

// P380Ex02

import big_data.bit.exall2.*;

public class MathScore implements Comparable<MathScore> {
	String name;
	int score;
	public MathScore(String name, int score) {
		this.name = name;
		this.score = score;
	}
	@Override
	public String toString() {
		return name + ", " + score;
	}
	@Override
	public int compareTo(MathScore m) {
		if(this.score > m.score) {
			return this.score;
		}
		else {
			return m.score;
		}
	}
	
	public static MathScore findBest(MathScore[] b) {
		MathScore best = b[0];
		for(int i = 0; i < b.length; i++) {
			if(best.score < b[0].compareTo(b[i])) {
				best = b[i];
			}
		}
		return best;
	}
	
	
	public static void main(String[] args) {
		EnglishScore[] ea = {new EnglishScore("���", 77), new EnglishScore("�念��", 88),
				new EnglishScore("ȫ�浿", 99)};
		MathScore[] ma = {new MathScore("���", 80), new MathScore("�念��", 98),
				new MathScore("ȫ�浿", 70)};
		
		System.out.println("���� �ְ� ���� : " + EnglishScore.findBest(ea));
		System.out.println("���� �ְ� ���� : " + MathScore.findBest(ma));
	}
}
