package standard.collections;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

import org.junit.jupiter.api.Test;

class Person {
	public String name;
	public int age;
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}

class CollectionsTest {
	
	public static List<Person> list = Arrays.asList(new Person("Fulvia", 37), new Person("Marco", 29), new Person("Benni", 2), new Person("Emma", 0));
	
	/**
	 * Create and use ArrayList, TreeSet, TreeMap, and ArrayDeque objects
	 * IMPORTANT: ceiling -> soffitto (>=); floor -> pavimento (<=)
	 * */

	@Test
	void test() {
		/*Map*/
		Map<String, String> map = null;
		map = new HashMap<>();
		map = new TreeMap<>();
		/*Set*/
		Set<String> set = null;
		set = new TreeSet<String>();
		set = new HashSet<String>();
		/*List*/
		List<String> list = null;
		list = new ArrayList<String>();
		list = new Vector<String>();
		list = new LinkedList<>();
		/*Queue*/
		Queue<String> queue = null;
		queue = new LinkedList<String>();
		queue = new PriorityQueue<String>();
		/*Deque - extends Queue*/
		Deque<String> deque = null;
		deque = new ArrayDeque<>();
		deque = new LinkedList<>();
	}
	
	@Test
	void testTreeSet() {
//		TreeSet<Person> set = new TreeSet<Person>(list); // java.lang.ClassCastException: standard.collections.Person cannot be cast to java.lang.Comparable
		TreeSet<Person> set = new TreeSet<Person>(new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.name.compareTo(o2.name);
			}
			
		});
		set.addAll(list);
		System.out.println(set);
		
		Person target = new Person("Marco", 29);
		Person from = new Person("Emma", 0);
		Person to = new Person("Fulvia", 37);
		System.out.println(set.ceiling(target));				// Person [name=Marco, age=29]
		System.out.println(set.first());						// Person [name=Benni, age=2]
		System.out.println(set.floor(target));					// Person [name=Marco, age=29]
		System.out.println(set.last());							// Person [name=Marco, age=29]
		System.out.println(set.lower(target));					// Person [name=Fulvia, age=37]
		System.out.println(set.pollFirst());					// Person [name=Benni, age=2]
		System.out.println(set.pollLast());						// Person [name=Marco, age=29]
		System.out.println(set.remove(target));					// false
		System.out.println(set.size());							// 2
		System.out.println(set.subSet(from, true, to, true));	// [Person [name=Emma, age=0], Person [name=Fulvia, age=37]]
		System.out.println(set.subSet(from, from));				// []
	}
	
	@Test
	void testTreeMap() {
//		TreeMap<Person, Integer> notSortedMap = new TreeMap<Person, Integer>(); // java.lang.ClassCastException: standard.collections.Person cannot be cast to java.lang.Comparable
		TreeMap<Person, Integer> sortedMap = new TreeMap<Person, Integer>(new Comparator<Person>() {

			@Override
			public int compare(Person arg0, Person arg1) {
				return arg0.age - arg1.age;
			}
			
		});
		Person fulvia = new Person("Fulvia", 37);
		Person marco = new Person("Marco", 29);
		Person benni = new Person("Benni", 2);
		Person emma = new Person("Emma", 0);
		sortedMap.put(fulvia, fulvia.age);
		sortedMap.put(marco, marco.age);
		sortedMap.put(benni, benni.age);
		sortedMap.put(emma, emma.age);
		System.out.println(sortedMap);
		
		Person key = marco;
		System.out.println(sortedMap.ceilingEntry(key)); 					//Person [name=Marco, age=29]=29
		System.out.println(sortedMap.ceilingKey(key)); 						//Person [name=Marco, age=29]
		System.out.println(sortedMap.firstEntry()); 						//Person [name=Emma, age=0]=0
		System.out.println(sortedMap.firstKey()); 							//Person [name=Emma, age=0]
		System.out.println(sortedMap.floorEntry(key)); 						//Person [name=Marco, age=29]=29
		System.out.println(sortedMap.floorKey(key)); 						//Person [name=Marco, age=29]
		System.out.println(sortedMap.higherEntry(key)); 					//Person [name=Fulvia, age=37]=37
		System.out.println(sortedMap.higherKey(key)); 						//Person [name=Fulvia, age=37]
		System.out.println(sortedMap.keySet()); 							//[Person [name=Emma, age=0], Person [name=Benni, age=2], Person [name=Marco, age=29], Person [name=Fulvia, age=37]]
		System.out.println(sortedMap.lastEntry()); 							//Person [name=Fulvia, age=37]=37
		System.out.println(sortedMap.lastKey()); 							//Person [name=Fulvia, age=37]
		System.out.println(sortedMap.lowerEntry(key)); 						//Person [name=Benni, age=2]=2
		System.out.println(sortedMap.lowerKey(key)); 						//Person [name=Benni, age=2]
		System.out.println(sortedMap.pollFirstEntry()); 					//Person [name=Emma, age=0]=0
		System.out.println(sortedMap.pollLastEntry()); 						//Person [name=Fulvia, age=37]=37
		System.out.println(sortedMap.subMap(emma, true, fulvia, true)); 	//{Person [name=Benni, age=2]=2, Person [name=Marco, age=29]=29}
		System.out.println(sortedMap.subMap(benni, marco)); 				//{Person [name=Benni, age=2]=2}
		
	}
	
	@Test
	void testArrayDeque() {
		ArrayDeque<Person> arrayDeque = new ArrayDeque<Person>();
		System.out.println(arrayDeque);
		
		Person fulvia = new Person("Fulvia", 37);
		Person marco = new Person("Marco", 29);
		Person benni = new Person("Benni", 2);
		Person emma = new Person("Emma", 0);
		
		//Inserts the specified element at the end of this deque. 
		System.out.println(arrayDeque.add(fulvia));
		
		//Inserts the specified element at the end of this deque. 
		arrayDeque.addLast(marco); 						//void
		
		//Inserts the specified element at the end of this deque. 
		System.out.println(arrayDeque.offer(benni));
		
		//Inserts the specified element at the end of this deque.
		System.out.println(arrayDeque.offerLast(emma));
		
		//Retrieves and removes the head of the queue represented by this deque. 
		//This method differs from poll only in that it throws an exception if this deque is empty. 
		System.out.println(arrayDeque.remove());
		
		//Retrieves and removes the first element of this deque. 
		//This method differs from pollFirst only in that it throws an exception if this deque is empty.
		System.out.println(arrayDeque.removeFirst());
		
		//Retrieves and removes the head of the queue represented by this deque (in other words, the first element of this deque),
		//or returns null if this deque is empty. 
		System.out.println(arrayDeque.poll());
		
		//Retrieves and removes the first element of this deque, or returns null if this deque is empty.
		System.out.println(arrayDeque.pollFirst());
		
		//Retrieves, but does not remove, the head of the queue represented by this deque. 
		//This method differs from peek only in that it throws an exception if this deque is empty. 
		System.out.println(arrayDeque.element());
		
		//Retrieves, but does not remove, the first element of this deque. 
		//This method differs from peekFirst only in that it throws an exception if this deque is empty.
		System.out.println(arrayDeque.getFirst());
		
		//Retrieves, but does not remove, the head of the queue represented by this deque, or returns null if this deque is empty. 
		System.out.println(arrayDeque.peek());
		
		//Retrieves, but does not remove, the first element of this deque, or returns null if this deque is empty.
		System.out.println(arrayDeque.peekFirst());
		
		//Pushes an element onto the stack represented by this deque. In other words, inserts the element at the front of this deque. 
		arrayDeque.push(fulvia); 						//void
		
		//Inserts the specified element at the front of this deque.
		arrayDeque.addFirst(marco); 					//void
		
		//Pops an element from the stack represented by this deque. 
		//In other words, removes and returns the first element of this deque. 
		System.out.println(arrayDeque.pop());
		
		//Retrieves and removes the first element of this deque. 
		//This method differs from pollFirst only in that it throws an exception if this deque is empty.
		System.out.println(arrayDeque.removeFirst());
		
		//Retrieves, but does not remove, the head of the queue represented by this deque, or returns null if this deque is empty. 
		System.out.println(arrayDeque.peek());
		
		//Retrieves, but does not remove, the first element of this deque, or returns null if this deque is empty.
		System.out.println(arrayDeque.peekFirst());
		
		
	}
	

}
