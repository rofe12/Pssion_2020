package DS06_201802170_«œªÛ»£;
//MeasuredResult Class
public class MeasuredResult {
	//Instance variables
	private int _size;
	private long _durationForAdd;
	private long _durationForMax;
	
	// Getters / Setters
	public int size() {
		return this._size;
	}
	public void setSize (int newSize) {
		this._size = newSize;
	}
	
	public long durationForAdd() {
		return this._durationForAdd;
	}
	public void setDurationForAdd (long newDurationForAdd) {
		this._durationForAdd = newDurationForAdd;
	}
	
	public long durationForMax() {
		return this._durationForMax;
	}
	public void setDurationForMax(long newDurationForMax) {
		this._durationForMax = newDurationForMax;
	}
	
	//Constructors
	public MeasuredResult() {
		this (0,0,0) ;
	}
	public MeasuredResult(int givenSize, long DurationForAdd , long givenDurationForMax)
	{
		this.setSize(givenSize);
		this.setDurationForAdd(DurationForAdd);
		this.setDurationForMax(givenDurationForMax);
	}
	

}//End of Class "MeasuredResult"
