package kr.s15.object.thistest;

public class AnimalMain {
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

	
	public static void main(String[] args) {
		Animal a1 = new Animal("독수리", 5, true);
		
		System.out.println("이름: " + a1.getName());
		System.out.println("나이: " + a1.getAge());
		System.out.println("비행 여부: " + (a1.isFly() ? "가능" : "불가능"));
		
		System.out.println();
		
		Animal a2 = new Animal();
		a2.setName("사자");
		a2.setAge(8);
		a2.setFly(false);
		
		System.out.println("이름: " + a2.getName());
		System.out.println("나이: " + a2.getAge());
		System.out.println("비행 여부: " + (a2.isFly() ? "가능" : "불가능"));
	}
}
