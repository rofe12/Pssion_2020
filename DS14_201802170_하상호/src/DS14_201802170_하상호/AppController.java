package DS14_201802170_하상호;

public class AppController implements VisitDelegate<Integer, Integer> {
	private static final int DAFAULT_DATA_SIZE = 10;

	private Dictionary<Integer, Integer> _dictionary;
	private Integer[] _list;

	private Dictionary<Integer, Integer> dictionary() {
		return this._dictionary;
	}

	private void setDictionary(Dictionary<Integer, Integer> newDictionary) {
		this._dictionary = newDictionary;
	}

	private Integer[] list() {
		return this._list;
	}

	private void setList(Integer[] newList) {
		this._list = newList;
	}

	@Override
	public void visitForSortedOrder(Integer aKey, Integer anObj, int aLevel) {
		AppView.outputLine(String.format("%3d (%2d)", aKey, anObj));

	}

	@Override
	public void visitForReverseOfSortedOrder(Integer aKey, Integer anObj, int aLevel) {
		if (aLevel == 1) {
			AppView.output(String.format("%7s", "Root: "));
		} else {
			AppView.output(String.format("%7s", ""));
		}
		for (int i = 1; i < aLevel; i++) {
			AppView.output(String.format("%7s", ""));
		}
		AppView.outputLine(String.format("%3d (%2d)", aKey, anObj));
	}

	private void showDictionary(String aTitlePrefix) {
		AppView.outputLine("> " + aTitlePrefix + "이진검색트리 사전:");
		if (this.dictionary().isEmpty()) {
			AppView.outputLine(" Empty");
		} else {
			this.dictionary().scanInReverseOfSortedOrder();
		}
		AppView.outputLine("");
	}

	private void addToDictionaryAndShowShape() {
		AppView.outputLine("[삽입 과정에서의 이진검색트리 사전의 변화]");
		this.showDictionary("삽입을 시작하기 전의");
		for (int i = 0; i < this.list().length; i++) {
			Integer currentKey = this.list()[i];
			Integer currentObj = Integer.valueOf(i);
			this.dictionary().addKeyAndObject(currentKey, currentObj);
			this.showDictionary(String.format("Key=%d (Object=%d) 원소를 삽입한 후의", currentKey, currentObj));
		}
	}

	private void removeFromDictionaryAndShowShape() {
		AppView.outputLine("[삭제 과정에서의 이진검색트리 사전의 변화]");
		this.showDictionary("삭제를 시작하기 전의");
		for (int i = 0; i < this.list().length; i++) {
			Integer currentKey = this.list()[i];
			Integer currentObj = this.dictionary().removeObjectForKey(currentKey);
			this.showDictionary(String.format("Key=%d (Object=%d) 원소를 삭제한 후의", currentKey, currentObj));
		}
	}

	private void showDictionaryInSortedOrderByCallBack() {
		AppView.outputLine("[\"Call Back\" 을 사용하여 보여준 사전의 내용]");
		this.dictionary().scanInSortedOrder();
		AppView.outputLine("");
	}

	private void showDictionaryInSortedOrderByIterator() {
		AppView.outputLine("[\"Iterator\" 를 사용하여 보여준 사전의 내용]");
		Iterator<DictionaryElement<Integer, Integer>> iterator = this.dictionary().iterator();
		while (iterator.hasNext()) {
			DictionaryElement<Integer, Integer> DictionaryElement = iterator.next();
			AppView.outputLine(String.format("%3d (%2d)", DictionaryElement.key(), DictionaryElement.object()));
		}
		AppView.outputLine("");
	}

	public void run() {
		AppView.outputLine("<<< 이진검색트리로 구현된 사전에서의 삽입과 삭제 >>>");
		AppView.outputLine("");
		this.setDictionary(new DictionaryByBinarySearchTree<Integer, Integer>());
		this.dictionary().setVisitDelegate(this);
		this.setList(DataGenerator.randomListWithoutDuplication(DAFAULT_DATA_SIZE));
		this.addToDictionaryAndShowShape();
		this.showDictionaryInSortedOrderByCallBack();
		this.showDictionaryInSortedOrderByIterator();
		this.setList(DataGenerator.randomListWithoutDuplication(DAFAULT_DATA_SIZE));
		this.removeFromDictionaryAndShowShape();
		AppView.outputLine("<<< 종료 >>>");
	}

}