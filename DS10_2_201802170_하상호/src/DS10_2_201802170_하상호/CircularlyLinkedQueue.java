package DS10_2_201802170_«œªÛ»£;

public class CircularlyLinkedQueue<E> implements Queue<E> {
	private int _size;
	private LinkedNode<E> _rearNode;

	public CircularlyLinkedQueue() {
		// TODO Auto-generated constructor stub
		this.setSize(0);
		this.setRearNode(null);
	}

	// Getter / Setter
	public void setSize(int newSize) {
		this._size = newSize;
	}

	public LinkedNode<E> rearNode() {
		return this._rearNode;
	}

	public void setRearNode(LinkedNode<E> newNode) {
		this._rearNode = newNode;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this._size;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (this.rearNode() == null);
	}

	@Override
	public E front() {
		// TODO Auto-generated method stub
		E frontElement = null;
		if (!this.isEmpty()) {
			frontElement = this.rearNode().next().element();
		}
		return frontElement;
	}

	@Override
	public E rear() {
		// TODO Auto-generated method stub
		E rearElement = null;
		if (!this.isEmpty()) {
			rearElement = this.rearNode().element();
		}
		return rearElement;
	}

	@Override
	public boolean enQueue(E anElement) {
		// TODO Auto-generated method stub
		LinkedNode<E> newRearNode = new LinkedNode(anElement, null);
		if (this.isEmpty()) {
			newRearNode.setNext(newRearNode);
		} else {
			newRearNode.setNext(this.rearNode().next());

			this.rearNode().setNext(newRearNode);
		}
		this.setRearNode(newRearNode);
		this.setSize(this.size() + 1);
		return true;
	}

	@Override
	public E deQueue() {
		// TODO Auto-generated method stub
		E frontElement = null;
		if (!this.isEmpty()) {
			frontElement = this.rearNode().next().element();
			if (this.rearNode() == this.rearNode().next()) {

				this.setRearNode(null);
			} else
				this.rearNode().setNext(this.rearNode().next().next());
			this.setSize(this.size() - 1);
		}
		return frontElement;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		this.setRearNode(null);
		this.setSize(0);
	}

	@Override
	public E elementAt(int anOrder) {
		// TODO Auto-generated method stub
		if ((0 > anOrder) || (anOrder > this.size() - 1)) {
			return null;
		} else {
			LinkedNode<E> frontNode = this.rearNode().next();
			int nodeCount = 0;
			while (nodeCount < anOrder) {
				frontNode = frontNode.next();
				nodeCount++;
			}
			return frontNode.element();
		}
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new CirularlyLinkedQueueIterator();
	}

	private class CirularlyLinkedQueueIterator implements Iterator<E> {
		private LinkedNode<E> _nextNode;
		private int _count;

		private LinkedNode<E> nextNode() {
			return this._nextNode;
		}

		private void setNextNode(LinkedNode<E> newNextNode) {
			this._nextNode = newNextNode;
		}

		private int count() {
			return this._count;
		}

		private void setCount(int newCount) {
			this._count = newCount;
		}

		private CirularlyLinkedQueueIterator() {
			this.setNextNode(CircularlyLinkedQueue.this.rearNode());
			this.setCount(CircularlyLinkedQueue.this.size());
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return (this.count() > 0);
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			if (this.hasNext()) {
				this.setNextNode(this.nextNode().next());
				E nextElement = this.nextNode().element();
				this.setCount(this.count() - 1);
				return nextElement;
			} else {
				return null;
			}
		}

	}

}
