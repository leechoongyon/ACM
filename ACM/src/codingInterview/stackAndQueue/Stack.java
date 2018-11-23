package codingInterview.stackAndQueue;

import java.util.EmptyStackException;

public class Stack
{
	public static class Node
	{
		private Object data;
		private Node next;
		public Node(Object item)
		{
			this.data = item;
		}
		@Override
		public String toString()
		{
			return "Node [data=" + data + ", next=" + next + "]";
		}
	}
	
	private Node top;
	private int size;
	
	public void push(Object item)
	{
		Node newNode = new Node(item);
		if (top == null)
		{
			top = newNode;
		}
		else
		{
			newNode.next = top;
			top = newNode;
		}
		size++;
		
	}
	
	public Object pop()
	{
		if (top == null)
			return null;
		Object item = top.data;
		top = top.next;
		size--;
		return item;
	}

	public int getSize()
	{
		return size;
	}
	
	public boolean isFull(int capacity)
	{
		return size >= capacity;
	}
	
	@Override
	public String toString()
	{
		return "Stack [top=" + top + "]";
	}

	public static void main(String[] args)
	{
		Stack s = new Stack();
		s.push(1);
		s.push(2);
		s.push(3);
		
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}
}
