package kr.s20.object.lang;

import java.util.Arrays;

public class MathMain04 {
	public static void main(String[] args) {
		/*
		 * [실습]
		 * 로또 프로그램 제작
		 * 길이가 6인 int형 배열을 생성하고 1~45 숫자 범위로 난수를 구함.
		 * 중복되지 않은 6개의 숫자를 생성해서 배열에 저장하고 출력하시오.
		 * 난수 생성 : Math.random() 또는 Random 클래스의 nextInt() 메서드를 사용. 
		 */

		int[] numbers = new int[6];
		
		for (int i = 0; i < numbers.length; i++) {
			int num;
			do {
				num = (int) (Math.random() * 45) + 1;
			} while (existAlready(numbers, i, num));
			
			numbers[i] = num;
		}

		Arrays.sort(numbers);  // 오름차순 정렬
		
		for (int num : numbers) {
			System.out.print(num + " ");
		}
	}
	
	// 이미 존재하는 숫자인지 확인하는 메서드
	private static boolean existAlready(int[] array, int length, int num) {
		for (int i = 0 ; i < length ; i++) {
			if (array[i] == num) {
				return true;
			}
		}
		return false;
	}
}
