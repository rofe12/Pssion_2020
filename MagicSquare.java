package DS01_201802170_하상호;

public class MagicSquare {
	private static final int DEFFAULT_MAX_ORDER = 99;
	
	private int _maxOrder;
	
	//Getters / Setters
	public int maxOrder() {
		return this._maxOrder;
	}
	private void setMaxOrder(int newMaxOrder) {
		this._maxOrder = newMaxOrder;
	}
	//기본 생성자
	public MagicSquare() {
		this.setMaxOrder(MagicSquare.DEFFAULT_MAX_ORDER);
	}
	
	//최대 차수를 사용자가 지정하는 생성자
	public MagicSquare(int givenMaxOrder) {
		this.setMaxOrder(givenMaxOrder);
	}
	public Board solve(int anOrder) {
		if (OrderValidity.valididtyOf(anOrder) != OrderValidity.Valid) {
			return null;
		}
		else {
			Board board = new Board(anOrder);
			//차수와 함꼐 Board 객체 생성자를 call 하여 , Board 객체를 생성한다.
			CellLocation currentLoc = new CellLocation(0, anOrder/2);
			//출발 위치(보드의 맨 윗줄 한 가운데)를 현재의 위치로 설정한다.
			CellLocation nextLoc = new CellLocation();
			board.setCellValue(currentLoc, 1); //보드의 <출발위치> 에 1을 채운다
			
			int lastValue = anOrder * anOrder;
			for(int cellValue = 2; cellValue <= lastValue; cellValue++) {
				//1단계 <현재위치>로부터 <다음위치>인 "오른쪽 위"위치를 계산한다.
				int nextRow = (currentLoc.row() + anOrder - 1 ) % anOrder;
				int	nextCol = (currentLoc.col() + 1) % anOrder ;
				nextLoc = new CellLocation(nextRow, nextCol);
				//단계2 <다음위치>가 채워져 있으면
				//<다음위치>를 <현재위치>의 바로 한 줄 아래 칸 위치로 수정한다.
				
				if(!board.cellsEmpty(nextLoc)) {
					nextLoc.setRow((currentLoc.row() + anOrder + 1 ) % anOrder);
					nextLoc.setCol(currentLoc.col());
				}
				//3단계<다음위치>를 새로운 <현재 위치>로 한다.
				currentLoc.setRow(nextLoc.row());
				currentLoc.setCol(nextLoc.col());
				//4단계 새로운 <현재 위치>에  number 값을 넣는다.
				board.setCellValue(currentLoc, cellValue);
			}
			return board;
		}
	}//End of solve()
	
}//End of Class "MagicSquare"
