package datastructure;

import java.util.EmptyStackException;

public class LinkedList
{
	private Node top;
	private Node tail;
	
	public static class Node
	{
		int data;
		Node next;
		public Node(int data)
		{
			this.data = data;
		}
		@Override
		public String toString()
		{
			return "Node [data=" + data + ", next=" + next + "]";
		}
	}
	
	public void addLast(int data)
	{
		Node newNode = new Node(data);
		if (top == null)
		{
			top = newNode;
			tail = top;
		}
		else
		{
			tail.next = newNode;
			tail = newNode;
		}
	}
}
