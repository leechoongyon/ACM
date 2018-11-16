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
		Node result = solve(node);
		result.print();
	}
	
	private static Node solve(Node node)
	{
		/**
		 * sol1. 전체 탐색 후, 중복되는 것 제거
		 * 
		 * - set 에 데이터를 넣어둠. 중복이면 제거.
		 * - O(n) + O(n)
		 */
		
		Set<Integer> set = new LinkedHashSet<Integer>();
		while (node != null && node.next != null)
		{
			set.add(node.data);
			node = node.next;
		}
		
		Iterator<Integer> iter = set.iterator();
		
		Node result = null;
		if (iter.hasNext())
			result = new Node(iter.next());
		while(iter.hasNext())
			result.appendTail(iter.next());

		return result;
	}
}

