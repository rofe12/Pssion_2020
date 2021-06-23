package DS09_201802170_하상호;
//enum CalculatorError
public enum CalculatorError {
	
	//Error 발생전 상태로 초기화하는 목적으로 사용
    Undefined,

    //Infix 수식을 계산하는 종안 발생할 수 있는 오류 코드
    //<Calculator>
    InfixError_None,
    InfixError_NoExpression,
    InfixError_TooLongExpression,
    InfixError_MissingLeftParen,
    InfixError_MissingRightParen,
    InfixError_UnknownOperator,

    //Postfix 수식을 계산하는 종안 발생할 수 있는 오류 코드
    //<Postfix Calculator>
    PostfixError_None,
    PostfixError_NoExpression,
    PostfixError_TooLongExpression,
    PostfixError_TooFewValues,
    PostfixError_TooManyValues,
    PostfixError_DivideByZero,
    PostfixError_UnknownOperator,


}//end of CalculatorError
