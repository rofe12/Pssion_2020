package DS14_201802170_«œªÛ»£;

public interface VisitDelegate<Key, Obj> {
	public void visitForReverseOfSortedOrder
	(Key key, Obj object, int aLevel);
	public void visitForSortedOrder
	(Key key, Obj object, int aLevel);
	
	
}