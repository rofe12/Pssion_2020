package DS14_201802170_하상호;
public class LinkedStack<E> implements Stack<E> {

	private int _size; // 원소의 개수
	private LinkedNode<E> _head; // 맨 앞 노드

	private boolean anElementDoesExistAt(int anOrder) { // anOrder의 유효값을 판단하기 위한 메소드
		return ((anOrder >= 0) && (anOrder < this._size));
	}

	public LinkedStack() { // 생성자
		this._head = null;
		this._size = 0;
	}

	public boolean isEmpty() { // 빈 노드 판단
		return (this._head == null);
	}

	public boolean isFull() { // 꽉찬 노드 판단
		return false;
	}

	public int size() { // getter
		return this._size;
	}

	public E elementAt(int anOrder) {
		if (this.anElementDoesExistAt(anOrder)) {
			LinkedNode<E> currentNode = this._head;
			int nodeCount = 0;
			while (nodeCount < anOrder) {
				currentNode = currentNode.next();
				nodeCount++;
			}
			return currentNode.element();
		} else {
			return null;
		}
	}

	public E first() {
		if (this.isEmpty()) { // 리스트가 비어있으면
			return null;
		} else {
			return elementAt(0); // 맨 앞 값 return
		}
	}

	public E last() {
		if (this.isEmpty()) { // 리스트가 비어있으면
			return null;
		} else {
			return elementAt(this._size - 1); // (원소의 개수 -1)의 위치
		}
	}

	public int orderOf(E anElement) {
		int order = 0;
		LinkedNode<E> currentNode = this._head;
		while (currentNode != null && (!currentNode.element().equals(anElement))) { // anElement와 같은 값이 담긴 노드를 찾으면
																					// while문 탈출
			order++;
			currentNode = currentNode.next(); // 노드의 이동
		}
		if (currentNode == null) { // 노드에 담긴 값이 없을 때
			return -1; // -1 return
		} else {
			return order; // order값 return
		}
	}

	public boolean doesContain(E anElement) {
		return (orderOf(anElement) != -1);
	}

	public boolean addTo(E anElement, int anOrder) {
		if ((anOrder < 0) || (anOrder > this._size)) { // anOrder의 유효 판단
			return false;
		} else if (this.isFull()) {
			return false;
		} else {
			LinkedNode<E> nodeForAdd = new LinkedNode<E>(anElement, null);
			if (anOrder == 0) { // 맨 앞 순서에 삽입
				nodeForAdd.setNext(this._head);
				this._head = nodeForAdd;
			} else { // previous 노드가 존재한다
				LinkedNode<E> previous = this._head;
				for (int i = 1; i < anOrder; i++) {
					previous = previous.next(); // 삽입할 위치의 앞 노드를 찾는다
				}
				nodeForAdd.setNext(previous.next());
				previous.setNext(nodeForAdd);
			}
			this._size++;
			return true;
		}
	}

	public boolean addToFirst(E anElement) { // 맨 앞 저장
		return this.addTo(anElement, 0);
	}

	public boolean addToLast(E anElement) { // 맨 뒤 저장
		return this.addTo(anElement, this._size);
	}

	public boolean add(E anElement) {
		return this.addToFirst(anElement); // addToLast를 하게 되면 마지막 노드까지 읽는 과정이 필요하다.
	}

	public E removeFrom(int anOrder) {
		if (!anElementDoesExistAt(anOrder)) { // 유효 판단
			return null;
		} else { // 삭제할 원소가 있다면
			LinkedNode<E> removed = null;
			if (anOrder == 0) { // 삭제할 원소가 맨 앞 원소
				removed = this._head;
				this._head = this._head.next();
			} else { // 원소가 두 개 이상
				LinkedNode<E> previous = this._head;
				for (int i = 0; i < anOrder - 1; i++) {
					previous = previous.next();
				}
				removed = previous.next(); // anOrder의 앞 노드 값이 previous이므로 삭제할 anOrder의 노드는 previous.next
				previous.setNext(removed.next()); // 삭제된 노드의 다음 노드를 previous.next로 설정
			}
			this._size--; // 하나가 삭제되었으므로 -1
			return removed.element(); // 삭제된 값을 얻음
		}
	}

	public E removeLast() {
		return (this.removeFrom(this._size - 1)); // 제일 마지막 노드를 지움 (element가 저장되어있는 마지막 노드는 size-1번째 노드)
	}

	public boolean replaceAt(E anElement, int anOrder) {
		if (!this.anElementDoesExistAt(anOrder)) {
			return false;
		} else {
			LinkedNode<E> current = this._head;
			for (int i = 0; i < anOrder; i++) {
				current = current.next();
			}
			current.setElement(anElement);
			return true;
		}
	}

	public void clear() { // clear
		this._head = null;
		this._size = 0;
	}

	@Override
	public boolean push(E anElement) { // Top에 원소 추가
		return this.addToLast(anElement);
	}

	@Override
	public E pop() { // Top 원소 삭제
		return this.removeLast();
	}

	@Override
	public E peek() { // Top 원소
		if (this.isEmpty()) { // 비어있으면
			return null;
		} else {
			return this.elementAt(this.size() - 1);
		}
	}

}