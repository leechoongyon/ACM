package codingInterview.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import datastructure.Node;

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
		boolean result = solve(node);
		System.out.println(result);
	}
	
	private static boolean solve(Node node)
	{
		/**
		 * 1. NodeList 에 있는 것을 배열로 옮김.
		 * 2. 배열의 처음과 끝을 비교. 하나씩 더하거나 빼면서 서로 비교.
		 * 3. 길이가 홀수, 짝수 일 때 나눠서 처리
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
}
