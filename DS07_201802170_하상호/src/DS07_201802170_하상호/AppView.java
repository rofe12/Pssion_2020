package DS07_201802170_하상호;

import java.util.Scanner;

//View class
public class AppView {
	//private constant / intance values
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
	//출력을 위한 함수
	public static void outputNumberOfStudents (int aNumberOfStudents) {
		AppView.outputLine("학급 학생 수:" + aNumberOfStudents);
	}//학급 학생 수 출력
	public static void outputHighestScore (int aScore) {
		AppView.outputLine("학급 최고 점수: " + aScore);
	}//학급 최고 점수 출력
	public static void outputLowestScore (int aScore) {
		AppView.outputLine("학급 최저 점수: " + aScore);
	}// 최저점 출력
	public static void outputAverageScore (double anAverageScore) {
		AppView.outputLine("학급 평균: " + anAverageScore);
	}//평균값을 출력
	public static void outputNumberOfStudentsAboveAverage (int aNumberOfStudents) {
		AppView.outputLine("평균 이상인 학생 수: " + aNumberOfStudents);
	}// 평균 이상인 학생 수 출력
	public static void outputNumberOfStudentsForGrade (char aGrade, int aNumberOfStudents) {
		AppView.outputLine(aGrade + " 학점의 학생 수는 " + aNumberOfStudents + " 입니다.");
	}//각 학점에 대한 학생 수 출력
	public static void outputScore (int aScore) {
		AppView.outputLine("점수:   " + aScore);
	}//학생들의 점수 출력
	
	//입력을 위한 함수
	public static int inputInt () throws NumberFormatException  {
		return Integer.parseInt(AppView.scanner.nextLine());
	}
	public static int inputScore() {
		while(true) {
			try {
				AppView.output("- 점수를 입력하시오 (0..100): ");
				int score = AppView.inputInt();
				return score;
			} catch ( NumberFormatException e) {
				AppView.outputLine("(오류) 정수가 입력되지 않았습니다.");
			}
		}
		
	}
	//입력 여부 method
	public static boolean doesContinueToInputStudent() {
		AppView.output("성적을 입력하려면 'Y' 또는 'y'를, 종료하려면 다른 아무 키나 치시오: ");
		String line = null;
		do {
			line = AppView.scanner.nextLine();
		}while(line.equals("") );
		char answer = line.charAt(0);
		return ( (answer == 'Y') || (answer == 'y') );
	}
	

}// End of Class"AppView"
