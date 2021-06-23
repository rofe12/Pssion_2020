package DS09_201802170_하상호;

import java.util.Scanner;

//View class
public class AppView {
	// private constant / intance values
	private static Scanner scanner = new Scanner(System.in);
	private static boolean debugMode = false;

	// 생성자 : 객체를 생성할 일이 없음
	// 객체를 생성할 일이 없어도 일반 생성자를 표현해줌
	private AppView() {
	}

	// 공개함수의 구현
	public static boolean debugMode() {
		return debugMode;
	}

	public static void setDebugMode(boolean newDebugMode) {
		debugMode = newDebugMode;
	}

	public static void outputDebugMessage(String aMessage) {
		if (AppView.debugMode()) {
			System.out.print(aMessage);
		}
	}

	public static void outputLineDebugMessage(String aMessage) {
		if (AppView.debugMode()) {
			System.out.println(aMessage);
		}
	}

	public static void output(String message) {
		System.out.print(message);
	}

	public static void outputLine(String message) {
		System.out.println(message);
	}

	public static String inputLine() {
		String line = AppView.scanner.nextLine().trim();
		while (line.equals("")) {
			line = AppView.scanner.nextLine().trim();
		}
		return line;
	}

}// End of Class"AppView"
