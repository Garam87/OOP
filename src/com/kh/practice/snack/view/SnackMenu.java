package com.kh.practice.snack.view;

import java.util.Scanner;

import com.kh.practice.snack.controller.SnackController;

public class SnackMenu {

	private Scanner sc = new Scanner(System.in);
	
	private SnackController scr = new SnackController();
	
	
	// 메소드
	public void menu() {
		System.out.println("스낵류를 입력하세요.");
		System.out.print("종류 : ");
		String kind = sc.next();
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("맛 : ");
		String flavor = sc.next();
		System.out.print("개수 : ");
		int numOf = sc.nextInt();
		System.out.print("가격 : ");
		int price = sc.nextInt();

		System.out.println(scr.saveData(kind, name, flavor, numOf, price));
		
		String result = sc.next();
		if(result.equals("y") || result.equals("Y")) {
			System.out.println(scr.confirmData());
		}
//		System.out.print(scr.confirmData());
//		String input = sc.next();
//		if(input.equals("y") || input.equals("Y")) {
//			System.out.println(scr.confirmData());
//		} else if(input.equals("n") || input.equals("N")) {
//			System.out.println("프로그램 종료");
//		}
//		System.out.println("잘못입력하셧습니다.");
	}
		
}
