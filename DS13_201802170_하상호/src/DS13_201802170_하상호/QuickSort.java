package DS13_201802170_하상호;
public class QuickSort<E extends Comparable<E>> extends Sort<E> {
	public QuickSort() {
	}

	private int pivot(E[] aList, int left, int right) { // 기준점 pivot
		return left; // left 리턴
	}

	private int partition(E[] aList, int left, int right) {
		int pivot = this.pivot(aList, left, right); // 기준점
		int toRight = left; // 우측으로 옮길 원소
		int toLeft = right + 1; // 좌측으로 옮길 원소
		do {
			do {
				toRight++;
			} while (aList[toRight].compareTo(aList[pivot]) < 0); // aList[toRight] < aList[pivot]이면 toRight++
			do {
				toLeft--;
			} while (aList[toLeft].compareTo(aList[pivot]) > 0); // aList[toLeft] > aList[pivot]이면 toLeft--
			if (toRight < toLeft) { // toRight가 toleft보다 작으면
				this.swap(aList, toRight, toLeft); // 위치 변경
			}
		} while (toRight < toLeft); // toRight < toLeft이면 반복
		this.swap(aList, left, toLeft); // left와 toLeft를 맞바꾼다
		return toLeft; // toLeft값 리턴
	}

	private void quickSortRecursively(E[] aList, int left, int right) {
		if (left < right) {
			int mid = partition(aList, left, right);
			quickSortRecursively(aList, left, mid - 1);
			quickSortRecursively(aList, mid + 1, right);
		}
	}

	@Override
	public boolean sort(E[] aList, int aSize) {
		if ((aSize < 1) || (aSize > aList.length)) { // aSize가 유효범위가 아니면
			return false;
		}
		int maxLoc = 0; // 초기 위치
		for (int i = 1; i < aSize; i++) {
			if (aList[i].compareTo(aList[maxLoc]) > 0) { // aList[i]가 더 크면
				maxLoc = i; // maxLoc = i
			}
		}
		this.swap(aList, maxLoc, aSize - 1); // 맨 뒤 원소와 맞바꿈
		this.quickSortRecursively(aList, 0, aSize - 2); // 맨 뒤 원소를 제외하고 반복
		return true;
	}
}
