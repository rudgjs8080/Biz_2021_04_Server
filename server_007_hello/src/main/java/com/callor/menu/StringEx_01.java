package com.callor.menu;

public class StringEx_01 {

	public static void main(String[] args) {
		
		String menu = null;
		if(menu == null) {
			System.out.println("menu는 null");
		} else {
			System.out.println("1이 아님");
		}
		
		// switch 문
		// switch는 null값을 수행할 수 없다
		
		/*
		 * switch 명령은 다중 if else, else if를
		 * 대신하여 사용할 수 있는 구조적인 명령문이다
		 * 단점이
		 * 반드시 case 조건을 수행한 다음 break;를 실행하여
		 * 더이상 불필요한 코드가 실행되는 것을 막아야 하며
		 * 
		 * 만약 변수에 저장된 값이 null이면 미리
		 * if 명령등을 이용하여 검사를 하던지
		 * 절대 변수에 null 값이 저장되지 않도록 미리 조치를 
		 * 해줘야 한다
		 * 
		 */
		
		switch (menu) {
		case "1": 
			System.out.println("저장된 값 1");
			break;
		case "2": 
			System.out.println("저장된 값 2");
			break;
		case "3": 
			System.out.println("저장된 값 3");
			break;
		case "4": 
			System.out.println("저장된 값 4");
			break;
		case "5": 
			System.out.println("저장된 값 5");
			break;
		
		default:
			System.out.println("모르겠음");
		}
		
	}
	
}
