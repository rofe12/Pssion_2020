package DS06_201802170_하상호;
//UnSortedLinkedList Class
public class UnSortedLinkedList<E extends Comparable<E>> {
	//constant
	private static final int DEFAULT_CAPACITY = 100;
	// private values
	private int _capacity;
	private int _size;
	private LinkedNode<E> _head;

	//Constructors
	public UnSortedLinkedList() {
		this(UnSortedLinkedList.DEFAULT_CAPACITY);
		this.setHead(null);
		this.setSize(0);
	}

	public UnSortedLinkedList(int givenCapapcity) {
		// TODO Auto-generated constructor stub
		this.setCapacity(givenCapapcity);
		this.setHead(null);
		this.setSize(0);
	}
	
	//Getter / Setter
	public int capacity() {
		return this._capacity;
	}

	private void setCapacity(int setCapacity) {
		this._capacity = setCapacity;
	}

	public int size() {
		return this._size;
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

	// public methods

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
		this.setSize(this.size() + 1);
		return true;
	}

	public boolean add(E anElement) {
		// 처음에 넣는 이유 :for문을 안돌아도 됨
		return this.addTo(anElement, 0);
	}

	public E max() {
		if (this.size() == 0)
			return null; // 리스트가 비워져 있을때
		else {
			LinkedNode<E> current = this.head();
			E max = this.head().element(); // 첫번째 노드의 원소
			while (current != null) {// 리스트의 마지막까지 돌기 위해서
				if (max.compareTo(current.element()) < 0)// 음수이면, max가 작기 때문에, 재할당
					max = current.element();// max값에 current의 원소를 반환
				current = current.next();
			}
			return max;
		}
	}
}//End of UnSortedLinkedList
