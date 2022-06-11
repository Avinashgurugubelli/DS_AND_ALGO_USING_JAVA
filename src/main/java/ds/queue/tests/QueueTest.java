package ds.queue.tests;

import ds.queue.Queue;

public class QueueTest {

	public static void main(String[] args) throws Exception {
		Queue<String> q = new Queue();
		q.enqueue("A");
		q.enqueue("B");
		q.enqueue("C");
		System.out.println(q);
		q.dequeue();
		System.out.println(q);

	}
}
