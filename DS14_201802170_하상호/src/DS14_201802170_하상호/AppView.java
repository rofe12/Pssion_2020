package DS14_201802170_하상호;

import java.util.Scanner;

public class AppView {

	private static Scanner scanner = new Scanner(System.in);
	
	//생성자
	private AppView() {
		
	}

	public static void output(String aString) {
		System.out.print(aString);
	}

	public static void outputLine(String aString) {
		System.out.println(aString);
	}

	public static void outputTotalNumberOfStudents(int numberOfStudents) {
		System.out.println("전체 학생 수 : " + numberOfStudents);
	}

	public static void outputHighestScore(int aScore) {
		System.out.println("학급 최고 점수 : " + aScore);
	}

	public static void outputLowestScore(int aScore) {
		System.out.println("학급 최저 점수 : " + aScore);
	}

	public static void outputAverageScore(double average) {
		System.out.println("학급 평균 점수 : " + average);
	}

	public static void outputNumberOfStudentsAboveAverage(int numberOfStudents) {
		System.out.println("평균 이상인 학생 수 : " + numberOfStudents);
	}

	public static void outputNumberOfStudentsForGrade(char aGrade, int numberOfStudents) {
		System.out.println(aGrade + " 학점은 모두 " + numberOfStudents + "명 입니다.");
	}

	public static void outputStudentInfo(String aStudentID, int aScore, char aGrade) {
		System.out.println("학번 : " + aStudentID + ", 점수 : " + aScore + ", 학점 : " + aGrade);
	}

	public static void outputScore(int aScore) { // 학생의 점수 출력
		System.out.println("점수 : " + aScore);
	}

	public static boolean doesContinueToInputStudent() {
		AppView.output("? 학생 정보를 입력하려면 'Y' 또는 'y'를, 마치려면 다른 아무키나 치시오 : ");
		String line;
		do {
			line = AppView.scanner.nextLine();
		} while (line.equals(""));
		char answer = line.charAt(0);
		return ((answer == 'Y') || (answer == 'y'));
	}

	public static String inputId() {
		AppView.output("-학번을 입력하시오 : ");
		String id = AppView.scanner.nextLine();
		return id;
	}

	public static int inputScore() {
		AppView.output("-점수를 입력하시오 : ");
		int score = AppView.scanner.nextInt();
		return score;
	}
}