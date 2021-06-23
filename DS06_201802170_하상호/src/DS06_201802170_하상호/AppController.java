package DS06_201802170_하상호;
// AppController

public class AppController {
	// private instance variable
	private Experiment _experiment;

	// Getters / Setters
	private Experiment experiment() {
		return this._experiment;
	}

	private void setExperiment(Experiment newExperiment) {
		this._experiment = newExperiment;
	}

	// constructor
	public AppController() {
		this.setExperiment(new Experiment());
		// 실험 객체에게 성능 측정에 사용할 데이터를 생성하게 한다.
		this.experiment().generateData();
	}

	// private method
	private void showExperimentResults() {
		MeasuredResult[] results = this.experiment().measuredResults();
		for (int i = 0; i < this.experiment().numberOfIteration(); i++) {
			AppView.outputResults(results[i].size(), results[i].durationForAdd() / 1000, // Nano 를 Micro 로 변환
					results[i].durationForMax() / 1000 // Nano 를 Micro 로 변환
			);
		}
	}

	// public method
	public void run() {
		AppView.outputLine("<<<리시트 성능 측정 프로그램을 시작합니다.>>>");
		AppView.outputLine("! 리스트의 구현에 따라 시간의 차이를 알아봅니다: (단위 : Micro Second)");

		// UnSorted Array List 에 대한 추정
		AppView.outputLine("");
		AppView.outputLine("<UnSorted Array List>");
		// 실험 객체에게 "UnSortedArrayList" 에 대한 성능 측정을 실행하게 한다.
		this.experiment().measureForUnSortedArrayList();
		// 실험 결과 출력
		this.showExperimentResults();

		// Sorted Array List 에 대한 추정
		AppView.outputLine("");
		AppView.outputLine("<Sorted Array List>");
		// 실험 객체에게 "SortedArrayList" 에 대한 성능 측정을 실행하게 한다.
		this.experiment().measureForSortedArrayList();
		// 실험 결과 출력
		this.showExperimentResults();

		// UnSorted Linked List 에 대한 추정
		AppView.outputLine("");
		AppView.outputLine("<UnSorted Linked List>");
		// 실험 객체에게 "UnSortedLinkedList" 에 대한 성능 측정을 실행하게 한다.
		this.experiment().measureForUnSortedLinkedList();
		// 실험 결과 출력
		this.showExperimentResults();

		// Sorted Array List 에 대한 추정
		AppView.outputLine("");
		AppView.outputLine("<Sorted Linked List>");
		// 실험 객체에게 "SortedLinkedList" 에 대한 성능 측정을 실행하게 한다.
		this.experiment().measureForSortedLinkedList();
		// 실험 결과 출력
		this.showExperimentResults();

		AppView.outputLine("<<<리스트 성능 측정 프로그램을 종료합니다.>>>");

	}

}// End of class "AppController"
