package DS05_201802170_하상호;
//enum MainMenu
public enum MainMenu {
	//constant
	Error,
	
	DoeseContain,
	ElemnetAt,
	First,
	Last,
	OrderOf,
	
	AddTo,
	AddToFirst,
	AddToLast,
	Add,
	
	RemoveFrom,
	RemoveFirst,
	RemoveLast,
	RemoveAny,
	
	ReplaceAt,
	
	EndOfRun;
	
	public static final int END_OF_RUN = 99;
	// 예외처리 , 상수의 인덱스값을 반환
	public static MainMenu value(int menuNumber) {
		if (menuNumber == END_OF_RUN) {
			return MainMenu.EndOfRun;
		} else if (menuNumber < DoeseContain.ordinal() || menuNumber > ReplaceAt.ordinal()) {
			return MainMenu.Error;
		} else {
			return MainMenu.values()[menuNumber];
		}
	}
} //end of MainMenu
