package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import mob.Pokemon;

public class TestClass {

	// List :: 인덱스로 요소들을 관리
	public void method01(){
		System.out.println("----- List -----");
		List al = new ArrayList(); // 리스트=부모객체 어레이리스트=자식객체
		
		// 넣기
		Pokemon p = new Pokemon();
		al.add(p);
		
		// 꺼내기
		Object result = al.get(0);
		System.out.println(result);
	}
	
	// Set :: 중복 X
	public void method02(){
		System.out.println("----- Set -----");
		Set s = new HashSet();
		
		s.add("one");
		s.add("one");
		s.add("one");
		s.add("two");
		s.add("three");
		s.add(4);
		s.add(5);
		
		System.out.println(s);
		
	}
	
	// Map :: key-value 쌍으로 데이터를 관리, key는 중복 X
	public void method03(){
		System.out.println("----- Map -----");
		Map map = new HashMap();
		
		// 넣기
		map.put("one", "안녕");
		map.put(1, "정수 일");
		
		for(int i = 0; i < 10; i++) {
			map.put(i, i + "번");
			System.out.print(map.get(i));
		}
		
		map.remove(2);
		
		System.out.println(map);
		
		// 꺼내기
//		Object result = map.get("one");
//		Object result2 = map.get(1);
//		System.out.println(result);
//		System.out.println(result2);
	}
	
	// Stack :: LIFO (Last In First Out) 마지막에 넣은 값이 첫번째로 나온다.
	public void method04(){
		System.out.println("----- Stack -----");
		Stack stack = new Stack();
		
		// 넣기
		stack.add("one1");
		stack.add("one2");
		stack.add("one3");
		
		Object result = stack.peek();
		System.out.println(result);
		
		Object result2 = stack.peek();
		System.out.println(result2);
		
		// 꺼내기
		System.out.println(stack);
	}
	
	// Queue :: FIFO (First In First Out) 첫번째에 넣은 값이 첫번째로 나온다.
	public void method05(){
		System.out.println("----- Queue -----");
		Queue queue = new LinkedList();
		queue.add("원");
		queue.add("투");
		queue.add("쓰리");

		Object result = queue.poll();
		System.out.println(result);
		Object result2 = queue.poll();
		System.out.println(result2);
		
		System.out.println(queue);
		
	}
	
}
