package DS10_1_201802170_하상호;

public class CircularArrayQueue<E> implements Queue<E> {
	// Constants
	private static final int DEFAULT_CAPACITY = 100;

	// Instance Variables
	private int _maxLength; // capacity+1
	private int _frontPosition;
	private int _rearPosition;
	private E[] _elements;

	// Getters/Setters
	private int maxLength() {
		return this._maxLength;
	}

	private void setMaxLength(int newMaxlength) {
		this._maxLength = newMaxlength;
	}

	public int capacity() {
		return (this.maxLength() - 1);
	}

	private int frontPosition() {
		return this._frontPosition;
	}

	private void setFrontPosition (int newFrontPosition) {
		this._frontPosition = newFrontPosition;
	}

	private int rearPosition() {
		return this._rearPosition;
	}

	private void setRearPosition (int newRearPosition) {
		this._rearPosition = newRearPosition;
	}
	private E[] elements() {
		return this._elements;
	}
	private void setElements(E[] newElements) {
		this._elements = newElements;
	}
	
	//constructor
    public CircularArrayQueue(){
        this(CircularArrayQueue.DEFAULT_CAPACITY);
    }
    public CircularArrayQueue(int givenCapacity){
        this.setMaxLength(givenCapacity+1);
        this.setElements((E[]) new Object [this.maxLength()]);
        this.setFrontPosition(0);
        this.setRearPosition(0);
    }

	@Override
	public int size() {
		if(this.rearPosition() >= this.frontPosition()) {
			return (this.rearPosition() - this.frontPosition());	
		}
		else {
			return (this.rearPosition() + this.maxLength() - this.frontPosition());
		}
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		int nextRearPosition = (this.rearPosition() + 1)%this.maxLength();
		return (nextRearPosition == this.frontPosition());
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (this.frontPosition() == this.rearPosition());
	}

	@Override
	public E front() {
		// TODO Auto-generated method stub
		E frontElement = null;
		if(!this.isEmpty()) {
			frontElement = this.elementAt(this.frontPosition());
		}
		return frontElement;
	}

	@Override
	public E rear() {
		// TODO Auto-generated method stub
		E rearElement = null;
		if(!this.isEmpty()) {
			rearElement = this.elementAt(this.rearPosition() - 1);
		}
		return rearElement;
	}

	@Override
	public boolean enQueue(E anElement) {
		// TODO Auto-generated method stub
		//맨뒤에 원소 삽입
		if(this.isFull()) {
			return false;
		}
		else {
			this.setRearPosition((this.rearPosition()+1) % this.maxLength());
			this.elements()[this.rearPosition()] = anElement;
		}
		return true;
	}

	@Override
	public E deQueue() {
		// TODO Auto-generated method stub
		E frontElement = null;
		if(!this.isEmpty()) {
			this.setFrontPosition((this.frontPosition() + 1) % this.maxLength());
			frontElement = this.elements()[this.frontPosition()];
			this.elements()[this.frontPosition()] = null;
		}
		return frontElement;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		this.setFrontPosition(0);
		this.setRearPosition(0);
		for(int i = 0; i < this.maxLength(); i++) {
			this.elements()[i] = null;
		}
	}

	@Override
	public E elementAt(int anOrder) {
		// TODO Auto-generated method stub
		// Order != Position
        // (this.frontPosition()+1) % this.maxLength()가 anOrder의 0의 위치
        // anOrder의 위치 = (this.frontPosition() + 1 + Order) % this.maxLength()
        if((0 <= anOrder) && (anOrder < this.size()))
            return this.elements()[(this.frontPosition() + 1 + anOrder) % this.maxLength()];
        else
            return null;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new CircularArrayQueueIterator();
	}
	
	private class CircularArrayQueueIterator implements Iterator<E>{
		
		
		private int _nextOrder;
		
		private int nextOrder() {
			return this._nextOrder;
		}
		private void setNextOrder(int newNextOrder) {
			this._nextOrder = newNextOrder;
		}
		private CircularArrayQueueIterator() {
			this.setNextOrder(0);
		}
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return (this.nextOrder() < CircularArrayQueue.this.size());
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			E nextElement = null;
			if(this.hasNext()) {
				nextElement = CircularArrayQueue.this.elementAt(this.nextOrder());
				this.setNextOrder(this.nextOrder()+1);
			}
			return nextElement;
		}
		
		
	}

}
