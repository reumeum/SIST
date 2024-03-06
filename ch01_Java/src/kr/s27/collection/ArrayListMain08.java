package kr.s27.collection;

import java.util.ArrayList;

public class ArrayListMain08 {
	public static void main(String[] args) {
		// 2차원 배열 형태를 ArrayList로 구현하기
		ArrayList<CartItem> cart = new ArrayList<CartItem>();
		
		cart.add(new CartItem("A1001", 2, 2000));
		cart.add(new CartItem("B1001", 1, 7000));
		cart.add(new CartItem("C1001", 3, 2500));
		
		System.out.printf("%s %8s %8s%n", "상품코드", "수량", "가격");
		System.out.println("---------------------------------");
		for (CartItem item : cart) {
			System.out.printf("%s %,12d %,12d%n", item.getCode(), item.getNum(), item.getPrice());
		}
		
		System.out.println("---------------------------------");
		// 요소의 삭제
		cart.remove(1);
		
		for (CartItem item : cart) {
			System.out.printf("%s %,12d %,12d%n", item.getCode(), item.getNum(), item.getPrice());
		}
	}
}
