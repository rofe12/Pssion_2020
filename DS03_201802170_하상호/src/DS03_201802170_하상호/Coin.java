package DS03_201802170_하상호;
//Coin class
public class Coin {
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
	//otherCoin 이 실제 class 인지 확인
	//Coin 이 아니면 false
	//Coin 이 맞다면 value() 비교
	//동일한 값일 경우 true 아닐경우 false
	/* Object 타입 확인
	 * 이 과제는 CoinBag 이고, Coin 간의 비교를 한다. 
	 * 다른 객체에서 객체간의 비교를 위해서 상위 클래스인 Object 타입을 사용한다.
	 *  모든 calss 는 Object 를 상속한다.
	 */ 
	public boolean equals (Object otherCoin) {
		if(otherCoin.getClass() != Coin.class) {
			return false;
		}
		else {
			return (this.value() == ((Coin) otherCoin).value() );
		}
	}
}//end of "Coin"
