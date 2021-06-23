package DS14_201802170_하상호;

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
		if (aKey == null) {
			return null;
		}
		if (this.root() == null) {
			return null;
		}
		if (aKey.compareTo(this.root().element().key()) == 0) {
			// this.root() is the node to be removed.
			Obj objectForRemove = this.root().element().object();
			if ((this.root().left() == null) && (this.root().right() == null)) {
				this.setRoot(null); // Root-only tree
			} else if (this.root().left() == null) {
				this.setRoot(this.root().right());
			} else if (this.root().right() == null) {
				this.setRoot(this.root().left());
			} else {
				this.root().setElement(this.removeRightMostElementOfLeftSubTree(this.root()));
			}
			this.setSize(this.size() - 1);
			return objectForRemove;
		}
		
		BinaryNode<DictionaryElement<Key,Obj>> current = this.root() ;
		BinaryNode<DictionaryElement<Key,Obj>> child = null ;
		do {
			if ( aKey.compareTo(current.element().key()) < 0 ) {
				child = current.left() ;
				if ( child == null ) {
					return null ; // "aKey" does not exist.
				}
				if ( aKey.compareTo(child.element().key()) == 0 ) { // Found. "child" is to be removed.
					Obj objectForRemove = child.element().object() ;
					if ( child.left() == null && child.right() == null ) {
						current.setLeft(null) ; // "child" is a leaf.
					}
					else if (child.left() == null) { // "child" has no left.
						current.setLeft(child.right()) ;
					}
					else if (child.right() == null) { // "child has no right.
						current.setLeft(child.left()) ;
					}
					else {
						child.setElement (this.removeRightMostElementOfLeftSubTree(child)) ;
					}
					this.setSize (this.size()-1) ;
					return objectForRemove;
				}
		}
			else {
					child = current.right() ;
					if ( child == null ) {
						return null ; // "aKey" does not exist.
					}
					if ( aKey.compareTo(child.element().key()) == 0 ) { // Found. "child" is to be removed.
						Obj objectForRemove = child.element().object() ;
						if ( child.left() == null && child.right() == null ) {
							current.setRight(null) ;
						}
						else if (child.left() == null) {
							current.setRight(child.right()) ;
						}
						else if (child.right() == null) {
							current.setRight(child.left()) ;
						}
						else {
							child.setElement (this.removeRightMostElementOfLeftSubTree(child)) ;
						}
						this.setSize (this.size()-1) ;
						return objectForRemove;
					}
				}
				current = child;
			} while (true) ;
		} // End of "removeObjectForKey()"

	private DictionaryElement<Key, Obj> removeRightMostElementOfLeftSubTree(
			BinaryNode<DictionaryElement<Key, Obj>> root) {
		// At this point, "root" has non-empty left subtree.
		BinaryNode<DictionaryElement<Key, Obj>> leftOfRoot = root.left();
		if (leftOfRoot.right() == null) {
			// "leftOfRoot" has no right subtree, so "leftOfRoot" itself is the rightmost
			// node.
			root.setLeft(leftOfRoot.left());
			return leftOfRoot.element();
		} else {
			// There exist at least one node in the right subtree of the left of the root.
			BinaryNode<DictionaryElement<Key, Obj>> parentOfRightMost = leftOfRoot;
			BinaryNode<DictionaryElement<Key, Obj>> rightMost = parentOfRightMost.right();
			while (rightMost.right() != null) {
				parentOfRightMost = rightMost;
				rightMost = rightMost.right();
			}
			// We have found the right-most node so that it is owned by "rightMost".
			parentOfRightMost.setRight(rightMost.left());
			return rightMost.element();
		}
	} // End of "removeRightMostElementOfLeftSubTree()"

	@Override
	public void clear() {
		this.setSize(0);
		this.setRoot(null);
	}

	@Override
	public Iterator<DictionaryElement<Key, Obj>> iterator() {
		// TODO Auto-generated method stub
		return new DictionaryIterator();
	}

	@Override
	public void scanInSortedOrder() {
		this.inorderRecursively(this.root(), 1);
	}

	private void inorderRecursively(BinaryNode<DictionaryElement<Key, Obj>> aRootOfSubtree, int aLevel) {
		if (aRootOfSubtree != null) {
			this.inorderRecursively(aRootOfSubtree.left(), aLevel + 1);
			DictionaryElement<Key, Obj> visitedElement = aRootOfSubtree.element();
			this.visitDelegate().visitForSortedOrder( visitedElement.key(), visitedElement.object(), aLevel ) ;
			this.inorderRecursively(aRootOfSubtree.right(), aLevel + 1);
		}
	}

	@Override
	public void scanInReverseOfSortedOrder() {
		this.reverseOfInorderRecursively(this.root(), 1);
	}

	private void reverseOfInorderRecursively(BinaryNode<DictionaryElement<Key, Obj>> aRootOfSubtree, int aLevel) {
		if (aRootOfSubtree != null) { // aRootOfSubtree에 원소가 있으면
			this.reverseOfInorderRecursively(aRootOfSubtree.right(), aLevel + 1); // 좌측으로 이동 (좌측 자식트리로)
			this.visitDelegate().visitForReverseOfSortedOrder(aRootOfSubtree.element().key(), aRootOfSubtree.element().object(), aLevel);
			// aRootOfSubtree의 key와 object를 저장
			this.reverseOfInorderRecursively(aRootOfSubtree.left(), aLevel + 1); // 우측으로 이동 (우측 자식트리)
		}
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
			this.setStack(new LinkedStack<BinaryNode<DictionaryElement<Key, Obj>>>());
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
				BinaryNode<DictionaryElement<Key, Obj>> poppedNode = (BinaryNode<DictionaryElement<Key, Obj>>) this
						.stack().pop();
				DictionaryElement<Key, Obj> nextElement = poppedNode.element();
				this.setNextNode(poppedNode.right());
				return nextElement;
			}
		}
	}

}
