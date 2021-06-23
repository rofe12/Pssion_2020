package DS07_201802170_«œªÛ»£;
//GradeCounter class
public class GradeCounter {
	//private value
	private int _numberOfA;
	private int _numberOfB;
	private int _numberOfC;
	private int _numberOfD;
	private int _numberOfF;

	//Getter / Setter
	public int numberOfA() {
		return this._numberOfA;
	}

	public int numberOfB() {
		return this._numberOfB;
	}

	public int numberOfC() {
		return this._numberOfC;
	}

	public int numberOfD() {
		return this._numberOfD;
	}

	public int numberOfF() {
		return this._numberOfF;
	}

	private void setNumberOfA(int newNumberOfA) {
		this._numberOfA = newNumberOfA;
	}

	private void setNumberOfB(int newNumberOfB) {
		this._numberOfB = newNumberOfB;
	}

	private void setNumberOfC(int newNumberOfC) {
		this._numberOfC = newNumberOfC;
	}

	private void setNumberOfD(int newNumberOfD) {
		this._numberOfD = newNumberOfD;
	}

	private void setNumberOfF(int newNumberOfF) {
		this._numberOfF = newNumberOfF;
	}

	//constructors
	public GradeCounter() {
		this.setNumberOfA(0);
		this.setNumberOfB(0);
		this.setNumberOfC(0);
		this.setNumberOfD(0);
		this.setNumberOfF(0);
	}


	public void count(char aGrade) {
		// TODO Auto-generated method stub
		switch (aGrade) {
		case 'A':
			this.setNumberOfA(this.numberOfA() + 1);
			break;
		case 'B':
			this.setNumberOfB(this.numberOfB() + 1);
			break;
		case 'C':
			this.setNumberOfC(this.numberOfC() + 1);
			break;
		case 'D':
			this.setNumberOfD(this.numberOfD() + 1);
			break;
		case 'F':
			this.setNumberOfF(this.numberOfF() + 1);
			break;
		}
		
	}

}//End of Gradecounter class
