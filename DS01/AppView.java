package DS01_201802170_하상호;

import java.util.Scanner;
//View
public class AppView {
	//비공개 상수/변수들
	private static Scanner scanner = new Scanner(System.in);
	
	//생성자 : 객체를 생성할 일이 없음
	//객체를 생성할 일이 없어도 일반 생성자를 표현해줌
	private AppView() {
		
	}
	//공개함수의 구현
	//User inputOrder
	public static int inputOrder() { //box
		System.out.print("? 마방진 차수를 입력하시오(음수를 입력하면 종료합니다) :");
		int inputOrder = scanner.nextInt();
		return inputOrder;
	}
	
	
	public static void output(String message) {
		System.out.print(message);
	}
	public static void outputLine(String message) {
		System.out.println(message);
	}
	public static void outputTitleWithOrder(int order) {//box / usuer 가 입력한 Order값를 출력
		System.out.println("! Magic Square Board : Order "+ order);
		
	}
	public static void outputRowNomber(int number) {
		System.out.printf("[%3d]",number);
	}
	public static void outputCellValue(int value) {
		System.out.printf("   %3d" , value);
	}

}//End of Class"AppView"
