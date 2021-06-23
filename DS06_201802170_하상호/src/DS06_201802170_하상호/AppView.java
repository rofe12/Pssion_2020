package DS06_201802170_하상호;

//View class
public class AppView {

	// 생성자 : 객체를 생성할 일이 없음
	// 객체를 생성할 일이 없어도 일반 생성자를 표현해줌
	private AppView() {

	}
	// 공개함수의 구현

	public static void output(String message) {
		System.out.print(message);
	}

	public static void outputLine(String message) {
		System.out.println(message);
	}
	
	public static void outputResults(int size, long durationForAdd, long durationForMax)
	{
		AppView.outputLine(
			"[크기: " + String.format("%5d", size) + "] " +
			"삽입:  " + String.format("%8d", durationForAdd) + ", " +
			"최대값: " + String.format("%8d", durationForMax)		
				);
	}
}// End of Class"AppView"
