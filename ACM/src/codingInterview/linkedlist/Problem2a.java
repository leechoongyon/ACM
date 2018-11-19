package codingInterview.linkedlist;

import java.util.HashSet;
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
	
	private static Node solve(Node node)
	{
		Set set = new HashSet();
		Node result = null;
		if (node.data != null)
		{
			result = new Node(node.data);
			set.add(node.data);
			node = node.next;
		}
		
		System.out.println("here");
		while (node != null)
		{
			System.out.println("1111");
			if ( !set.contains(node.data))
			{
				result.appendTail(node.data);
				set.add(node.data);
			}
				
			node = node.next;
		}
		return result;
	}
	
	private static Node solve1(Node node)
	{
		Node current = node;
		Node result = null;
		Node temp = null;
		
		boolean isInclude = false;
		
		while (current != null)
		{
			temp = result;
			while (temp != null)
			{
				if (current.data == temp.data)
				{
					isInclude = true;
					break;
				}
				temp = temp.next;
			}
			
			if ( !isInclude)
			{
				if (result == null)
					result = new Node(current.data);
				else
					result.appendTail(current.data);
			}
			isInclude = false;
			current = current.next;
		}
		return result;
	}
}

