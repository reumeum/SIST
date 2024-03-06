package kr.s27.collection;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListMain06 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("머루"); //0
		list.add("사과"); //1
		list.add("앵두"); //2
		list.add("자두"); //3
		list.add("사과"); //4

		// 인덱스 탐색
		int index1 = list.indexOf("사과");
		System.out.println("첫번째 사과 : " + index1); //1

		int index2 = list.lastIndexOf("사과");
		System.out.println("마지막 사과 : " + index2); //4

		// 망고가 존재하지 않으면 -1 반환
		int index3 = list.indexOf("망고");
		System.out.println("망고 : " + index3); //-1

		// contains()
		// ArrayList에 머루가 저장되어 있으면 true 반환, 없으면 false 반환
		boolean f1 = list.contains("머루");
		System.out.println("머루 : " + f1);

		boolean f2 = list.contains("망고");
		System.out.println("망고 : " + f2);

		// 요소의 목록 출력
		System.out.println(list);
		System.out.println("---------------------");

		// 정렬(사전 순서대로)
		Collections.sort(list);
		System.out.println(list);

		// 정렬(현재 순서의 역순으로)
		Collections.reverse(list);
		System.out.println(list);
		System.out.println("---------------------");

		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(10);
		list2.add(100);
		list2.add(15);
		list2.add(2);
		list2.add(40);

		System.out.println(list2);

		// 정렬(오름차순 정렬)
		Collections.sort(list2);
		System.out.println(list2);

		// 정렬(내림차순 정렬)
		Collections.reverse(list2);
		System.out.println(list2);

	}
}
