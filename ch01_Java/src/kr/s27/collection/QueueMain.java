package kr.s27.collection;

import java.util.LinkedList;

public class QueueMain {
	public static void main(String[] args) {
		//큐(Queue): 선입선출 FIFO(First-In First-Out)
		String[] array = {"서울", "부산", "대구", "광주", "인천"};
		
		LinkedList<String> linked = new LinkedList<String>();
		
		for (int i = 0; i < array.length; i++) {
			linked.offer(array[i]);
		}
		
		//저장된 요소의 목록
		System.out.println(linked);
		System.out.println("----------------------------");
				//큐에 저장된 첫번째 요소를 검색
		while (linked.peek() != null) {
			System.out.print(linked.poll() + "  ");
		}
		
		System.out.println();
		System.out.println("----------------------------");
		System.out.println(linked);
	}
}
