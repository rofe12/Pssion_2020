package DS13_201802170_«œªÛ»£;

public class DictionaryByBinarySearchTree<Key extends Comparable<Key>, Obj extends Comparable<Obj>>
		extends Dictionary<Key, Obj> {

	// Private instance variables
	private BinaryNode<DictionaryElement<Key, Obj>> _root;

	protected BinaryNode<DictionaryElement<Key, Obj>> root() {
		return this._root;
	}

	private void setRoot(BinaryNode<DictionaryElement<Key, Obj>> newRoot) {
		this._root = newRoot;
	}

	// Constructor
	public DictionaryByBinarySearchTree() {
		this.clear();
	}

	// Private methods
	private DictionaryElement<Key, Obj> elementForKey(Key aKey) {
		if (aKey != null) {
			BinaryNode<DictionaryElement<Key, Obj>> current = this.root();
			while (current != null) {
				if (current.element().key().compareTo(aKey) == 0) {
					return current.element();
				} else if (current.element().key().compareTo(aKey) > 0) {
					current = current.left();
				} else {
					current = current.right();
				}
			}
		}
		return null;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyDoesExist(Key aKey) {
		// TODO Auto-generated method stub
		return (this.elementForKey(aKey) != null);
	}

	@Override
	public Obj objectForKey(Key aKey) {
		// TODO Auto-generated method stub
		DictionaryElement<Key, Obj> element = this.elementForKey(aKey);
		if (element != null) {
			return element.object();
		} else {
			return null;
		}
	}

	@Override
	public boolean addKeyAndObject(Key aKey, Obj anObject) {
		if (aKey == null) {
			return false; // In any case, "aKey" cannot be null for add.
		}
		DictionaryElement<Key, Obj> elementForAdd = new DictionaryElement<Key, Obj>(aKey, anObject);
		BinaryNode<DictionaryElement<Key, Obj>> nodeForAdd = new BinaryNode<DictionaryElement<Key, Obj>>(elementForAdd,
				null, null);
		if (this.root() == null) {
			this.setRoot(nodeForAdd);
			this.setSize(1);
			return true;
		}
		BinaryNode<DictionaryElement<Key, Obj>> current = this.root();
		while (aKey.compareTo(current.element().key()) != 0) {
			if (aKey.compareTo(current.element().key()) < 0) {
				if (current.left() == null) {
					current.setLeft(nodeForAdd);
					this.setSize(this.size() + 1);
					return true;
				} else {
					current = current.left();
				}
			} else {
				if (current.right() == null) {
					current.setRight(nodeForAdd);
					this.setSize(this.size() + 1);
					return true;
				} else {
					current = current.right();
				}
			}
		} // End of while
		return false;
	} // End of "addKeyAndObject()"

	@Override
	public Obj removeObjectForKey(Key aKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		this.setSize(0);
		this.setRoot(null);
	}

	@Override
	public Iterator<DictionaryElement<Key, Obj>> iterator() {
		// TODO Auto-generated method stub
		return new DictionaryIterator() ;
	}


	@SuppressWarnings("unused")
	private class DictionaryIterator implements Iterator<DictionaryElement<Key, Obj>> {

		private BinaryNode<DictionaryElement<Key, Obj>> _nextNode;
		private Stack<BinaryNode<DictionaryElement<Key, Obj>>> _stack;

		private BinaryNode<DictionaryElement<Key, Obj>> nextNode() {
			return this._nextNode;
		}

		private void setNextNode(BinaryNode<DictionaryElement<Key, Obj>> newNextNode) {
			this._nextNode = newNextNode;
		}

		private Stack<BinaryNode<DictionaryElement<Key, Obj>>> stack() {
			return this._stack;
		}

		private void setStack(Stack<BinaryNode<DictionaryElement<Key, Obj>>> newStack) {
			this._stack = newStack;
		}

		// Constructor
		private DictionaryIterator() {
			this.setStack(new ArrayList<BinaryNode<DictionaryElement<Key,Obj>>>());
			this.setNextNode(DictionaryByBinarySearchTree.this.root());
		}

		@Override
		public boolean hasNext() {
			return (this.nextNode() != null) || (!this.stack().isEmpty());
		}

		@Override
		public DictionaryElement<Key, Obj> next() {
			if (!this.hasNext()) {
				return null;
			} else {
				while (this.nextNode() != null) {
					this.stack().push(this.nextNode());
					this.setNextNode(this.nextNode().left());
				}
				BinaryNode<DictionaryElement<Key, Obj>> poppedNode = (BinaryNode<DictionaryElement<Key, Obj>>) this.stack().pop();
				DictionaryElement<Key, Obj> nextElement = poppedNode.element();
				this.setNextNode(poppedNode.right());
				return nextElement;
			}
		}
	}
}
