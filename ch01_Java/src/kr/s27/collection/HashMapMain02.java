package kr.s27.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapMain02 {
	public static void main(String[] args) {
		String[] msg = {"Berlin", "Paris", "Seoul", "New York", "London"};
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		for (int i = 0; i < msg.length; i++) {
			map.put(i, msg[i]);
		}
		
		//HashMap의 데이터 목록 호출
		System.out.println(map);
		System.out.println("----------------------");
		
		//키값을 뽑아내기 위해 HashMap -> Set -> Iterator
		// Set<Integer> s = map.keySet();
		// Iterator<Integer> keys = s.iterator();
		Iterator<Integer> keys = map.keySet().iterator();
		
		while(keys.hasNext()) {
			Integer key = keys.next();
			System.out.println(key + ": " + map.get(key));
		}
	}
}
