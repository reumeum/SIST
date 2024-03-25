package kr.s39.shop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShopUserMain {
	private BufferedReader br;
	private ShopDAO dao;

	public ShopUserMain() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			dao = new ShopDAO();
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

	public void callMenu() throws IOException {
		while (true) {
			System.out.print("1.회원 가입, 2.회원 정보, 3.상품 구매, 4.구매 내역, 5.종료> ");
			try {
				int no = Integer.parseInt(br.readLine());

				if (no == 1) { //회원 가입
					System.out.print("ID: ");
					String cust_id = br.readLine();
					System.out.print("이름: ");
					String cust_name = br.readLine();
					System.out.print("주소: ");
					String cust_address = br.readLine();
					System.out.print("전화번호: ");
					String cust_tel = br.readLine();
					
					dao.insertCustomer(cust_id, cust_name, cust_address, cust_tel);
				} else if (no == 2) { //회원 정보
					System.out.print("검색할 ID: ");
					String cust_id = br.readLine();
					
					dao.selectDatailCustomer(cust_id);
				} else if (no == 3) { //상품 구매
					dao.selectItems();
					System.out.print("구매할 상품의 번호: ");
					int item_num = Integer.parseInt(br.readLine());
					System.out.print("ID: ");
					String cust_id = br.readLine();
					dao.insertOrder(cust_id, item_num);
					
				} else if (no == 4) { //구매 내역
					System.out.print("ID: ");
					String cust_id = br.readLine();
					
					dao.SelectOrdersById(cust_id);
				} else if (no == 5) { //종료
					System.out.println("프로그램 종료");
					break;
				} else { 
					System.out.println("잘못 입력했습니다.");
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력해주세요.");
			}
		}
	}

	public static void main(String[] args) {
		new ShopUserMain();
	}
}
