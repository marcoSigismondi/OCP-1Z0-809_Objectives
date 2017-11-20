package standard.collections;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.jupiter.api.Test;

class QueueTest {

	@Test
	void testQueue() {
		Queue<String> parentQueue = new PriorityQueue<String>();
		System.out.println("java.util.Queue.add(String) -> " + parentQueue.add("Marco") + " | queue: " + parentQueue);
		//java.util.Queue.add(String) -> true | queue: [Marco]
		
		System.out.println("java.util.Queue.element() -> " + parentQueue.element() + " | queue: " + parentQueue);
		//java.util.Queue.element() -> Marco | queue: [Marco]
		
		System.out.println("java.util.Queue.add(String) -> " + parentQueue.add("Fulvia") + " | queue: " + parentQueue);
		//java.util.Queue.add(String) -> true | queue: [Fulvia, Marco]
		
		System.out.println("java.util.Queue.remove() -> " + parentQueue.remove() + " | queue: " + parentQueue);
		//java.util.Queue.remove() -> Fulvia | queue: [Marco]

		Queue<String> sonQueue = new PriorityQueue<String>();
		System.out.println("java.util.Queue.offer(String) -> " + sonQueue.offer("Emma") + " | queue: " + sonQueue);
		//java.util.Queue.offer(String) -> true | queue: [Emma]
		
		System.out.println("java.util.Queue.peek() -> " + sonQueue.peek() + " | queue: " + sonQueue);
		//java.util.Queue.peek() -> Emma | queue: [Emma]
		
		System.out.println("java.util.Queue.offer(String) -> " + sonQueue.offer("Benni") + " | queue: " + sonQueue);
		//java.util.Queue.offer(String) -> true | queue: [Benni, Emma]
		
		System.out.println("java.util.Queue.poll() -> " + sonQueue.poll() + " | queue: " + sonQueue);
		//java.util.Queue.poll() -> Benni | queue: [Emma]
	}

	@Test
	void testDeque() {
		Deque<String> parentQueue = new ArrayDeque<String>();
		parentQueue.push("Marco");
		System.out.println("java.util.Queue.add(String) -> void | queue: " + parentQueue);
		//java.util.Queue.add(String) -> void | queue: [Marco]
		
		System.out.println("java.util.Queue.element() -> " + parentQueue.peek() + " | queue: " + parentQueue);
		//java.util.Queue.element() -> Marco | queue: [Marco]
		
		parentQueue.push("Fulvia");
		System.out.println("java.util.Queue.add(String) -> void | queue: " + parentQueue);
		//java.util.Queue.add(String) -> void | queue: [Fulvia, Marco]
		
		System.out.println("java.util.Queue.remove() -> " + parentQueue.pop() + " | queue: " + parentQueue);
		//java.util.Queue.remove() -> Fulvia | queue: [Marco]

	}
}