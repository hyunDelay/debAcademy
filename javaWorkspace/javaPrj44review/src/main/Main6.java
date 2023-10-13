package main;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main6 {

	public static void main(String[] args) {
		
		// 여러개의 객체를 관리할 컬렙션
		Map<String, User> map = new HashMap<String, User>();
		
		// 유저 객체 여러개 만들고, 위에서 만든 컬렉션에 담기
		User user1 = new User("abc123", "1111");
		User user2 = new User("타락파워전사", "2222");
		User user3 = new User("예절", "3333");
		
		map.put(user1.getId(), user1);
		map.put(user2.getId(), user2);
		map.put(user3.getId(), user3);
		
		Set<String> ks = map.keySet(); // key 뽑기
		
		for(String k : ks) {
			System.out.println(k);
			User v = map.get(k);
			System.out.println(v);
		}
		
	}
	
}
