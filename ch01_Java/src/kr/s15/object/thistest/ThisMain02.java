package kr.s15.object.thistest;

class ThisTest {
	// 은닉화
	private int a;
	// 캡슐화
	public void setA(int a) {
		this.a = a;
	}
	public int getA() {
		return a;
	}
}

public class ThisMain02 {
	public static void main(String[] args) {
		ThisTest tt = new ThisTest();
		tt.setA(10);
		System.out.println(tt.getA());
	}
}
