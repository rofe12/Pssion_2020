package DS02_201802170_하상호;

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
	
	public static void output(String message) {
		System.out.print(message);
	}
	
	public static void outputLine(String message) {
		System.out.println(message);
	}
	//box 
	//inputMenuNumber of user
	public static int inputMenuNumber() {
		System.out.print("? 수행하려고 하는 메뉴 번호를 선택하시오(add:1, remove:2, search:3, frequency:4., exit:9 :");
		int menuNumber = scanner.nextInt();
		return menuNumber;
	} 
	//box
	//inputCapacityOfCoinBag of user
	public static int inputCapacityOfCoinBag() {
		System.out.print("?동전 가방의 크기, 즉 가방에 들어갈 동전의 최대 개수를 입력하시오 :");
		int inputCapacityOfCoinBag  = scanner.nextInt();
		return inputCapacityOfCoinBag;
	}
	//box
	//inputCoinValue of user
	public static int inputCoinValue() {
		System.out.print("?동전값을 입력하시오:");
		int inputCoinValue  = scanner.nextInt();
		return inputCoinValue;
	}
	
}//End of Class"AppView"
