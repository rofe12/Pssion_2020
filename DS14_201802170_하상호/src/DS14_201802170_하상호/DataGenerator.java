package DS14_201802170_하상호;

import java.util.Random;

public final class DataGenerator {

	// 객체 인스턴스를 생성할 수 없게 막아 놓는다.
	private DataGenerator() {
	}

	// 모든 공개 함수는 static

	public static Integer[] ascendingOrderList(int aSize) {
		Integer[] list = null;
		if (aSize > 0) {
			list = new Integer[aSize];
			for (int i = 0; i < aSize; i++) {
				list[i] = i;
			}
		}
		return list;
	}

	// box
	public static Integer[] descendingOrderList(int aSize) {
		Integer[] list = null;
		if (aSize > 0) {
			list = new Integer[aSize];
			for (int i = 0; i < aSize; i++) {
				list[i] = (aSize - i) - 1;
			}
		}
		return list;
	}

	public static Integer[] randomOrderList(int aSize) {
		// 겹치는 원소가 없는 무작위 리스트를 생성하여, 돌려준다.
		Integer[] list = null;
		if (aSize > 0) {
			// 일단 Ascending order list 를 만든다
			list = new Integer[aSize];
			for (int i = 0; i < aSize; i++) {
				list[i] = i;
			}
			// 각 원소 list[i] 에 대해 무작위 위치 r 을 생성하여 list[i] 와 list[r] 를 맞바꾼다.
			Random random = new Random();
			for (int i = 0; i < aSize; i++) {
				int r = random.nextInt(aSize);
				Integer temp = list[i];
				list[i] = list[r];
				list[r] = temp;
			}
		}
		return list;
	}

	public static Integer[] randomListWithoutDuplication(int aSize) {
		// 겹치는 원소가 없는 무작위 리스트를 생성하여, 돌려준다.
		Integer[] list = null;
		if (aSize > 0) {
			// 일단 Ascending order list 를 만든다
			list = DataGenerator.ascendingOrderList(aSize);
			// 각 원소 list[i] 에 대해 무작위 위치 r 을 생성하여 list[i] 와 list[r] 를 맞바꾼다.
			Random random = new Random();
			for (int i = 0; i < aSize; i++) {
				int randomIndex = random.nextInt(aSize);
				Integer temp = list[i];
				list[i] = list[randomIndex];
				list[randomIndex] = temp;
			}
		}
		return list;
	}

}// end of DataGenerator
