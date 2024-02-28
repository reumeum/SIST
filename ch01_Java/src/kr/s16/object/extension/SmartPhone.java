package kr.s16.object.extension;

// 자식 클래스
public class SmartPhone extends Phone {
	private String os;

	public SmartPhone(String number, String model, String color, String os) {
		this.number = number;
		this.model = model;
		this.color = color;
		this.os = os;
	}

	public String getOs() {
		return os;
	}
	
	
}
