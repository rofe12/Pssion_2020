package DS05_201802170_하상호;

import java.util.Scanner;

//View class
public class AppView {
	// 비공개 상수/변수들
	private static Scanner scanner = new Scanner(System.in);

	// 생성자 : 객체를 생성할 일이 없음
	// 객체를 생성할 일이 없어도 일반 생성자를 표현해줌
	private AppView() {

	}

	// 공개함수의 구현
	public static void outputDebugMessage(String message) {
		System.out.print(message);
	}

	public static void output(String message) {
		System.out.print(message);
	}

	public static void outputLine(String message) {
		System.out.println(message);
	}

	public static int inputInteger() throws NumberFormatException {
		// 정수가 아닌 경우의 에러 처리를 보완할것 : exception throws
		return Integer.parseInt(AppView.scanner.next());
	}

}// End of Class"AppView"
