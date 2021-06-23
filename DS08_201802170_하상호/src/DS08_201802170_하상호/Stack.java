package DS08_201802170_«œªÛ»£;
//interface Stack
public interface Stack<E> {
	
	public int size();
	public boolean isFull();
	public boolean isEmpty();
	public boolean push(E anElement);
	public E pop();
	public E peek();
	public void clear();

}//End of Stack
