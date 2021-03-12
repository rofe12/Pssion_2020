package DS01_201802170_하상호;

public class Board {
	//Constant
	private static int EMPTY_CELL = -1;
	
	//Private instance variables
	private int _order;
	private int[][] _cells;
	
	//Getters / Setters
	public int order() {
		return this._order;
	}
	private void setOrder(int newOrder) {
		this._order = newOrder;
	}
	
	private int[][] cells(){ //_cells 객체를 얻는다.
		return this._cells;
	}
	
	private void setCells(int[][] newCells) { //_cells를 주어진 객체로 설정한다.
		this._cells = newCells;
	}
	 // 공개 , 비공개 함수
	public int cellValue(CellLocation location) {
		//주어진 location 의 cell 에 주어진 value 를 넣는다.
		return this.cells()[location.row()][location.col()];
	}
	public void setCellValue(CellLocation location, int newCellValue) {
		//주어진 location 의 cell 에 주어진 value 를 넣는다.
		this.cells()[location.row()][location.col()] = newCellValue;
	}
	
	private void setCellValue(int row, int col, int newCellValue) {
		//이 method는 class 내부에서만 사용한다.
		//주어진 위치 (row , col) 의 cell 에 주어진 값 value 를 넣는다.
		this.cells()[row][col] = newCellValue;
	}
	
	//기본생성자
	public Board (int givenOrder) {
		this.setOrder(givenOrder);
		this.setCells(new int[givenOrder][givenOrder]);
		for(int row = 0; row < givenOrder; row ++) {
			for ( int col = 0; col < givenOrder; col++) {
				this.setCellValue(row, col, Board.EMPTY_CELL);
			}
		}
	}
	
	//public methods:
	public boolean cellsEmpty(CellLocation location) { // "Cell is empty?"
		//주어진 위치의 cell이 비어 있는지 여부를 알려준다.
		//비어 있으면 true, 아니면 false를 얻는다.
		return(this.cellValue(location) == EMPTY_CELL);
	}

}//End of Calss "Borad"
