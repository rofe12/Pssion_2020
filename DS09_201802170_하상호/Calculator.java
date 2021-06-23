package DS09_201802170_하상호;

//Calculator class
public class Calculator {
	// Constants
	private static final int MAX_EXPRESSION_lENGTH = 10;

	// private instance variables
	private Stack<Character> _operatorStack;
	private String _infixExpression;
	private String _postfixExpression;
	private PostfixCalculator _postfixCalculator;

	// Getters / Setters
	private String infixExpression() {
		return this._infixExpression;
	}

	private void setInfixExpression(String newInfixExpression) {
		this._infixExpression = newInfixExpression;
	}

	private String postfixExpression() {
		return this._postfixExpression;
	}

	private void setPostfixExpression(String newPostfixExpression) {
		this._postfixExpression = newPostfixExpression;
	}

	private PostfixCalculator postfixCalculator() {
		return this._postfixCalculator;
	}

	private void setPostfixCalculator(PostfixCalculator newPostfixCalculator) {
		this._postfixCalculator = newPostfixCalculator;
	}

	private Stack<Character> operatorStack() {
		return this._operatorStack;
	}

	private void setOperatorStack(Stack<Character> newOperatorStack) {
		this._operatorStack = newOperatorStack;
	}
	
	//CONSTRUCTOR
	public Calculator() {
		this.setOperatorStack(new ArrayList<Character>(Calculator.MAX_EXPRESSION_lENGTH));
		this.setPostfixCalculator(new PostfixCalculator(Calculator.MAX_EXPRESSION_lENGTH));
	}
	

	private void showOperatorStack(String anOperationLabel) {
		// 스택의 상태를 출력
		AppView.outputDebugMessage("  : " + anOperationLabel + " OperatorStack <Bottom> ");
		for (int i = 0; i < this.operatorStack().size(); i++)
			AppView.outputDebugMessage(((ArrayList<Character>) this.operatorStack()).elementAt(i).charValue() + " ");
		AppView.outputLineDebugMessage("<Top>");
	}

	private void showTokenAndPostfixExpression(char aToken, char[] aPostfixExpressionArray) {
		// postfix 수식으로 출력된 토큰과 현재까지 완성된 postfix 수식을 출력
		AppView.outputDebugMessage(aToken + " : (Postfix 수식으로 출력) ");
		AppView.outputLineDebugMessage(new String(aPostfixExpressionArray));
	}

	private void showTokenAndMessage(char aToken, String aMessage) {
		// Token과 Message 출력
		AppView.outputLineDebugMessage(aToken + " : (" + aMessage + ") ");
	}

	private int inComingPrecedence(Character aToken) {
		// 현재 스택에 들어가야하는 연산자 aToken의 우선순위 값을 돌려줌
		// '('를 만나면, 무조건 스택에 삽입 = 가장 높은 우선순위
		switch (aToken.charValue()) {
		case '(':
			return 20;// inStack에서 0
		case ')':
			return 19;
		case '^':
			return 17;// inStack에서 16
		case '*':
			return 13;
		case '/':
			return 13;
		case '%':
			return 13;
		case '+':
			return 12;
		case '-':
			return 12;
		default:
			return -1;
		}
	}

	private int inStackPrecedence(Character aToken) {
		//스택 안에 존재 하는 동안의 연산자 aToken 의 우선 순위 값을 돌려줌
		// 스택 안에서, 괄호 사이의 연산자들을 만나면
		// '(' 위에 쌓임 = 가장 낮은 우선순위, ')' 를 만나면, 그 안에 우선순위를 모두 pop()
		// 오른쪽 우선 결합법칙
		// '^' 입력토큰은 17, 스택안은 16을 가짐, 스택에 삽입되기 위해서
		switch (aToken.charValue()) {
		case '(':
			return 0; // inComing에서 20
		case ')':
			return 19;
		case '^':
			return 16;// inComing에서 17
		case '*':
			return 13;
		case '/':
			return 13;
		case '%':
			return 13;
		case '+':
			return 12;
		case '-':
			return 12;
		default:
			return -1;
		}
	}

