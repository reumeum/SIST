package kr.s28.iostream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

class UserInfo implements Serializable {
	private String name;
	private int age;
	private String address;

	//생성자
	public UserInfo(String name, int age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}

	@Override
	public String toString() {
		return "이름 : " + name + ", 나이: " + age + ", 주소: " + address +"\n";
	}

}

public class SerialMain03 {
	public static void main(String[] args) {
		UserInfo u1 = new UserInfo("John", 20, "서울시");
		UserInfo u2 = new UserInfo("Sunny", 18, "부산시");

		ArrayList<UserInfo> list = new ArrayList<UserInfo>();

		list.add(u1);
		list.add(u2);

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream("userInfo.ser");
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(list);
			
			System.out.println("직렬화가 성공적으로 완료되었습니다.");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
				}
			}
		}
	}
}
