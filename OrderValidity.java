package DS01_201802170_하상호;
//enum class
public enum OrderValidity {
	EndOfRun,
	Valid,
	TooSmall,
	TooLarge,
	NotOddNumber;
	//예외처리를 위한 함수
	public static OrderValidity valididtyOf (int order) {
		if(order < 0) {
			return OrderValidity.EndOfRun;
		}
		else if(order < AppController.MIN_ORDER) {
			return OrderValidity.TooSmall;
		}
		else if(order > AppController.MAX_ORDER) {
			return OrderValidity.TooLarge;
		}
		else if((order % 2) == 0) {
			return OrderValidity.NotOddNumber;
		}
		else {
			return OrderValidity.Valid;
		}
	}
} // End of enum "OrderValidity"