	private CalculatorError infixToPostfix() {
		// infixExpression을 postfixExpression으로 변경
		char[] postfixExpressionArray = new char[this.infixExpression().length()];// char배열선언
		java.util.Arrays.fill(postfixExpressionArray, ' ');// char배열의 모든 칸을 공백으로 채움

		Character currentToken, poppedToken, topToken;
		int p = 0;
		// post수식에 token을 출력할 위치

		this.operatorStack().clear();

		for (int i = 0; i < this.infixExpression().length(); i++) {
			currentToken = this.infixExpression().charAt(i);

			if (Character.isDigit(currentToken.charValue())) {
				// currentToken이 피연산자(숫자)
				postfixExpressionArray[p++] = currentToken;// currentToken을 배열에 삽입
				this.showTokenAndPostfixExpression(currentToken, postfixExpressionArray);// postfix 수식으로 출력
			} else {
				// currentToken이 연산자
				if (currentToken == ')') {
					// currentToken이 오른쪽 괄호
					this.showTokenAndMessage(currentToken, "왼쪽 괄호가 나타날 때까지 스택에서 꺼내어 출력");
					poppedToken = this.operatorStack().pop();

					while ((poppedToken != null) && (poppedToken.charValue() != '(')) {
						// 끝 || '('이 나올때까지 pop()
						postfixExpressionArray[p++] = poppedToken.charValue();// poppedToken을 배열에 삽입
						this.showOperatorStack("Popped");// 스택의 상태 출력
						this.showTokenAndPostfixExpression(poppedToken, postfixExpressionArray);// postfix 수식으로 출력

						poppedToken = this.operatorStack().pop();
					}

					// [오류] while에서 '(' 못 찾고 종료했을 때
					if (poppedToken == null)
						return CalculatorError.InfixError_MissingLeftParen;

					this.showOperatorStack("Popped");// 스택의 상태 출력
				} else {
					// currentToken이 일반연산자
					int inComingPrecedence = this.inComingPrecedence(currentToken.charValue());// 문자에 대한 우선순위 받아오기

					// [오류] default, 알수 없는 연산자
					if (inComingPrecedence < 0) {
						AppView.outputLineDebugMessage(currentToken + " : (Unknown Operator)");
						return CalculatorError.InfixError_UnknownOperator;
					}

					this.showTokenAndMessage(currentToken, "입력 연산자 순위보다 순위가 높지 않은 연산자를 스택에서 꺼내어 출력");

					topToken = this.operatorStack().peek();
					while ((topToken != null) && (this.inStackPrecedence(topToken) >= inComingPrecedence)) {
						// 끝 || topToken의 우선순위가 더 작을때 까지
						poppedToken = this.operatorStack().pop();
						postfixExpressionArray[p++] = poppedToken;
						this.showOperatorStack("Popped");
						this.showTokenAndPostfixExpression(poppedToken, postfixExpressionArray);
						topToken = this.operatorStack().peek();
					}

					// [오류] 스택 크기를 넘은 수식
					if (this.operatorStack().isFull()) {
						this.showOperatorStack("Fulled");
						return CalculatorError.InfixError_TooLongExpression;
					}

					// topToken의 우선순위 < inComingPrecedence
					this.operatorStack().push(currentToken);
					this.showOperatorStack("Pushed");
				}

			}
		} //for 문 종료

		AppView.outputLineDebugMessage("(End of infix expression : 스택에서 모든 연산자를 꺼내어 출력)");

		while (!this.operatorStack().isEmpty()) {
			// 연산자 스택이 빌 때 까지, 스택의 연산자를 차례로 꺼내어 postfix 수식으로 내보냄
			poppedToken = this.operatorStack().pop();
			this.showOperatorStack("Popped");
			// [오류]')'이 있을 수 없음
			if (poppedToken == '(')
				return CalculatorError.InfixError_MissingRightParen;
			postfixExpressionArray[p++] = poppedToken;// poppedToken을 배열에 삽입
			this.showTokenAndPostfixExpression(poppedToken, postfixExpressionArray);// postfix 수식으로 출력
		} // end of while

		this.setPostfixExpression(new String(postfixExpressionArray).trim());
		// Array를 이용한 postfixExpression 생성

		return CalculatorError.InfixError_None;
	}

	public int evaluate(String anInfixExpression) throws CalculatorException {
		// infix 수식을 계산하여 결과를 얻음
		// 오류 발생시, CalculatorException throw
		this.setInfixExpression(anInfixExpression);
		AppView.outputLineDebugMessage("[Infix to Postfix] " + anInfixExpression);

		if ((this.infixExpression() == null) || (this.infixExpression().length() == 0))
			throw new CalculatorException(CalculatorError.InfixError_NoExpression);

		CalculatorError infixError = this.infixToPostfix();
		// infix에서 postfix로 변환
		// postExpression 생성

		if (infixError == CalculatorError.InfixError_None) {
			AppView.outputLine("");
			AppView.outputLineDebugMessage("[Evaluate Postfix] " + this.postfixExpression());
			return this.postfixCalculator().evaluate(this.postfixExpression());
			// AppController의 result 반환
		} else
			throw new CalculatorException(infixError);
	}
}// end of Calculator
