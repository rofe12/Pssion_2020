package DS09_201802170_하상호;

//postfixCalculator class
public class PostfixCalculator {

	// Constant
	private static final int DEFAULT_MAX_EXPRESSION_LENGTH = 100;

	// 인스턴스 변수
	private int _maxExpressionLength;
	private Stack<Integer> _valueStack;

	// Getter/Setter
	public int maxExpressionLength() {
		return this._maxExpressionLength;
	}

	private void setMaxExpressionLength(int newMaxExpressionLength) {
		this._maxExpressionLength = newMaxExpressionLength;
	}

	private Stack<Integer> valueStack() {
		return this._valueStack;
	}

	private void setValueStack(Stack<Integer> newValueStack) {
		this._valueStack = newValueStack;
	}

	// constructors
	public PostfixCalculator() {
		this(PostfixCalculator.DEFAULT_MAX_EXPRESSION_LENGTH);
	}

	public PostfixCalculator(int givenMaxExpressionLength) {
		this.setMaxExpressionLength(givenMaxExpressionLength);
		this.setValueStack(new ArrayList<Integer>(this.maxExpressionLength()));
	}
	// public methods

	// Stack 을 이용하여 postfix 수식을 계산하여, 그 결과를 얻는다.
	// 계산 하는 동안에 오류가 발생하면, CalculatorException 객체를 throws 한다
	public int evaluate(String aPostfixExpression) throws CalculatorException {
		if (aPostfixExpression == null || aPostfixExpression.length() == 0) {
			throw new CalculatorException(CalculatorError.PostfixError_NoExpression);
		}
		this.valueStack().clear();
		char token;
		for (int current = 0; current < aPostfixExpression.length(); current++) {
			token = aPostfixExpression.charAt(current);
			if (Character.isDigit(token)) {
				int tokenValue = Character.getNumericValue(token);
				if (this.valueStack().isFull()) {
					// [오류] 수식이 너무 길어 처리가 불가능합니다.
					throw new CalculatorException(CalculatorError.PostfixError_TooLongExpression);
				} else {
					this.valueStack().push(Integer.valueOf(tokenValue));
				}
			} else { // 연산자
				CalculatorError error = this.executeBinaryOperator(token);
				if (error != CalculatorError.PostfixError_None) {
					throw new CalculatorException(error);
				}

			}
			this.showTokenAndValueStack(token);
		} // end of for
		if (this.valueStack().size() == 1) {
			return (this.valueStack().pop().intValue());
		} else {
			throw new CalculatorException(CalculatorError.PostfixError_TooManyValues);
		}

	}

	// private methods
	// Binary 연산자를 실행한다.
	// 연산자를 실행하는 동안에 오류가 발생하면 해당 오류 코드를 얻는다.
	private CalculatorError executeBinaryOperator(char anOperator) {
		if (this.valueStack().size() < 2) {
			return CalculatorError.PostfixError_TooFewValues;
		}
		// Binary operator 만 처리 가능하다.
		int operand1 = this.valueStack().pop().intValue();
		int operand2 = this.valueStack().pop().intValue();
		int calculated = 0;
		switch (anOperator) {
		case '^':
			calculated = (int) Math.pow((double) operand2, (double) operand1);
			break;
		case '*':
			calculated = operand2 * operand1;
			break;
		case '/':
			if (operand1 == 0) {
				AppView.outputLineDebugMessage(
						anOperator + " : (DivideByZero) " + operand2 + " " + anOperator + " " + operand1);
				return CalculatorError.PostfixError_DivideByZero;
			} else {
				calculated = operand2 / operand1;
			}
			break;
		case '%':
			if (operand1 == 0) {
				AppView.outputLineDebugMessage(
						anOperator + " : (DivideByZero) " + operand2 + " " + anOperator + " " + operand1);
				return CalculatorError.PostfixError_DivideByZero;
			} else {
				calculated = operand2 % operand1;
			}
			break;
		case '+':
			calculated = operand2 + operand1;
			break;
		case '-':
			calculated = operand2 - operand1;
			break;
		default:
			return CalculatorError.PostfixError_UnknownOperator;
		}
		this.valueStack().push(Integer.valueOf(calculated));
		// isFull() 검사 불필요 : 2개 pop 했으므로, 스택에 한 개를 push 할 여유 있음.
		return CalculatorError.PostfixError_None;
	}

	// 디버깅 목적.
	// 주어진 토큰과 현재의 스택을 보여준다.
	private void showTokenAndValueStack(char aToken) {
		AppView.outputDebugMessage(aToken + " : ValueStack <Bottom> ");
		for (int i = 0; i < this.valueStack().size(); i++) {
			AppView.outputDebugMessage(((ArrayList<Integer>) this.valueStack()).elementAt(i).intValue() + " ");
		}
		AppView.outputLineDebugMessage("<Top>");
	}

}//end of PostfixCalculator
