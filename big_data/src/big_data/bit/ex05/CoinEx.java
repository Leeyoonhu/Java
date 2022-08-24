package big_data.bit.ex05;

interface Coin {
	int PENNY = 1, NICKEL = 5, DIME = 10, QUARTER = 25;
}

public class CoinEx {
	public static void main(String[] args) {
		System.out.printf("%s은 %d센트입니다.", "DIME", Coin.DIME);
	}
}
