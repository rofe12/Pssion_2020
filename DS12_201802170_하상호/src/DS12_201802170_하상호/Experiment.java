package DS12_201802170_하상호;

public class Experiment {
	// 정렬 성능 측정 실험 샐행

	// private Instance variables
	private final ParameterSet _parameterSet;
	// 객체를 생성할 때 정해진 값을 그대로 유지

	// private
	private ParameterSet parameterSet() {
		return this._parameterSet;
	}

	public Experiment(ParameterSet givenParameterSet) {
		this._parameterSet = givenParameterSet;
	}

	// Private methods
	private Integer[] copyListOfGivenSize(Integer[] aList, int copiedSize) {
		Integer[] copiedList = null;
		if (copiedSize <= aList.length) {
			copiedList = new Integer[copiedSize];
			for (int i = 0; i < copiedSize; i++) {
				copiedList[i] = aList[i];
			}
		}
		return copiedList;
	}

	private long durationOfSingleSort(Sort<Integer> aSort, Integer[] aList) {
		Timer timer = new Timer();
		timer.start();
		{
			aSort.sort(aList, aList.length);
		}
		timer.stop();
		return timer.duration();
	}

	public long[] durationsOfSort(Sort<Integer> aSort, Integer[] experimentList) {
		// 정렬 방법이 매개변수로 주어져 있음에 유의할 것: Class "Sort" 를 볼 것
		int numberOfSteps = this.parameterSet().numberOfSizeIncreasingSteps();// 크기 별로 실행할 측정 횟수
		long[] durations = new long[numberOfSteps]; // 측정 결과를 저장할 곳
		int sortingSize = this.parameterSet().startingSize(); // 정렬 데이터의 시작 크기
		int incrementSize = this.parameterSet().incrementSize(); // 정렬 데이터 증가 크기

		for (int step = 0; step < numberOfSteps; step++) {
			Integer[] listForSorting = this.copyListOfGivenSize(experimentList, sortingSize);
			// 측정에 사용할 데이터 리스트 복사
			durations[step] = this.durationOfSingleSort(aSort, listForSorting);
			// 측정하여, 그 결과를 저장
			sortingSize += incrementSize; // 다음 단계의 정렬 데이터 크기를 얻는다
		}
		return durations;
	}

}
