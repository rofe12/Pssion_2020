package DS02_201802170_하상호;

//Generic Calss

public class ArrayBag<E> {
	//모든 ArrayBag 객체에서 공통으로 사용
	private static final int DEFAULT_CAPACITY = 100;
	//비공개 인스턴수 변수
	private int _capacity;
	private int _size;
	private E[] _element; // ArrayBag의 원소들을 담을 java 배열
	
	//인스턴스 변수의 Getter / Setter
	//비공개 함수
	//class 내부에서만 사용
	
	private int capacity() {
		return this._capacity;
	}
	private void setCapacity(int newCapacity) {
		this._capacity = newCapacity;
	}
	private void setSize(int newSize) {
		this._size = newSize;
	}
	private E[] elements() {
		return this._element;
	}
	private void setElements(E[] newElements) {
		this._element = newElements;
	}
	
	   
	//생성자
	//generic type 을 사용하기에 E 와 Object 가 맞는지 물어본다.
	//때문에 Overiding "unchecked" 하여 넘어가도록함
	@SuppressWarnings("unchecked")
	public ArrayBag() {
		this.setCapacity(ArrayBag.DEFAULT_CAPACITY);
		this.setElements((E[]) new Object [this.capacity()] );
		this.setSize(0);	
	}
	
	@SuppressWarnings("unchecked")
	public ArrayBag(int givenCapacity) {
		this.setCapacity(givenCapacity);
		this.setElements((E[]) new Object [this.capacity()] );
		this.setSize(0);
	} 
	
	//공개함수
	public int size() {
		return this._size;
		//_size를 반환
	}
	public boolean isEmpty() {
		return (this._size == 0);
		//_size 가 0인지 확인
		//가방이 비어있는지 확인
	}
	public boolean isFull() {
		return (this._size == this.capacity());
	//_size 가 _capacity 와 같은지 확인
	//가방이 꽉차 있는지 확인
	}
	
	public boolean doesContain(E anElement) {
		boolean found = false;
		  for (int i = 0; i < _size; i++) {
	            if (this._element[i].equals(anElement)) 
	            	return true;
	        }
		return found;
		//anElement 와 _element 의 내용이 같은지 확인
	}
	public int frequencyOf(E anElement) {
		int frequencyCount = 0;
			for(int i = 0; i < this._size; i++){
				if(this._element[i].equals(anElement))
                frequencyCount++;
		}
		return frequencyCount;
		//anElement 와 _element 의 내용이 같은지 확인
		//같다면 frequenyCount ++
	}
	public boolean add(E anElemnet) {
		if(this.isFull() == true) {
			return false;
		}
		else {
			this.elements()[this.size()] = anElemnet;
			this.setSize(this.size()+1);
			return true;
		}//배열 추가
		
	}
	public boolean remove(E anElement) {
		int removeCount = 0;
		//비어있는 경우
		if(this.isEmpty()) {
			return false;
		}
		else
		//해당값이 존재하지 않은 경우
		if(! this.doesContain(anElement)) {
			return false;
		}
		//해당 값을 가진 가장작은 배열의 위치 학인
			for(int count = 0; count < this._size; count++) {
				if(this._element[count].equals(anElement)) {
					removeCount= count;
					break;
				}
			}
			//삭제
			while(removeCount == this._size -1) {
				this.elements()[removeCount] = this.elements()[removeCount+1];
				removeCount ++;
			}
			//삭제 후 처리
			this._size --;
			this._element[this._size] = null;
			return true;
		//배열 삭제
	}
	public void clear() {
		this._size = 0;
	//_size 초기화
	}
	public E elementAt (int order) {
		if((0 <= order) && (order < this.size())) {
			return this.elements()[order];
		}
		else {
			return null;
		}
		//해당 위치를 갖는 원소를 출력
	}
}	//End of "ArrayBag"
