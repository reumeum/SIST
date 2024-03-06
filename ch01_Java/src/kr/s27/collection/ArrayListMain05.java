package kr.s27.collection;

import java.util.ArrayList;

public class ArrayListMain05 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(15);
		list.add(16);

		// 저장된 요소의 목록 출력
		System.out.println(list);
		System.out.println("-----------------------");

		// 짝수 삭제
//		for (int i = 0; i < list.size(); i++) {
//			if (list.get(i) % 2 == 0) {
//				list.remove(i);
//			}
//		}
		
		
		
		// 마지막 인덱스부터 시작해서 조건 체크하면 건너뛰는 데이터가 발생하지 않고
		// 모든 요소의 조건 체크 가능
		for (int i = list.size() - 1; i >= 0; i--) {
			if (list.get(i) % 2 == 0) {
				list.remove(i);
			}
		}
		System.out.println(list);
		System.out.println("-----------------------");
	}
}
