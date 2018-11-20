package codingInterview.linkedlist;

import datastructure.Node;

public class LinkedListUtils
{
	public static Node reverse(Node node)
	{
		Node head = node;
		Node curNode = null;
		Node tail = null;
		while (head != null)
		{
			curNode = head.next;
			head.next = tail;
			tail = head;
			head = curNode;
		}
		return tail;
	}
}
