package kr.s27.collection;

import java.util.Stack;

public class StackMain {
	public static void main(String[] args) {
		//스택(Stack): 후입선출 LIFO (Last-In First-Out)
		String[] array  = {"진달래", "백합", "개나리", "벚꽃", "장미"};
		
		Stack<String> stk = new Stack<String>();
		
		//반복문을 이용해서 Stack에 요소 저장
		for (int i = 0; i < array.length; i++) {
			stk.push(array[i]); //객체 저장
		}
		
		System.out.println(stk);
		System.out.println("--------------------------");
		
		//현재 스택이 비어 있는지 검증
		while(!stk.isEmpty()) {
			                 // 스택에 저장된 객체를 꺼내온다
			System.out.print(stk.pop() + "  ");
		}
		
		System.out.println();
		System.out.println("---------------------------");
		System.out.println(stk);
	}
}
