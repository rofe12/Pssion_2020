package DS05_201802170_하상호;
 // ArrayList class
public class ArrayList<E> {
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
	public ArrayList(int givenCapacity) {
		this.setCapacity(givenCapacity);
		this.setElemnets((E[]) new Object[this.capacity()]);
	}

	public ArrayList() {
		this(ArrayList.DEFAULT_CAPACITY);
	}
	// public methods
	
	//상태

	public boolean isEmpty() {
		return (this.size() == 0);
	}

	public boolean isFull() {
		return (this.size() == this._capacity);
	}

	public int orderOf(E anElement) {
		for (int order = 0; order < this.size(); order++) {
			if (this.elements()[order].equals(anElement)) {
				return order;
			}
		}
		return -1;
	}
	
	//내용

	public boolean doesContain(E anElement) {
		return (this.orderOf(anElement) != -1);
	}

	public int frequencyOf(E anElement) {
		int frequencyCount = 0;
		for (int i = 0; i < this.size(); i++) {
			if (this.elements()[i].equals(anElement)) {
				frequencyCount++;
			}
		}
		return frequencyCount;
	}

	public E elementAt(int order) {
		if (order < 0 || order >= this.size()) {
			return null;
		} else
			return this.elements()[order];
	}

	public E first() {
		return this.elementAt(0);
	}

	public E last() {
		return this.elementAt(this.size() - 1);
	}

	public boolean addTo(E anElement, int anOrder) {
		if (this.isFull()) {
			return false;
		} else if (anOrder < 0 || anOrder > this.size()) {
			return false;
		} else {
			this.makeRoomAt(anOrder);
			this.elements()[anOrder] = anElement;
			this.setSize(this.size() + 1);
			return true;
		}
	}

	private void makeRoomAt(int aPosition) {
		for (int i = this.size(); i > aPosition; i--) {
			this.elements()[i] = this.elements()[i - 1];
		}
	}

	public boolean addToFirst(E anElement) {
		return this.addTo(anElement, 0);
	}

	public boolean addToLast(E anElement) {
		return this.addTo(anElement, this.size());
	}

	public boolean add(E anElement) {
		return this.addToLast(anElement);

	}

	public E removeFrom(int anOrder) {
		if (this.elementAt(anOrder) == null) {
			return null;
		} else {
			E removedLelement = this.elements()[anOrder];
			this.removeGapAt(anOrder);
			this.setSize(this.size() - 1);
			return removedLelement;
		}
	}

	private void removeGapAt(int aPosition) {
		for (int i = aPosition + 1; i < this.size(); i++) {
			this.elements()[i - 1] = this.elements()[i];
		}
		this.elements()[this.size() - 1] = null;
	}

	public E removeFirst() {
		return this.removeFrom(0);
	}

	public E removeLast() {
		return this.removeFrom(this.size() - 1);
	}

	public E removeAny() {
		return this.removeLast();
	}

	public boolean replaceAt(E anElement, int anOrder) {
		if (this.elementAt(anOrder) == null) {
			return false;
		} else

			this.elements()[anOrder] = anElement;
		return true;
	}

	public void clear() {
		for (int i = 0; i < this.size(); i++) {
			this.elements()[i] = null;
		}
		this.setSize(0);
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
			return (this.nextPosition() < ArrayList.this.size());
		}

		public E next() {
			E nextElement = null;
			if (this.hasNext()) {
				nextElement = ArrayList.this.elements()[this.nextPosition()];
				this.setNextPosition(this.nextPosition() + 1);
			}
			return nextElement;
		}
	}

} // end of ArrayList
