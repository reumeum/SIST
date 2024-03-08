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
		// list.remove(2);  // 인덱스

		// 중복된 데이터가 있을 때 동시 삭제를 할 수 없고 앞에서부터 삭제함
		list.remove("홍길동");  // 요소

		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + " : " + list.get(i));
		}

		System.out.println("---------------------------");

		ArrayList<Integer> list2 = new ArrayList<Integer>();

		list2.add(40);
		list2.add(1);
		list2.add(2);
		list2.add(3);
		list2.add(40);

		for (int i = 0; i < list2.size(); i++) {
			System.out.println(i + " : " + list2.get(i));
		}

		System.out.println("---------------------------");

		// 요소의 삭제
		// list2.remove(2); // 인덱스
		// list2.remove((Integer) 40);
		list2.remove(Integer.valueOf(40)); // 요소, int -> Integer

		for (int i = 0; i < list2.size(); i++) {
			System.out.println(i + " : " + list2.get(i));
		}

		System.out.println("---------------------------");

		// 요소의 변경
		// 인덱스, 데이터
		list2.set(1, 30);

		for (int i = 0; i < list2.size(); i++) {
			System.out.println(i + " : " + list2.get(i));
		}

		System.out.println("---------------------------");
	}
}
