package com.kh.test.money.model.vo;

public class Money {

	//Field
	
	public final static String UNIT = "원";
	private int money;
	
	//Construtor
	
	public Money() {
		
	}
	public Money(int money) {
		
	}

	//Method
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public static String getUnit() {
		return UNIT;
	}

	public void print() {
		System.out.println("안녕?");
	}
	
}
