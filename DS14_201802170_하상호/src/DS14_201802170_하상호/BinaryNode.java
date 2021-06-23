package DS14_201802170_«œªÛ»£;

public class BinaryNode<E> {
	// Private instance variables
	private E _element;
	private BinaryNode<E> _left;
	private BinaryNode<E> _right;

	// Getter/Setter
	public E element () {
		return this._element;
	}

	public void setElement (E newElement) {
		this._element = newElement;
	}

	public BinaryNode<E> left () {
		return this._left;
	}

	public void setLeft (BinaryNode<E> newLeft) {
		this._left = newLeft;
	}

	public BinaryNode<E> right () {
		return this._right;
	}

	public void setRight (BinaryNode<E> newRight) {
		this._right = newRight;
	}

	// Constructors
	public BinaryNode () {
	this.setElement (null) ;
	this.setLeft (null) ;
	this.setRight (null) ;
	}

	public BinaryNode(E givenElement, BinaryNode<E> givenLeft, BinaryNode<E> givenRight) {
		this.setElement(givenElement);
		this.setLeft(givenLeft);
		this.setRight(givenRight);
	}
} // End of class "BinaryNode"
