package DS10_1_201802170_하상호;

public class AppController {
	// 상수
	private static final int QUEUE_CAPACITY = 5;
	// 비공개 변수들
	private Queue<Character> _queue;
	private int _inputChars; // 입력된 문자의 개수
	private int _pushedChars; // 삽입된 문자의 개수
	private int _ignoredChars; // 무시된 문자의 개수

	// Getters/Setters
	private Queue<Character> queue() {
		return this._queue;
	}

	private void setQueue(Queue<Character> newQueue) {
		this._queue = newQueue;
	}

	private int inputChars() {
		return this._inputChars;
	}

	private void setInputChars(int newInputChars) {
		this._inputChars = newInputChars;
	}

	private int pushedChars() {
		return this._pushedChars;
	}

	private void setPushedChars(int newPushedChars) {
		this._pushedChars = newPushedChars;
	}

	private int ignoredChars() {
		return this._ignoredChars;
	}

	private void setIgnoredChars(int newIgnoredChars) {
		this._ignoredChars = newIgnoredChars;
	}

	// 생성자
	public AppController() {
		this.setQueue(new CircularArrayQueue<Character>(AppController.QUEUE_CAPACITY));
		this.setInputChars(0);
		this.setPushedChars(0);
		this.setIgnoredChars(0);
	}

	// 비공개 함수
	// 횟수 계산
	private void countInputChar() {
		this.setInputChars(this.inputChars() + 1);
	}

	private void countIgnoredChar() {
		this.setIgnoredChars(this.ignoredChars() + 1);
	}

	private void countAddedChar() {
		this.setPushedChars(this.pushedChars() + 1);
	}

	//큐 수행 관련
	private void addToQueue(char aCharForAdd) {
		if (this.queue().isFull())
			AppView.outputLine("[EnQ.Empty] 큐가 꽉 차서 더 이상 넣을 수가 없습니다.");
		else {
			this.queue().enQueue(Character.valueOf(aCharForAdd));
			AppView.outputLine("[EnQ] 삽입된 원소는 '" + aCharForAdd + "' 입니다.");
		}
	}

	private void removeOne() {
		if (this.queue().isEmpty())
			AppView.outputLine("[DeQ.Empty] 큐에 삭제할 원소가 없습니다.");
		else {
			Character removedChar = this.queue().deQueue();
			if (removedChar == null)
				AppView.outputLine("(오류) 큐에서 삭제하는 동안에 오류가 발생했습니다.");
			else
				AppView.outputLine("[DeQ] 삭제된 원소는 '" + removedChar + "' 입니다.");
		}
	}

	private void removeN(int numberOfCharsToBeRemoved) {
		if (numberOfCharsToBeRemoved == 0)
			AppView.outputLine("[DeQs] 삭제할 원소의 개수가 0개 입니다.");

		for (int i = 0; i < numberOfCharsToBeRemoved; i++) {
			if (this.queue().isEmpty()) {
				AppView.outputLine("[DeQ.Empty] 큐에 삭제할 원소가 없습니다.");
				break;
			} else {
				Character removedChar = this.queue().deQueue();
				if (removedChar == null)
					AppView.outputLine("(오류) 큐에서 삭제하는 동안에 오류가 발생했습니다.");
				else
					AppView.outputLine("[DeQ] 삭제된 원소는 '" + removedChar + "' 입니다.");
			}
		} // end of for
	}

	private void quitQueueProcessing() {
		// 프로그램 종료시
		AppView.outputLine("< 큐를 비우고 사용을 종료합니다 >");
		showAllFromFront();
		removeN(this.queue().size());
	}


	//출력 관련
	private void showAllFromFront() {
		// 큐의 모든 원소를 Front부터 Rear까지 출력
		AppView.output("[Queue] <Front> ");
		Iterator<Character> queueIterator = this.queue().iterator();
		while (queueIterator.hasNext()) {
			Character element = queueIterator.next();
			AppView.output(element.toString() + " ");
		}
		AppView.outputLine("<Rear>");
	}

	private void showAllFromRear() {
		// 큐의 모든 원소를 Rear부터 Front까지 출력
		AppView.output("[Queue] <Rear> ");
		for (int order = this.queue().size() - 1; order >= 0; order--) {
			AppView.output(this.queue().elementAt(order).toString() + " ");
		}
		AppView.outputLine("<Front>");
	}

	private void showFrontElement() {
		// Front 원소 출력
		if (this.queue().isEmpty())
			AppView.outputLine("[Front.Empty] 큐가 비어서 맨 앞 원소가 존재하지 않습니다.");
		else
			AppView.outputLine("[Front] 큐의 맨 앞 원소는 '" + this.queue().front() + "' 입니다.");
	}

	private void showRearElement() {
		// Rear 원소 출력
		if (this.queue().isEmpty())
			AppView.outputLine("[Rear.Empty] 큐가 비어서 맨 뒤 원소가 존재하지 않습니다.");
		else
			AppView.outputLine("[Rear] 큐의 맨 뒤 원소는 '" + this.queue().rear() + "' 입니다.");
	}

	private void showQueueSize() {
		// 큐의 크기 출력
		AppView.outputLine("[Size] 큐에는 현재 " + this.queue().size() + "개의 원소가 있습니다.");
	}

	private void showStatistics() {
		AppView.outputLine("");
		AppView.outputLine("<큐 사용 통계>");
		AppView.outputLine("- 입력된 문자는 " + this.inputChars() + " 개 입니다.");
		AppView.outputLine("- 정상 처리된 문자는 " + (this.inputChars() - this.ignoredChars()) + " 개 입니다.");
		AppView.outputLine("- 무시된 문자는 " + this.ignoredChars() + "개 입니다.");
		AppView.outputLine("- 삽입된 문자는 " + this.pushedChars() + "개 입니다.");
	}

	// 입력 관련
	// 문자 입력
	private char inputChar() {
		AppView.output("? 문자를 입력하시오: ");
		return AppView.inputChar();
	}

	public void run() {
		AppView.outputLine("<<< 큐 기능 확인 프로그램을 시작합니다 >>>");
		AppView.outputLine("");

		char input = this.inputChar();
		while (input != '!') {
			this.countInputChar();
			if (Character.isAlphabetic(input)) {
				this.addToQueue(input);
				this.countAddedChar();
			} else if (Character.isDigit(input))
				this.removeN(Character.getNumericValue(input));
			else if (input == '-')
				this.removeOne();
			else if (input == '#')
				this.showQueueSize();
			else if (input == '/')
				this.showAllFromFront();
			else if (input == '\\')
				this.showAllFromRear();
			else if (input == '<')
				this.showFrontElement();
			else if (input == '>')
				this.showRearElement();
			else {
				AppView.outputLine("[Ignore] 의미 없는 문자가 입력되었습니다.");
				this.countIgnoredChar();
			}
			input = this.inputChar();
		}
		this.quitQueueProcessing();

		this.showStatistics();
		AppView.outputLine("");
		AppView.outputLine("<<< 큐 기능 확인 프로그램을 종료합니다 >>>");
	}

}// end of AppController
