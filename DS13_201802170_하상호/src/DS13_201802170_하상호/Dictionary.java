package DS13_201802170_하상호;

public abstract class Dictionary<Key extends Comparable<Key>, Obj extends Comparable<Obj>> {
	// Instance variable
	private int _size; // "private" 임에 유의. 상속 받는 class 에서는 getter/setter 를 통해서만 접근한다.
	// Getter/Setter

	public int size () {
		return this._size;
	}

	protected void setSize (int newSize) {
		this._size = newSize;
	}

	// Constructors
	public Dictionary() {
		this.setSize(0); // 상속받는 class 의 생성자는 암묵적으로 상위 class의 생성자를 call 한다는 것을 잊지 말 것!
	}

	// Public non-abstract method: 이 class 에서 구현되어야 한다.
	public boolean isEmpty () {
		return (this._size == 0	);
	}

	// Public abstract methods
	public abstract boolean isFull();

	public abstract boolean keyDoesExist(Key aKey);

	public abstract Obj objectForKey(Key aKey);

	public abstract boolean addKeyAndObject(Key aKey, Obj anObject);

	public abstract Obj removeObjectForKey(Key aKey);

	public abstract void clear();

	public abstract Iterator<DictionaryElement<Key,Obj>> iterator() ;
} // End of class "Dictionary"
