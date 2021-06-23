package DS09_201802170_하상호;

public class AppController {
	private static final char END_OF_CALCULATION = '!';
	private static final boolean DEBUG_MODE = true;

	private Calculator _calculator;

	//getter / setter
	private Calculator calculator() {
		return this._calculator;
	}

	private void setCalculator(Calculator newCalculator) {
		this._calculator = newCalculator;
	}


	//constructor
	public AppController() {
		this.setCalculator(new Calculator());
		AppView.setDebugMode(AppController.DEBUG_MODE);// DebugMode가 true일때만 출력
	}

	//private methods
	private String inputExpression() {
		// 수식을 입력받음
		AppView.outputLine("");
		AppView.output("? 계산할 수식을 입력하시오 (종료하려면 " + END_OF_CALCULATION + " 를 입력하시오) : ");
		return AppView.inputLine();
	}

	private void showCalculatorErrorMessage(CalculatorError anError) {
		// Error코드에 맞는 메시지 출력
		switch (anError) {
		case InfixError_NoExpression:
			AppView.outputLine("[오류] 중위 계산식이 주어지지 않았습니다.");
			break;
		case InfixError_TooLongExpression:
			AppView.outputLine("[오류] 중위 계산식이 너무 길어 처리할 수 없습니다.");
			break;
		case InfixError_MissingLeftParen:
			AppView.outputLine("[오류] 왼쪽 괄호가 빠졌습니다.");
			break;
		case InfixError_MissingRightParen:
			AppView.outputLine("[오류] 오른쪽 괄호가 빠졌습니다.");
			break;
		case InfixError_UnknownOperator:
			AppView.outputLine("[오류] 중위 계산식에 알 수 없는 연산자가 있습니다.");
			break;
		case PostfixError_NoExpression:
			AppView.outputLine("[오류] 후위 계산식이 주어지지 않았습니다.");
			break;
		case PostfixError_TooLongExpression:
			AppView.outputLine("[오류] 후위 계산식이 너무 길어 처리할 수 없습니다.");
			break;
		case PostfixError_TooFewValues:
			AppView.outputLine("[오류] 연산자에 비해 연산값의 수가 적습니다.");
			break;
		case PostfixError_TooManyValues:
			AppView.outputLine("[오류] 연산자에 비해 연산값의 수가 많습니다.");
			break;
		case PostfixError_DivideByZero:
			AppView.outputLine("[오류] 나눗셉의 분모가 0 입니다.");
			break;
		case PostfixError_UnknownOperator:
			AppView.outputLine("[오류] 후위 계산식에 알 수 없는 연산자가 있습니다.");
			break;
		default:
			;//Nothing to do.
		}
	}

	public void run() {
		AppView.outputLine("<<< 계산기 프로그램을 시작합니다 >>>");

		String infixExpression = this.inputExpression();
		while (infixExpression.charAt(0) != AppController.END_OF_CALCULATION) {
			try {
				int result = this.calculator().evaluate(infixExpression);
				AppView.outputLine("> 계산값 : " + result);
			} catch (CalculatorException exception) {
				this.showCalculatorErrorMessage(exception.error());
			}
			infixExpression = this.inputExpression();
		} // end of while

		AppView.outputLine("");
		AppView.outputLine("<<< 계산기 프로그램을 종료합니다 >>>");
	}

}// end of AppController
