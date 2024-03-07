package kr.s27.collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ProductMain {
	ArrayList<Product> list;
	BufferedReader br;

	//생성자
	public ProductMain() {
		list = new ArrayList<Product>();
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			callMenu();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
				}
		}
	}

	//메뉴 호출
	public void callMenu() throws IOException {
		while (true) {
			System.out.print("1. 상품 입력, 2. 상품 목록 보기, 3. 종료> ");

			try {
				int num = Integer.parseInt(br.readLine());
				if (num == 1) {
					input();
				} else if (num == 2) {
					output();
				} else if (num == 3) {
					System.out.println("프로그램 종료");
					break;
				} else {
					System.out.println("잘못 입력했습니다.");
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자만 허용!");
			}
		}
	}

	//상품 정보 입력
	public void input() throws IOException {
		Product p = new Product();
		System.out.print("상품명:");
		p.setName(br.readLine());
		System.out.print("상품번호:");
		p.setNum(br.readLine());
		System.out.print("가격:");
		p.setPrice(Integer.parseInt(br.readLine()));
		System.out.print("제조사:");
		p.setMaker(br.readLine());
		System.out.print("재고:");
		p.setStock(Integer.parseInt(br.readLine()));

		//Product를 ArrayList에 저장
		list.add(p);
		System.out.println("상품 정보 1건이 추가되었습니다.");
	}

	//상품 정보 출력
	public void output() {
		System.out.println("상품리스트 : 총 상품수(" + list.size() + ")");
		System.out.println("상품명  상품번호     가격     제조사  재고수");
		System.out.println("--------------------------------------------");
		//반복문을 이용한 요소의 출력
		/*
		for (int i = 0; i < list.size(); i++) {
			Product pt = list.get(i);
			System.out.printf("%s  ", pt.getName());
			System.out.printf("%7s", pt.getNum());
			System.out.printf("%,10d원", pt.getPrice());
			System.out.printf("%5s", pt.getMaker());
			System.out.printf("%,5d%n", pt.getStock());
		}
		*/

		//확장for문을 이용한 요소의 출력
		for (Product pt : list) {
			System.out.printf("%s  ", pt.getName());
			System.out.printf("%7s", pt.getNum());
			System.out.printf("%,10d원", pt.getPrice());
			System.out.printf("%5s", pt.getMaker());
			System.out.printf("%,5d%n", pt.getStock());
		}
	}

	//메인 작업은 객체를 만들고 끝나도록
	public static void main(String[] args) {
		new ProductMain();
	}
}
