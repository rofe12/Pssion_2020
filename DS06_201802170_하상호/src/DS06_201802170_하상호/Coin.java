package DS06_201802170_하상호;
//Coin class
public class Coin implements Comparable<Coin> {
	//Constants
	private static final int DEFAUT_VALUE = 0;
	
	//Private instance variables
	//동전의 금액
	private int _value;
	
	//생성자
	public Coin() {
		this._value = this.DEFAUT_VALUE;
	}
	public Coin(int givenValue) { 
		this._value = givenValue;
	}
	
	//공개 함수
	public int value() {
		return this._value;
	}
	public void setValue(int newValue) {
		this._value = newValue;
	}
	//원소간 동일 한지 비교
	public boolean equals (Object otherCoin) {
		if(otherCoin.getClass() != Coin.class) {
			return false;
		}
		else {
			return (this.value() == ((Coin) otherCoin).value() );
		}
	}
	//원소간의 대소관계 비교
	public int compareTo(Coin aCoin) {
		if (this.value() < aCoin.value()) {
			return -1;
		}
		else if(this.value() > aCoin.value()) {
			return 1;
		}
		else {
			return 0;
		}
	}
}//end of "Coin"
