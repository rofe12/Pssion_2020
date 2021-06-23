package DS07_201802170_하상호;

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
	//private methods
	private void makeRoomAt(int aPosition) {
		for (int i = this.size(); i > aPosition; i--) {
			this.elements()[i] = this.elements()[i - 1];
		}
	}
	private void removeGapAt(int aPosition) {
		for (int i = aPosition + 1; i < this.size(); i++) {
			this.elements()[i - 1] = this.elements()[i];
		}
		this.elements()[this.size() - 1] = null;
	}
	// public methods
	//상태
	public boolean isEmpty() {
		return (this.size() == 0);
	}

	public boolean isFull() {
		return (this.size() == this._capacity);
	}
	//원소의 존재 확인
	public boolean doesContain (E anElement) {
		return (this.orderOf(anElement) >= 0 ) ;
	}
	//원소를 가진 index 반환
	public int orderOf (E anElement) {
		// 가방이 비어있다면 return -1;
		// 비어있지 않다면 배열의 index값을 반환
		int order = -1;
		for( int index = 0; index < this.size() && order <0; index++) {
			if(this.elements()[index].equals(anElement)) {
				order = index;
			}
		}
		return order;
	}
	//배열의 추상화
	public E elementAt(int anOrder) {
		if(anOrder < 0 || anOrder >= this.size()) {
			return null;
		}
		else {
			return this.elements()[anOrder];
		}
	}
	//calss 내부 와 상속 class 만 사용가능
	protected void setElementAt (int anOrder, E anElement) {
		if(anOrder < 0 || anOrder >= this.size()) {
			return ;
		}
		else {
			this.elements()[anOrder] = anElement;
		}
	}
	//삽입
	public boolean addToFirst(E anElement) {
		if(this.isFull()) {
			return false;
		}
		else {
			this.makeRoomAt(0);
			this.elements()[0] = anElement;
			this.setSize(this.size() +1);
			return true;
		}
	}
	public boolean addToLast (E anelement) {
		if(this.isFull()) {
			return false;
		}
		else {
			this.elements()[this.size()] = anelement;
			this.setSize(this.size() +1);
			return true;
		}
	}
	public boolean add(E anElement) { // 마지막 자리 삽입
		return this.addToLast(anElement);
	}

	//삭제
	public E removeFirst() {
		if(this.isEmpty()) {
			return null;
		}
		else {
			E removedElement = this.elements()[0];
			this.removeGapAt(0);
			this.setSize(this.size() -1);
			return removedElement;
		}
	}
	public E removeLast() {
		if (this.isEmpty()) {
			return null;
		}
		else {
			E removedElement = this.elements()[this.size()];
			this.setSize(this.size() -1);
			return removedElement;
		}
	}
	public E removeAny() {
		return this.removeLast();
	}
	public boolean remove (E anelement) {
		//위치 찾기
		int foundIndex = this.orderOf(anelement);
		//존재하면 삭제
		if(foundIndex < 0) {
			return false; //not found.
		}
		else {
			//삭제 후 배열 정렬
			this.removeGapAt(foundIndex);
			this.setSize(this.size() -1);
			this.elements()[this.size()] = null;
			return true;
		}
	}
	
	public Iterator<E> iterator() {
		return (new ListIterator());
	}
	
	//inner class Iterator
	private class ListIterator implements Iterator<E> {
		//private value
		private int _nextPosition;
		
		//Getter / Setter
		private int nextPosition() {
			return this._nextPosition;
		}

		private void setNextPosition(int newNextPosition) {
			this._nextPosition = newNextPosition;
		}

		private ListIterator() {
			this.setNextPosition(0);
		}
		
		//public methods

		@Override
		public boolean hasNext() {
			return (this.nextPosition() < UnSortedArrayList.this.size());
		}

		public E next() {
			E nextElement = null;
			if (this.hasNext()) {
				nextElement = UnSortedArrayList.this.elements()[this.nextPosition()];
				this.setNextPosition(this.nextPosition() + 1);
			}
			return nextElement;
		}
	}
	

} // End Of Class "UnSortedArrayList"
