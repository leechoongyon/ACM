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
			curNode = head.next; // 현재 노드 보존
			head.next = tail;	// 뒤집기
			tail = head;	// 위에서 뒤집은걸 누적해서 tail 에 붙임.
			head = curNode;	// 다음에 빼올 값을 head 에 넣어둠.
		}
		return tail;
	}
}
