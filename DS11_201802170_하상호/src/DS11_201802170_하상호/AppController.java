package DS11_201802170_하상호;

public class AppController {
	// 상수
	private static final int TEST_SIZE = 10000;
	private static final int FIRST_PART_SIZE = 5;
	private static final InsertionSort<Integer> INSERTION_SORT = new InsertionSort<Integer>();
	private static final QuickSort<Integer> QUICK_SORT = new QuickSort<Integer>();
	// 비공개 변수들
	private Integer[] _list;
	private ListOrder _listOrder;

	// Getters/Setters
	private Integer[] list() {
		return this._list;
	}

	private void setList(Integer[] newList) {
		this._list = newList;
	}

	private ListOrder listOrder() {
		return this._listOrder;
	}

	private void setListOrder(ListOrder newListOrder) {
		this._listOrder = newListOrder;
	}

	// 생성자
	public AppController() {
	}

	// 비공개함수의 구현
	private void validateWithAscendingOrderList() {
		this.setListOrder(ListOrder.Ascending);
		this.setList(DataGenerator.ascendingOrderList(AppController.TEST_SIZE));
		this.showFirstPartOfDataList();
		this.validateSortsAndShowResult();
	}

	private void validateWithDescendingOrderList() {
		this.setListOrder(ListOrder.Descending);
		this.setList(DataGenerator.descendingOrderList(AppController.TEST_SIZE));
		this.showFirstPartOfDataList();
		this.validateSortsAndShowResult();
	}

	private void validateWithRandomOrderList() {
		this.setListOrder(ListOrder.Random);
		this.setList(DataGenerator.randomOrderList(AppController.TEST_SIZE));
		this.showFirstPartOfDataList();
		this.validateSortsAndShowResult();
	}

	// box
	private void showFirstPartOfDataList() {
		AppView.output("[" + this.listOrder().orderName() + " 리스트] 의 앞 부분: ");
		for (int i = 0; i < 5; i++) {
			AppView.output(this.list()[i] + " ");
		}
		AppView.outputLine("");
	}

	private void validateSortsAndShowResult() {
		this.validateSort(AppController.INSERTION_SORT);
		this.validateSort(AppController.QUICK_SORT);
		AppView.outputLine("");
	}

	private void validateSort(Sort<Integer> aSort) {
		Integer[] list = this.copyList(this._list);
		// 동일한 리스트로 여러 번 (실제로는 2 번) 정렬하게 된다.
		// 매번 원본 리스트를 복사하여 정렬한다.
		aSort.sort(list, list.length);
		this.showValidationMessage(aSort, list);
	}

	private Integer[] copyList(Integer[] aList) {
		// 주어진 배열 객체 aList[] 의 복사본을 만들어 돌려준다.
		// aList[] 자체는 복사하지만,
		// 배열의 원소 객체 자체는 복사하지 않고 공유한다.
		Integer[] copiedList = new Integer[aList.length];
		copiedList = aList;

		return copiedList;
	}

	private boolean sortedListIsValid(Integer[] aList) {
		// 주어진 aList 의 원소들이 오름차순으로 되어 있으면 true 를 돌려준다.
		for (int i = 0; i < (aList.length - 1); i++) {
			if (aList[i].compareTo(aList[i + 1]) > 0) {
				return false; // 오름차순이 아닌 순서를 발견
			}
		}
		return true; // 리스트 전체가 오름차순으로 되어 있다.
	}

	private void showValidationMessage(Sort<Integer> aSort, Integer[] aList) {
		AppView.output("[" + this.listOrder().orderName() + " 리스트]를 [" + aSort.getClass().getSimpleName() + "] 한 결과는 ");
		if (this.sortedListIsValid(aList)) {
			AppView.outputLine("올바릅니다.");
		} else {
			AppView.outputLine("올바르지않습니다.");
		}
	}

	// 공개함수의 구현
	public void run() {
		AppView.outputLine("<<< 정렬 알고리즘의 정렬 결과를 검증하는 프로그램을 시작합니다 >>>");
		AppView.outputLine("");
		AppView.outputLine("> 정렬 결과의 검증:");
		AppView.outputLine("");
		this.validateWithAscendingOrderList();
		this.validateWithDescendingOrderList();
		this.validateWithRandomOrderList();
		AppView.outputLine("<<< 정렬 알고리즘의 정렬 결과를 검증하는 프로그램을 종료합니다 >>>");
	}

} // End of class “AppController”
