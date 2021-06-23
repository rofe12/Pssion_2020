package DS03_201802170_하상호;

//LinkedNode Class
public class LinkedNode<E> {
	//비공개 인스턴스 변수
	private E _element; //현재 노드에 있는 코인
	private LinkedNode<E> _next; //다음 노드
	
	//생성자
	public LinkedNode() {
		this._element = null;
		this._next = null;
	}
	
	public LinkedNode(E givenElement) {
		this._element = givenElement;
		this._next = null;
	}
	
	public LinkedNode(E givenElement, LinkedNode<E> givenNext) {
		this._element = givenElement;
		this._next = givenNext;
	}
	
	//Getter / Setter
	public E element() {
		return this._element;
	}
	public void setElement(E newElement) {
		this._element = newElement;
	}
	public LinkedNode<E>next(){
		return this._next;
	}
	public void setNext(LinkedNode<E> newNext) {
		this._next = newNext;
	}

	

}//end of LinkedNode
