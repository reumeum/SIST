package kr.s27.collection;

import java.util.ArrayList;

public class ArrayListMain03 {
	public static void main(String[] args) {
		/*
		 *  제네릭 표현 : 객체를 생성할 때 객체에 저장할 수 있는 요소의 타입을 지정
		 */
		ArrayList<String> list = new ArrayList<String>();
		list.add("장영실"); // String
		list.add("홍길동"); // String
//		list.add(1000);     // Integer
		                    // 객체에 저장할 수 있는 데이터의 타입을 String으로 한정했기 때문에
		                    // Integer 데이터 저장 불가
		list.add("김유신"); // String
		
		// 반복문을 이용한 요소의 출력
		for (int i = 0; i < list.size(); i++) {
			String name = list.get(i);
			System.out.println(name);
		}
		System.out.println("------------------");
		
		// 확장 for문을 이용한 요소의 출력
		for (String name : list) {
			System.out.println(name);
		}
	}
}
