package DS10_2_201802170_하상호;

public interface Queue<E> {
	//반드시 필요한 method
	public int size();
	public boolean isFull();
	public boolean isEmpty();
	
	public E front();
	public E rear();
	
	public boolean enQueue(E anElement);
	public E deQueue();
	
	public void clear();
	
	//편의성을 위한 method
	public E elementAt(int anOrder);
	public Iterator<E> iterator();
}
