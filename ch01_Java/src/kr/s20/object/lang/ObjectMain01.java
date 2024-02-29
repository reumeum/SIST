package kr.s20.object.lang;

public class ObjectMain01 {
	public static void main(String[] args) {
		ObjectMain01 ob = new ObjectMain01();
		System.out.println(ob.getClass()); // 클래스 정보를 가진 객체 반환
		System.out.println(ob.getClass().getName()); // 클래스 정보를 가진 객체에서 클래스명 반환
		System.out.println(ob.hashCode()); // 10진수의 유니크한 값 반환
		System.out.println(Integer.toHexString(ob.hashCode())); // 10진수를 16진수로 변환
		System.out.println(ob.toString());
		System.out.println(ob);
	}
}
