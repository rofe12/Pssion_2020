package DS05_201802170_하상호;
// LinkedList class
public class LinkedList<E> {
	//private values
	private int _size;
	private LinkedNode<E> _head;

	//constructer
	public LinkedList() {
		this._head = null;
		this._size = 0;
	}
	//Getter / Setter
	public int size() {
		return _size;
	}

	private void setSize(int newSize) {
		this._size = newSize;
	}

	private LinkedNode<E> head() {
		return _head;
	}

	private void setHead(LinkedNode<E> newHead) {
		this._head = newHead;
	}
	//public methods
	//상태
	public boolean isEmpty() {
		return (this._size == 0);
	}

	public boolean isFull() {
		return false;
	}
	
	//내용
	
	public E elementAt(int Order) {
		if ((0 > Order) || (Order >= this.size())) {
			return null;
		} else {
			LinkedNode<E> currentNode = this.head();
			int nodeCount = 0;
			while (nodeCount < Order) {
				currentNode = currentNode.next();
				nodeCount++;
			}
			return currentNode.element();
		}
	}

	public E first() {
		if (this.isEmpty()) {
			return null;
		} else
			return elementAt(0);
	}

	public E last() {
		if (this.isEmpty()) {
			return null;
		} else
			return elementAt(this.size() - 1);
	}

	public int orderOf(E anElement) {
		int order = 0;
		LinkedNode<E> currentNode = this.head();
		while (currentNode != null && (!currentNode.element().equals(anElement))) {
			order++;
			currentNode = currentNode.next();
		}
		if (currentNode == null) {
			return -1;
		} else
			return order;
	}

	public boolean doesContain(E anElement) {
		// 만약 anElement값을 가진 노드가 있는 지 확인
		return (orderOf(anElement) != -1);
	}

	//원소 삽입
	public boolean addTo(E anElement, int Order) {
		// Order 순서에 anElement를 값으로 하는 노드 삽입
		if ((0 > Order) || (Order > this.size())) {
			// Order가 유효한지 확인
			return false;
		}
		LinkedNode<E> nodeForAdd = new LinkedNode<E>(anElement, null);
		if (Order == 0) { // Node 순서가 맨 앞일 때, previous 노드가 없는 경우
			nodeForAdd.setNext(this.head());
			setHead(nodeForAdd);
		} else { // previous 노드가 있는 경우
			LinkedNode<E> previous = this.head();
			for (int i = 1; i < Order; i++) {
				previous = previous.next();
			}
			nodeForAdd.setNext(previous.next());
			previous.setNext(nodeForAdd);
		}
		this._size++;
		return true;
	}

	public boolean addToFirst(E anElement) {
		return this.addTo(anElement, 0);
	}

	public boolean addToLast(E anElement) {
		return this.addTo(anElement, this.size());
	}

	public boolean add(E anElement) {
		// 처음에 넣는 이유 :for문을 안돌아도 됨
		return this.addToFirst(anElement);
	}


	//원소 삭제 
	public E removeFrom(int Order) {
		// Order의 순서의 노드를 삭제
		if (((0 > Order) || (Order >= this.size()))) {
			return null;// 범위내에 존재하는지 확인
		} else {
			LinkedNode<E> removedNode = null;
			if (Order == 0) {
				removedNode = this.head();
				this.setHead(this.head().next());
			} else {
				LinkedNode<E> previousNode = this.head();
				for (int i = 1; i < Order; i++) {
					previousNode = previousNode.next();
				}
				removedNode = previousNode.next();
				previousNode.setNext(removedNode.next());
			}
			this._size--;
			return removedNode.element();
		}
	}

	public E removeFirst() {
		// 리스트 맨 처음의 원소 삭제
		return this.removeFrom(0);
	}

	public E removeLast() {
		// 리스트 맨 마지막의 원소 삭제
		return this.removeFrom(this.size() - 1);
	}

	public E removeAny() {
		// 리스트 중 가장 효과적인 곳에 삭제 = 맨 앞
		return this.removeFirst();
	}

	public boolean remove(E anElement) {
		int orderOfRemove = this.orderOf(anElement);
		if (orderOfRemove < 0) {
			return false; // 해당 순서의 값이 없을 때, -1
		} else
			this.removeFrom(orderOfRemove);
		return true;
	}


	public boolean replaceAt(E anElement, int Order) {
		// anElemtent로 Order순서의 노드값 변경
		if ((0 > Order) || (Order >= this.size())) {
			return false;
		} else {
			LinkedNode<E> currentNode = this.head();
			for (int i = 0; i < Order; i++) {
				currentNode = currentNode.next();
			}
			currentNode.setElement(anElement);
			return true;
		}
	}

	public void clear() {
		this.setHead(null);
		this.setSize(0);

	}
	//Iterator cunstructer
	public Iterator<E> iterator() {
		return new ListIterator();
	}

	//ITERATOR 
	private class ListIterator implements Iterator<E> {
		private LinkedNode<E> _nextNode; // 연결 체인에서 다음 원소를 소유하고 있는 노드

		private ListIterator() {
			this._nextNode = LinkedList.this.head();
		}

		// Getter / Setter
		private LinkedNode<E> nextNode() {
			return this._nextNode;
		}

		private void setNextNode(LinkedNode<E> newNextNode) {
			this._nextNode = newNextNode;
		}

		//public methods
		public boolean hasNext() {
			return (this.nextNode() != null);
		}

		public E next() {
			E nextElement = null;
			if (this.hasNext()) {
				nextElement = this.nextNode().element();
				this.setNextNode(this.nextNode().next());
				return nextElement;
			} else
				return null;
		}
	}
}// end of LinkedList
