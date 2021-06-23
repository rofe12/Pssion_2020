package DS12_201802170_하상호;

public class ParameterSet {
	// 실험에 필요한 매개변수들을 모아 놓는 calss

	private int _startingSize;
	private int _numberOfSizeIncreasingSteps;
	private int _incrementSize;

	// getter / setter
	public int startingSize() {
		return this._startingSize;
	}

	public void setStartingSize(int newStartingSize) {
		this._startingSize = newStartingSize;
	}

	public int numberOfSizeIncreasingSteps() {
		return this._numberOfSizeIncreasingSteps;
	}

	public void setNumberOfSizeIncreasingSteps(int newNumberOfSizeIncreasingSteps) {
		this._numberOfSizeIncreasingSteps = newNumberOfSizeIncreasingSteps;
	}

	public int incrementSize() {
		return this._incrementSize;
	}

	public void setIncrementSize(int newIncrementSize) {
		this._incrementSize = newIncrementSize;
	}

	public int maxDataSize() {
		return ( this.startingSize() + 
				(this.incrementSize() * (this.numberOfSizeIncreasingSteps() -1) ));
	}

	public ParameterSet(int givenStartingSize, int givenNumberOfSizeIncreasingSteps, int givenIncrementSize) {
		this.setStartingSize(givenStartingSize);
		this.setIncrementSize(givenIncrementSize);
		this.setNumberOfSizeIncreasingSteps(givenNumberOfSizeIncreasingSteps);
	}

}
