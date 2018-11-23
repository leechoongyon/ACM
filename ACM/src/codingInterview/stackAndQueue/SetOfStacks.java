package codingInterview.stackAndQueue;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class SetOfStacks
{
	public static class StackNode
	{
		private Object data;
		private StackNode next;
		public StackNode(Object item)
		{
			this.data = item;
		}
		@Override
		public String toString()
		{
			return "StackNode [data=" + data + ", next=" + next + "]";
		}
	}
	
	private StackNode top;
	private List<StackNode> storage;
	private int capacity = 0;
	private int topSize = 0;

	public SetOfStacks (int defaultSize)
	{
		capacity = defaultSize;
	}
	
	public void push(Object item)
	{
		StackNode t = new StackNode(item);
		
		if (top == null)
		{
			top = t;
			topSize++;
		}
		else
		{
			if (isFull())
			{
				expand(t);
				topSize = 1;
			}
			else
			{
				t.next = top;
				top = t;
				topSize++;
			}
		}
	}
	
	public Object pop()
	{
		/**
		 * 1. top == null 일 경우
		 * 		- storage 에 있는 top 을 가져옴.
		 * 		- storage 에도 없을 경우 EmptyStackException
		 * 2. top 에 데이터가 있을 경우
		 * 		- topSize--
		 * 		- return item
		 */
		
		Object item = null;
		
		if (top == null)
		{
			if (storage != null && storage.size() > 0)
			{
				top = storage.remove(storage.size() - 1);
				topSize = capacity;
				item = top.data;
				top = top.next;
			}
			else
			{
				throw new EmptyStackException();
			}
		}
		else
		{
			item = top.data;
			top = top.next;
		}
		return item;
	}
	
	public StackNode getTop()
	{
		return top;
	}
	
	public List<StackNode> getStorage()
	{
		return storage;
	}
	
	private boolean isFull()
	{
		return topSize == capacity;
	}
	
	private void expand(StackNode t)
	{
		if (storage == null)
			storage = new ArrayList<StackNode>();
		storage.add(top);
		top = t;
	}
	
	@Override
	public String toString()
	{
		return "SetOfStacks [top=" + top
				+ ", storage="
				+ storage
				+ ", capacity="
				+ capacity
				+ ", topSize="
				+ topSize
				+ "]";
	}
}
