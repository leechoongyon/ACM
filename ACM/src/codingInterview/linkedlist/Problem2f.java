package codingInterview.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import datastructure.Node;

/**

9
1 2 3 4 5 4 3 2 1

 * @author lee
 *
 */

public class Problem2f
{
	public static void main(String[] args)
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
		boolean result = solve2(node);
		System.out.println(result);
	}
	
	private static boolean solve(Node node)
	{
		/**
		 * sol1
		 * 1. NodeList 에 있는 것을 배열로 옮김.
		 * 2. 배열의 처음과 끝을 비교. 하나씩 더하거나 빼면서 서로 비교.
		 * 3. 길이가 홀수, 짝수 일 때 나눠서 처리
		 * 
		 * 
		 * sol2
		 * 1. head node, end node 를 둔다.
		 * 2. head node 와 end node 의 값을 비교하면서 내려옴.
		 * 3. 종료 조건은 node 의 length / 2 를 초과했는지 안했는지 판단.
		 * 
		 * ex) 1 2 3 4 5 4 3 2 1 (9 - 홀수) 라면 마지막까지 비교할필요 없음.
		 * 	   1 2 3 4 5 5 4 3 2 1 (10 - 짝수) 라면 마지막까지 비교해야 함. 
		 */
		List list = new ArrayList();
		while (node != null)
		{
			list.add(node.data);
			node = node.next;
		}
		
		Object obj[] = list.toArray();
		int start = 0;
		int end = list.size() - 1;
		// 홀수
		if (list.size() % 2 == 1)
		{
			while (start != end)
			{
				if ( !obj[start].equals(obj[end]))
					return false;
				start++; end--;
			}
		}
		// 짝수
		else 
		{
			while (start < end)
			{
				if ( !obj[start].equals(obj[end]))
					return false;
				start++; end--;
			}
		}
		return true;
	}
	
	private static boolean solve1(Node node)
	{
		/**
		 * 
		 * * 길이를 입력 값으로 받지 않는다 가정.
		 * 
		 * 1. 절반을 탐색?
		 * 		- 홀수, 짝수 인지 구별
		 * 2. 뒤에 절반을 뒤집어서 LinkedList 에 집어넣는다.
		 * 3. 비교한다.
		 * 
		 * 
		 * 1 2 3 4 5 5 4 3 2 1   10 / 2 = 5
		 * 1 2 3 4 5 4 3 2 1 	  9 / 2 = 4
		 * 
		 */
		
		Node head = node;
		Node temp = node;
		Node midNode = node;
		Node reverse;
		int len = 0;
		while (temp != null)
		{
			len++;
			temp = temp.next;
		}
		
		int mid = 0;
		if (len % 2 == 1)
			mid = len / 2 + 1;
		else
			mid = len / 2;
		
		
		while (mid > 0)
		{
			midNode = midNode.next;
			mid--;
		}
		

		reverse = LinkedListUtils.reverse(midNode);
		System.out.println("head : " + head);

		System.out.println("reverse : " + reverse);
		
		while (reverse != null)
		{
			if (head.data != reverse.data)
				return false;
			reverse = reverse.next;
			head = head.next;
		}
		return true;
	}

	private static boolean solve2(Node node)
	{
		System.out.println("node : " + node);
		Stack stack = new Stack(); 
		
		Node temp = node;
		int len = 0;
		while (temp != null)
		{
			temp = temp.next;
			len++;
		}
		
		// 홀수
		/**
		 * 1 2 3 2 1
		 */
		int mid = 0;
		Node midNode = node;
		if (len % 2 == 1)
		{
			mid = len / 2;
			
			
			while (mid != 0)
			{
				stack.add(midNode.data);
				midNode = midNode.next;
				mid--;
			}
			
			System.out.println("stack : " + stack);
			
			midNode = midNode.next;
			
			while (midNode != null)
			{
				Object obj = stack.pop();
				if ( !obj.equals(midNode.data))
					return false;
				
				midNode = midNode.next;
			}
		}
		// 짝수
		/**
		 * 1 2 2 1
		 */
		else
		{
			mid = len / 2;
			
			while (mid != 0)
			{
				stack.add(midNode.data);
				midNode = midNode.next;
				mid--;
			}
			
			while (midNode != null)
			{
				Object obj = stack.pop();
				if ( !obj.equals(midNode.data))
					return false;
				
				midNode = midNode.next;
			}
		}
		return true;
	}
	
}
