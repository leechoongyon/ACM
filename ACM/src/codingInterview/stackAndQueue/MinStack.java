package codingInterview.stackAndQueue;

import java.util.EmptyStackException;

/**
 * @author lee
 *
 *
 *	min 값도 마찬가지로 stack 을 쓰는 이유는
 *	int 단일 값으로 써버리면, pop 을 했을 때, 계산하는 것이 오래 걸림.
 *	min 값을 stack 으로 해서 pop 을 했을 때, min stack 에 있는 값을 pop 하는거면 빼고 아니면 그냥 냅둠.
 */
public class MinStack
{
	public static class StackNode<T>
	{
		private T data;
		private StackNode next;

		public StackNode(T data)
		{
			this.data = data;
		}

		@Override
		public String toString()
		{
			return "StackNode [data=" + data + ", next=" + next + "]";
		}
	}
	
	private StackNode<Integer> top;
	private StackNode<Integer> min;
	
	public void push(int item)
	{
		// top 처리 (top 이 있는데 min 이 없을 순 없음.)
		StackNode<Integer> s = new StackNode(item);
		if (top == null)
		{
			top = s;
			min = s;
			return ;
		}
		s.next = top;
		top = s;
		
		// min 처리
		if (min.data > s.data)
		{
			StackNode<Integer> temp = new StackNode(item);
			temp.next = min;
			min = temp;
		}
	}
	
	public int pop()
	{
		// top 처리
		if (top == null)
			throw new EmptyStackException();
		int item = top.data;
		top = top.next;
		
		// min 처리
		if (min.data == item)
		{
			min.data = null;
			min = min.next;
		}
		
		return item;
	}
	
	public int getMinValue()
	{
		if (min == null)
			throw new EmptyStackException();
		return min.data;
	}

	@Override
	public String toString()
	{
		return "MinStack [top=" + top + ", min=" + min + "]";
	}
}
