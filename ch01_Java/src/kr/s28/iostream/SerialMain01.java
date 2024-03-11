package kr.s28.iostream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * Serializable 인터페이스를 구현하면 해당 클래스는 객체 직렬화 대상이 되어
 * 언제든지 객체 직렬화를 수행할 수 있음.
 * Serializable 인터페이스가 구현되지 않으면 객체 직렬화 불가능
 */
class Customer implements Serializable {
	private String name;

	public Customer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "당신의 이름은 " + name;
	}

}

public class SerialMain01 {
	public static void main(String[] args) {
		// 직렬화할 객체 생성
		Customer c = new Customer("홍길동");

		System.out.println("===객체 직렬화하기===");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			//파일 생성
			fos = new FileOutputStream("object.ser");
			oos = new ObjectOutputStream(fos);
			//객체 직렬화 수행
			oos.writeObject(c);
			
			System.out.println("객체 직렬화가 완료되었습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//자원정리
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
