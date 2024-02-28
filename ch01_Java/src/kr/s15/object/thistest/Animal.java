package kr.s15.object.thistest;

public class Animal {
	/*
	 * [실습]
	 * Animal
	 * 멤버 변수 : 이름(name), 나이(age), 비행여부(fly) - private
	 * 멤버 메서드 : public set/get 메서드
	 * 생성자 : 인자가 있는 생성자, 인자가 없는 생성자
	 * 
	 * 인자가 있는 생성자를 이용해서 객체 생성
	 * 이름, 나이, 비행여부를 출력, 비행여부 true/false -> 가능/불가능
	 * 
	 * 인자가 없는 생성자를 이용해서 객체 생성
	 * 이름, 나이, 비행여부 설정
	 * 이름, 나이, 비행여부를 출력, 비행여부 true/false -> 가능/불가능
	 */

	//멤버 필드
	private String name;
	private int age;
	private boolean fly;

	//생성자
	public Animal() {
	}

	public Animal(String name, int age, boolean fly) {
		this.name = name;
		this.age = age;
		this.fly = fly;
	}

	// 멤버 메서드
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isFly() {
		return fly;
	}

	public void setFly(boolean fly) {
		this.fly = fly;
	}

}
