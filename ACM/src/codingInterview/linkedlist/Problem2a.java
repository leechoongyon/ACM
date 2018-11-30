package codingInterview.linkedlist;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

import datastructure.Node;

/**

5
3 4 2 1 3

 * @author lee
 *
 */

public class Problem2a
{
	public static void main(String [] args)
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Node node = null; 
		for (int i = 0 ; i < n ; i++)
		{
			if (node == null)
				node = new Node(scan.nextInt());
			else
				node.appendTail(scan.nextInt());
		}
		Node result = solve1(node);
		result.print();
	}
	
	/**
	 * 	1. node 를 순회하며, set 에 집어넣음.
	 * 	2. set 에 있는 것을 순회하며 노드를 만들어서 반환 
	 */
	private static Node solve(Node node)
	{
		Set set = new LinkedHashSet();
		Node result = null;
		while (node != null)
		{
			set.add(node.data);
			node = node.next;
		}
		
		Iterator iter = set.iterator();
		while (iter.hasNext())
		{
			int n = (Integer) iter.next();
			if (result == null)
				result = new Node(n);
			else
				result.appendTail(n);
		}
		return result;
	}
	
	/**
	 *
	 * 	버퍼 없이 풀기.
	 * 	1. node 를 순회하며, result 에 하나씩 넣기.
	 * 	2. result 에 넣기 전 해당 값이 result 에 존재하는지 확인.
	 * 	3. 존재하면 넣지 않고, 존재하지 않는다면 넣는다.
	 */
	private static Node solve1(Node node)
	{
		Node result = null;
		Node temp = null; 
		boolean isDuplicate = false; 
		
		if (node != null)
		{
			result = new Node(node.data);
			node = node.next;
		}
		
		while (node != null)
		{
			temp = result;
			Object item = node.data;
			while (temp != null)
			{
				if (item == temp.data)
				{
					isDuplicate = true;
					break;
				}
				temp = temp.next;
			}
			if ( !isDuplicate)
				result.appendTail(item);
			isDuplicate = false;
			node = node.next;
		}
		return result;
	}
}

