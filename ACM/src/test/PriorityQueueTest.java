package test;

import java.util.PriorityQueue;

public class PriorityQueueTest
{
	public static void main(String [] args)
	{
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		System.out.println(queue.poll());
		queue.offer(10);
		queue.offer(5);
		queue.offer(11);
	}
}
