package DS06_201802170_하상호;
//Linked Node class
public class LinkedNode<E> {

		private LinkedNode<E> _next ;
		private E _element ;
		// Getter/Setter
		public LinkedNode<E> next() {
		return this._next;
		}
		
		public void setNext (LinkedNode<E> newNext) {
			this._next = newNext;
		}
		
		public E element() {
			return this._element;
		}
		public void setElement (E newElement) {
			this._element = newElement;	
		}
		// 생성자
		public LinkedNode () {
		this.setNext(null) ;
		this.setElement(null) ;
		}
		public LinkedNode (E givenElement,LinkedNode<E> givenNext){
		this.setNext(givenNext) ;
		this.setElement(givenElement) ;
		}
		

} // End of class LinkedNode


