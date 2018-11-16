package codingInterview.linkedlist;

import java.util.Scanner;

import datastructure.Node;

public class Problem2c
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
		solve(node);
	}
	
	private static void solve(Node node)
	{
		
	}
}
