package DS06_201802170_하상호;

//UnSortedArrayList Class
public class UnSortedArrayList<E extends Comparable<E>> {
	// Constants
	private static final int DEFAULT_CAPACITY = 100;

	// Private Instance Variables
	private int _capacity;
	private int _size;
	private E[] _elements;

	// Getters / Setters
	public int capacity() {
		return this._capacity;
	}

	public void setCapacity(int newCapapcity) {
		this._capacity = newCapapcity;
	}

	public int size() {
		return this._size;
	}

	private void setSize(int newSize) {
		this._size = newSize;
	}

	private E[] elements() {
		return this._elements;
	}

	private void setElemnets(E[] newElements) {
		this._elements = newElements;
	}

	// Constructor
	@SuppressWarnings("unchecked")
	public UnSortedArrayList(int givenCapacity) {
		this.setCapacity(givenCapacity);
		this.setElemnets((E[]) new Comparable[this.capacity()]);
	}

	public UnSortedArrayList() {
		this(UnSortedArrayList.DEFAULT_CAPACITY);
	}
	// public methods

	public boolean addTo(E anElement, int anOrder) {
		if (this.size() == this.capacity()) { // 저장 공간이 없는 경우 false
			return false;
		} else if (anOrder < 0 || anOrder > this.size()) { //범위를 벗어난 경우 false
			return false;
		} else { //삽입
			this.elements()[anOrder] = anElement;
			this.setSize(this.size() + 1);
			return true;
		}
	}
	
	public boolean add(E anElement) { // 마지막 자리 삽입
		return this.addTo(anElement , this.size());

	}

	public E max() {
		if (this.size() == 0)
			return null; // 배열이 비어있는 경우
		else {
			E maxElement = this.elements()[0];// 배열의 처음값을 max로 설정
			for (int i = 1; i < this.size(); i++) { // 순차적으로 비교
				if (maxElement.compareTo(this.elements()[i]) < 0)
					maxElement = this.elements()[i];// max보다 큰값을 max로 재할당
			}
			return maxElement;
		}
	}

} // End Of Class "UnSortedArrayList"
