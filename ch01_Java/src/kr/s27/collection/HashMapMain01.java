package kr.s27.collection;

import java.util.HashMap;

public class HashMapMain01 {
	public static void main(String[] args) {
		/*
		 * Map : key와 value의 쌍으로 저장
		 *       저장된 순서가 유지되지 않음
		 */
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("김신", 95);
		map.put("지은탁", 100);
		map.put("저승사자", 85);
		map.put("써니", 93);
		map.put("유덕화", 70);
		map.put("지은탁", 0);
		map.put("강호동", null);
		map.put(null, 98);
		
		//저장된 데이터(key와 value의 쌍)의 목록
		System.out.println(map);
		System.out.println("-----------------------");
		
		Integer num = map.get("지은탁");
		System.out.println("지은탁의 성적은 " + num);
	}
}
