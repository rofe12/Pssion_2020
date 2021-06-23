package DS10_1_201802170_하상호;

import java.util.Scanner;

//View class
public class AppView {
	// private constant / intance values
	private static Scanner scanner = new Scanner(System.in);

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

	public static char inputChar() { // 문자열 입력
		String line = AppView.scanner.nextLine().trim();
		while (line.equals("")) {
			line = AppView.scanner.nextLine().trim();
		}
		return line.charAt(0);
	}

}// End of Class"AppView"
