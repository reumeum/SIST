package kr.s27.collection;

import java.util.ArrayList;

public class ArrayListMain04 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("홍길동");
		list.add("김유신");
		list.add("박문수");
		list.add("장영실");
		list.add("홍길동");

		// 반복문을 이용한 요소의 출력
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + " : " + list.get(i));
		}
		
		System.out.println("---------------------------");
		
		// 요소의 삭제
		list.remove(2);  // 인덱스
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + " : " + list.get(i));
		}
		
		System.out.println("---------------------------");
	}
}
