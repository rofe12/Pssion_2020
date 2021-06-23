package DS09_201802170_하상호;
//CalculatorException class
public class CalculatorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// private Instance variables
	// 오류코드를 저장할 intance variable
	private CalculatorError _error;

	// Getter / Setter
	public CalculatorError error() {
		return this._error;
	}

	public void setError(CalculatorError newError) {
		this._error = newError;
	}

	// Constructors
	public CalculatorException() {
		this.setError(CalculatorError.Undefined);
	}

	public CalculatorException(CalculatorError givenError) {
		this.setError(givenError);
	}

}//end of CalculatorException
