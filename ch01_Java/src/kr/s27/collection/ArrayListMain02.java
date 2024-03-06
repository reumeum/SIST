package kr.s27.collection;

import java.util.ArrayList;

public class ArrayListMain02 {
	public static void main(String[] args) {
		/*
		 * list 구조의 특징
		 * 저장된 순서 유지, 중복 저장 허용
		 */
		
		ArrayList list = new ArrayList();
		list.add("홍길동"); // String -> Object
		list.add("장영실"); // String -> Object
		list.add("박문수"); // String -> Object
		list.add("김유신"); // String -> Object
		
		// 저장된 요소의 목록
		System.out.println(list);
		System.out.println("------------------------------");
		
		// 반복문을 이용해서 저장된 요소 출력
		for (int i = 0; i < list.size(); i++) {
			String name = (String) list.get(i);  // 다운캐스팅
			System.out.println(name);
		}
	}
}
