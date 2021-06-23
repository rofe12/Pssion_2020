package DS12_201802170_하상호;

public class AppController {

	private ExperimentManager _manager;

	private ExperimentManager manager() {
		return this._manager;
	}

	private void setManager(ExperimentManager newManager) {
		this._manager = newManager;
	}

	public AppController() {
		this.setManager(new ExperimentManager());
	}

	private void showTableTitle(ListOrder anOrder) {
		AppView.outputLine("> " + anOrder.orderName() + " 데이터를 사용하여 실행한 측정:");
	}

	private void showTableHead() {
		AppView.outputLine(String.format("%8s", " ") + String.format("%16s", "<Insertion Sort>")
				+ String.format("%16s", "<Quick Sort>"));
	}

	private void showTableContent() {
		int startingSize = this.manager().parameterSet().startingSize();
		int incrementSize = this.manager().parameterSet().incrementSize();
		int numberOfSteps = this.manager().parameterSet().numberOfSizeIncreasingSteps();
		for (int step = 0; step < numberOfSteps; step++) {
			int sortingSize = startingSize + (incrementSize * step);
			AppView.outputLine("[" + String.format("%5d", sortingSize) + "]"
					+ String.format("%16d", this.manager().measuredResultForInsertionSortAt(step))
					+ String.format("%16d", this.manager().measuredResultForQuickSortAt(step)));
		}
	}

	private void showResultTable(ListOrder anOrder) {
		// 주어진 anOrder 에 대하여, 성능 측정 결과를 보여준다.
		this.showTableTitle(anOrder);
		this.showTableHead();
		this.showTableContent();
		AppView.outputLine("");
	}

	private void measureAndShowFor(ListOrder anOrder) {
		this.manager().performExperiment(anOrder);
		this.showResultTable(anOrder);
	}

	public void run() {
		AppView.outputLine("<<<정렬 성능 비교 프로그램을 시작합니다 >>>");
		AppView.outputLine("");
		{
			AppView.outputLine(">> 2 가지 정렬의 성능 비교: 삽입, 퀵 <<");
			this.manager().prepareExperiment(null);
			// ExperimentManager 객체에게 실험을 준비시킨다.
			// 이번 실험에서는 매개변수 값으로 기본 설정 값을 사용한다.
			// 기본 설정 값은 Class "ExperimentManager" 에 설정되어 있다.
			this.measureAndShowFor(ListOrder.Ascending);
			this.measureAndShowFor(ListOrder.Descending);
			this.measureAndShowFor(ListOrder.Random);
		}
		AppView.outputLine("<<< 정렬 성능 비교 프로그램을 종료합니다 >>>");

	}
}