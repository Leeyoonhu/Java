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
		EnglishScore[] ea = {new EnglishScore("±è»ñ°«", 77), new EnglishScore("Àå¿µ½Ç", 88),
				new EnglishScore("È«±æµ¿", 99)};
		MathScore[] ma = {new MathScore("±è»ñ°«", 80), new MathScore("Àå¿µ½Ç", 98),
				new MathScore("È«±æµ¿", 70)};
		
		System.out.println("¿µ¾î ÃÖ°í Á¡¼ö : " + EnglishScore.findBest(ea));
		System.out.println("¼öÇÐ ÃÖ°í Á¡¼ö : " + MathScore.findBest(ma));
	}
}
