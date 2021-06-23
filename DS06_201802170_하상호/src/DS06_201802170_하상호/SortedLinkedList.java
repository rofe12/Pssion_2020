package DS06_201802170_하상호;

//SortedLinkedList Class
public class SortedLinkedList <E extends Comparable<E>> {
	//constant
	private static final int DEFAULT_CAPACITY = 100;
	//private variables
	private int _capacity;
	private int _size;
	private LinkedNode<E> _head;
	//Constructors
	public SortedLinkedList() {
		this(SortedLinkedList.DEFAULT_CAPACITY);
		this.setHead(null);
		this.setSize(0);
	}
	public SortedLinkedList(int givenCapapcity) {
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
	
	//public methods
	public boolean add (E anElement) {
		// 전달 받은 anElement을 배열의 sort 순서에 맞는 위치를 찾아 삽입
		if(this.size() == this.capacity())
			return false;
		else {
			LinkedNode<E> nodeForAdd = new LinkedNode<E>(anElement, null) ;
				if ( this.size() == 0 ) {
					this.setHead(nodeForAdd);
				}
		else { // 리스트에는 적어도 하나의 노드가 있다.
			LinkedNode<E> current = this.head(); // 현재 비교하는 노드
			LinkedNode<E> previous = null; // current 의 앞 노드. 삽입을 하려면, 앞 노드를 알아야 한다. 
				while ( current != null ) { // 리스트의 끝에 도달할 때 까지 비교 검색한다.
					if (current.element().compareTo(anElement) > 0) { 
						// 현재의 원소가 삽입할 anElement 보다 크면
						break; // 삽입할 위치를 찾은 것이므로 비교 검색 중지
					}
					previous = current ; // 아닐 경우 previous를 current 로 변경
					current = current.next() ; // current 를 다음 노드로 이동
				}
				if ( previous == null ) { // anElement 가 가장 작다. 맨 앞에 삽입한다
					nodeForAdd.setNext(this.head()) ;
					this.setHead(nodeForAdd) ;
					}
				else {
					nodeForAdd.setNext(current) ; 
					previous.setNext(nodeForAdd) ;
				}
		}
		this.setSize(this.size()+1) ; // 크기를 하나 증가시킨다. 
		return true ;
		}
		
	}

	
	 public E max(){
	        if(this.size() == 0) return null; //리스트가 비워져 있을때
	        else {
	            LinkedNode<E> current = this.head();
	            E max = this.head().element(); //첫번째 노드의 원소
	            while(current != null){//리스트의 마지막까지 돌기 위해서
	                if(max.compareTo(current.element()) < 0)//음수이면, max가 작기 때문에, 재할당
	                    max = current.element();//max값에 current의 원소를 반환
	                current = current.next();
	            }
	            return max;
	        }
	    }
}//End of SortedLinkedList

