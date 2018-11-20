package codingInterview.linkedlist;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import datastructure.Node;

public class Problem2h
{
	public static void main(String [] args)
	{
		Scanner scan = new Scanner(System.in);
		int n1 = scan.nextInt();
		Node node = null;
		for (int i = 0 ; i < n1 ; i++)
		{
			if (node == null)
				node = new Node(scan.next());
			else
				node.appendTail(scan.next());
		}
		
		solve(node);
	}
	
	private static Node solve(Node node)
	{
		/**
		 * set 에다 집어넣음. 같은 순간 순환되는 부분의 첫째 노드임.
		 */
		
		Set<Node> set = new HashSet<Node>();
		
		boolean isSingle = false;
		
		while (node != null)
		{
			isSingle = set.add(node);
			if ( !isSingle)
				return node;
			node = node.next;
		}
		return node;
	}
}
