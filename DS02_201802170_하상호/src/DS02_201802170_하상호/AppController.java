package DS02_201802170_하상호;
//Controller
public class AppController {
	//상수
	private static final int MENU_ADD = 1 ;
	private static final int MENU_REMOVE = 2 ;
	private static final int MENU_SEARCH = 3 ;
	private static final int MENU_FREQUENCY = 4 ;
	private static final int MENU_END_OF_RUN = 9 ;
	
	//비공개 인스턴스 변수들
	private ArrayBag<Coin> _coinBag;
	//생성자
	private ArrayBag<Coin>coinBag() {
		return this._coinBag;
	}
	private void setCoinBag(ArrayBag<Coin> newCoinBag) {
		this._coinBag = newCoinBag;
	}
	
	//공개함수
	//run
	public void run() {
		AppView.outputLine("<<< 동전 가방 프로그램을 시작합니다. >>>>");
		AppView.outputLine("");
		
		int coinBagSize = AppView.inputCapacityOfCoinBag();
		this.setCoinBag(new ArrayBag<Coin> (coinBagSize));
		
		int menuNumber = AppView.inputMenuNumber();
		while( menuNumber != MENU_END_OF_RUN) {
			switch(menuNumber) {
			case MENU_ADD:
				this.addCoin();
				break;
			case MENU_REMOVE:
				this.removeCoin();
				break;
			case MENU_SEARCH:
				this.searchForCoin();
				break;
			case MENU_FREQUENCY:
				this.frequencyOfCoin();
				break;
			default:
				this.undefinedMenuNumber(menuNumber);
				
			}
			menuNumber = AppView.inputMenuNumber();
		}
		this.showStatistics();
		AppView.outputLine("<<< 동전 가방 프로그램을 종료합니다. >>>");
	}
	
	// 비공개 함수의 구현
	//Appview 를 이용한 입출력
	private void addCoin() {
		if ( this.coinBag().isFull()){
			AppView.outputLine("- 동전 가방이 꽉 차서 동전을 넣을 수 없습니다.") ;
			}
			else {
			int coinValue = AppView.inputCoinValue();
			if ( this.coinBag().add(new Coin(coinValue))) {
			AppView.outputLine("- 주어진 값을 갖는 동전을 가방에 성공적으로 넣었습니다.") ;
			}
			else {
			AppView.outputLine("- 주어진 값을 갖는 동전을 가방에 넣는데 실패하였습니다.") ;
			}
		}
	}//remove
	private void removeCoin () {
		int coinValue = AppView.inputCoinValue();
		if (!this.coinBag().remove(new Coin(coinValue))) {
		AppView.outputLine("- 주어진 값을 갖는 동전은 가방 안에 존재하지 않습니다.");
		}
		else {
		AppView.outputLine("- 주어진 값을 갖는 동전 하나가 가방에서 정상적으로 삭제되었습니다.");
		}
	}
	//Search
	private void searchForCoin () {
		int coinValue = AppView.inputCoinValue();
		if(this.coinBag().doesContain (new Coin(coinValue))) {
		AppView.outputLine("- 주어진 값을 갖는 동전이 가방 안에 존재합니다.");
		}
		else {
		AppView.outputLine("- 주어진 값을 갖는 동전은 가방 안에 존재하지 않습니다.");
		}
	}
	//Frequency
	private void frequencyOfCoin() {
		int coinValue = AppView.inputCoinValue();
		int frequency = this.coinBag().frequencyOf(new Coin(coinValue));
		AppView.outputLine("- 주어진 값을 갖는 동전의 개수는 " + frequency + " 개 입니다.") ;
	}
	//오류처리
	private void undefinedMenuNumber (int menuNumber) {
		AppView.outputLine("- 선택된 메뉴 번호 " + menuNumber + " 는 잘못된 번호입니다." );
	}
	//코인의 합, 가장큰값 츨력
	private int sumOfCoinValues() {
		int sum = 0;
		for (int i = 0; i < this.coinBag().size(); i++) {
		sum += this.coinBag().elementAt(i).value();
		}
		return sum;
		}
		private int maxCoinValue() {
		int maxValue = 0;
		for (int i = 0; i < this.coinBag().size(); i++) {
		if (maxValue < this.coinBag().elementAt(i).value()) {
		maxValue = this.coinBag().elementAt(i).value();
			}
		}
		return maxValue;
		}
	private void showStatistics() {
		AppView.outputLine("가방에 들어 있는 동전의 개수: " + this.coinBag().size());
		AppView.outputLine("동전 중 가장 큰 값: " + this.maxCoinValue());
		AppView.outputLine("모든 동전 값의 합:" + this.sumOfCoinValues());
	}
	

}//End of class "APPController"
