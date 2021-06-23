package DS03_201802170_하상호;

//LinkedBag Class
public class LinkedBag<E> {
	//비공개 인스턴스 변수
	private int _size; //가방이 가지고 있는 원소의 개수
	private LinkedNode<E> _head; //연결 체인의 맨 앞 노드를 소유한다.
	
	//변수 Getter / Setter
	public int size() {
		return this._size;	
	}
	private void setSize(int newSize) {
		this._size = newSize;
	}
	private LinkedNode<E> head(){
		return this._head;
	}
	private void setHead(LinkedNode<E> newHead) {
		this._head = newHead;
	}
	
	//생성자
	public LinkedBag() {
		this.setSize(0);
		this.setHead(null);
	}
	//가방이 비어있는지 확인
	public boolean isEmpty() {
		return (this.size() == 0);
	}
	//가방안에 주어진 원소가 존재하는지 확인
	public boolean doesContain(E anElement) {
		LinkedNode<E> currentNode = this.head();
		while(currentNode != null ) {
			if(currentNode.element().equals(anElement)) {
				return true;
			}
			else {
			currentNode = currentNode.next();
				}
			}
		return false;
	}
	//가방안에 주어진 원소가 몇 개 있는지 확인
	public int frequencyOf(E anElement) {
		int frequenctCount = 0;
		LinkedNode <E> currentNode = this._head;
		while(currentNode != null) {
			if(currentNode.element().equals(anElement)) {
				frequenctCount ++;
			}
			currentNode = currentNode.next();
		}
		return frequenctCount;
	}
	//가방안에 주어진 순서의 원소를 얻음
	public E elementAt(int anOrder) {
		if( (anOrder < 0) || (anOrder >= this.size())) {
			return null; //anOrder 가 적정 범위를 벗어나 있음
		}
		else { //anOrder가 범위 안에 있음
			LinkedNode<E> currNode = this.head();
			for(int i = 0 ; i < anOrder ; i ++) {
				currNode = currNode.next();
			}
			return currNode.element();
			
		}
	}
	//가방에 원소를 추가
	public boolean add(E anElement) {
		LinkedNode<E> newNode = new LinkedNode<E>();
		newNode.setElement(anElement);
		newNode.setNext(this._head);
		this.setHead(newNode);
		this.setSize(this.size() + 1);
		return true;
	}
	//가방에서 원소를 삭제
	public boolean remove(E anElement) {
		if(this.isEmpty()) {
			return false;
		}
		else {
			LinkedNode <E> previousNode = null;
			LinkedNode <E> currentNode = this._head;
			boolean found = false;
			//삭제할 위치 찾기
			while(currentNode != null &&!found) {
				if(currentNode.element().equals(anElement)) {
					found = true;
				}
				else {
					previousNode = currentNode;
					currentNode = currentNode.next();
				}
			}
			//삭제
			if(!found) {
				return false;
			}
			else {
				if(currentNode == this.head()) {
					this.setHead(this.head().next());
				}
				else {
					previousNode.setNext(currentNode.next());
					
				}
				this.setSize(this.size() - 1);
				return true;
			}
		}

	}
	//원소 하나를 무작위로 삭제
	//맨 앞을 삭제
	public E removeAny() {
		if(this.isEmpty()) {
			return null;
		}
		else {
			E remvedElement = this.head().element();
			this.setHead(this.head().next());
			this.setSize(this.size() - 1);
			return remvedElement;
		}
	}
	//가방 초기화
	public void clear() {
		this.setSize(0);
		this.setHead(null);
	}
	
}//end of LinkedBag
