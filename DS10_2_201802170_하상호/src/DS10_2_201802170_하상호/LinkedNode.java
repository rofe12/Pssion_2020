package DS10_2_201802170_하상호;
//Linked Node class
public class LinkedNode<T> {

		private LinkedNode<T> _next ;
		private T _element ;
		// Getter/Setter
		public LinkedNode<T> next() {
		return this._next;
		}
		
		public void setNext (LinkedNode<T> newNext) {
			this._next = newNext;
		}
		
		public T element() {
			return this._element;
		}
		public void setElement (T newElement) {
			this._element = newElement;	
		}
		// 생성자
		public LinkedNode () {
		this.setNext(null) ;
		this.setElement(null) ;
		}
		public LinkedNode (T givenElement,LinkedNode<T> givenNext){
		this.setNext(givenNext) ;
		this.setElement(givenElement) ;
		}
		

} // End of class LinkedNode


