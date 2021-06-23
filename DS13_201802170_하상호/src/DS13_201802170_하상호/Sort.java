package DS13_201802170_하상호;
public abstract class Sort<E extends Comparable<E>>  {
	protected void swap(E[] aList, int i, int j) {	// 원소값 변경
		E tempElement = aList[i];	// i의 값을 tempElement에 저장
		aList[i] = aList[j];	// j의 값을 i에 저장
		aList[j] = tempElement;	// tempElement값을 j에 저장
	}
	
	protected Sort() {	// 생성자
	}
	
	public abstract boolean sort(E[] aList, int aSize);
}
