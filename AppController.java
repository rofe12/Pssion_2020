package DS01_201802170_하상호;
//Controller
public class AppController {
	// 공개 상수
	public static final int MIN_ORDER = 3;
	public static final int MAX_ORDER = 99;

	// 비공개 변수들
	private MagicSquare _magicSquare;
	
	//생성자
	public AppController()
	{
		this._magicSquare = new MagicSquare(AppController.MAX_ORDER);
		
	}
	//비공개함수 구현
	//3보다 크거나 같은 차수가 아닌 것을 받았을때 오류 출력
	private void showOrderValidityErrorMessage(OrderValidity orderValidity) 
	{
		switch (orderValidity) {
			case TooSmall:
			AppView.outputLine(
					"[오류] 차수가 너무 작습니다." + AppController.MIN_ORDER+
					"보다 크거나 같아야 합니다.");
				break;
			case TooLarge:
				AppView.outputLine(
						"[오류] 차수가 너무 큽니다." + AppController.MAX_ORDER +
						"보다 작거나 같아야 합니다.");
				break;
			case NotOddNumber:
				AppView.outputLine("[오류] 차수가 짝수입니다. 홀수이어야 합니다.");
				break;
			default:
				break;
		}
	}
	//showTitleForColumnlndexes
	private void showTitleForColumnlndexes(int order) {
		AppView.output("      ");
		for(int col = 0; col < order; col++) {
			AppView.output(String.format(" [%3d]", col));
		}
		AppView.outputLine("");
	}
	//비공계 함수
	//마방진 출력
	private void showBoard(Board board)
	{
		CellLocation currentLoc = new CellLocation();
		this.showTitleForColumnlndexes(board.order());
		for(int row = 0; row < board.order(); row++) {
			AppView.outputRowNomber(row);
			for(int col = 0; col < board.order(); col++) {
				currentLoc.setRow(row);
				currentLoc.setCol(col);
				AppView.outputCellValue(board.cellValue(currentLoc));
			}
			AppView.outputLine("");
		}
	}
	//공개함수 구현
	public void run() {
		AppView.outputLine("<<< 마방진 풀이를 시작합니다 >>>");
		AppView.outputLine("");
		
		int currentOrder = AppView.inputOrder(); //메시지를 내보내고 차수를 입력받음
		OrderValidity currentValidity = OrderValidity.valididtyOf(currentOrder);
		while(currentValidity != OrderValidity.EndOfRun) { // 차수가 음수이면 프로그램 종료
			if (currentValidity == OrderValidity.Valid) { // 차수가 유효한지 검사
				AppView.outputTitleWithOrder(currentOrder);
				Board solvedBoard = this._magicSquare.solve(currentOrder);
				//_magicSquare 객체에게 주어진 차수의 마방진을 풀도록 시킨다.
				//결과로 마방진 판을 얻는다.
				this.showBoard(solvedBoard); //마방진을 화면에 보여준다.
			}
			else {
				//예외처리
				this.showOrderValidityErrorMessage(currentValidity);
			
			}
			
		currentOrder = AppView.inputOrder(); //다음 마방진을 위해 차수를 입력받음
		currentValidity = OrderValidity.valididtyOf(currentOrder);
		}
		AppView.outputLine("");
		AppView.outputLine("<<<마방진 풀이를 종료합니다>>>");
	}
}//End of Class "AppController"
