package DS01_201802170_하상호;

public class CellLocation {
	//Constant
	private static final int UNDEFINED_INDEX = -1;
	
	//Private instance variables
	private int _row;
	private int _col;
	
	//Getter / Setter
	public void setRow(int newRow) {
		this._row = newRow;
	}
	public int row() {
		return this._row;
	}
	public void setCol(int newCol) {
		this._col = newCol;
	}
	public int col() {
		return this._col;
	}
	
	//기본 생성자 : Cell 좌표가 주어지지 않는다.
	public CellLocation() {
		
		//Cell 좌표가 주어지지 않으면 (-1, -1)로 설정하기로 한다.
		this.setRow(UNDEFINED_INDEX);
		this.setCol(UNDEFINED_INDEX);
	}
	//Cell 좌표가 주어지는 생성자
	public CellLocation(int givenRow , int givenCol) {
		this.setRow(givenRow);
		this.setCol(givenCol);
	}
	

} //End of class "CellLocation"
