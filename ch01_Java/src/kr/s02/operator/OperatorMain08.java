package kr.s02.operator;

public class OperatorMain08 {
	public static void main(String[] args) {
		/*
		 * 논리곱(&&)
		 * 선조건   && 후조건             결과
		 * true         true              true
		 * true         false            false
		 * false --> (후조건 미실행) --> false
		 * 
		 * 논리합(||)
		 * 선조건   || 후조건             결과
		 * true --> (후조건 미실행) --->  true
		 * false        true              true
		 * false        false            false
		 */

		// 증감연산자, 비교연산자, 논리연산자
		int a, b;
		a = b = 10;
		
		boolean c = a++ >= ++b && ++a > b++;
		          //10      11
		          //false --> 후조건 미실행
		System.out.println(a + ", " + b);
		System.out.println("c = " + c);
		
		System.out.println("-----------------");
		
		int d, e;
		d = e = 10;
		
		boolean f = ++d < e++ || d++ >= ++e;
		           //11    10    11     12
		           //false          false  --> false
		System.out.println(d + ", " + e);
		System.out.println("f = " + f);
		
	}
}
