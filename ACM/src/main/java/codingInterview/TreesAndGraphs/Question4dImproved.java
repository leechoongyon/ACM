package codingInterview.TreesAndGraphs;

import datastructure.BinaryTree;
import datastructure.BinaryTree.Node;

public class Question4dImproved
{
	public static void main(String[] args)
	{
		BinaryTree tree = new BinaryTree();
		Node n1 = tree.makeBT("G", null, null);
		Node n2 = tree.makeBT("F", null, null);
		Node n3 = tree.makeBT("E", null, null);
		Node n4 = tree.makeBT("D", null, null);
		Node n5 = tree.makeBT("C", n2, n1);
		Node n6 = tree.makeBT("B", n4, n3);
		Node n7 = tree.makeBT("A", n6, n5);
		System.out.println(isBalance(n7));		
	}
	
	public static boolean isBalance(Node root)
	{
		return checkHeight(root) != Integer.MIN_VALUE;
	}
	
	public static int checkHeight(Node root)
	{
		if (root == null) return -1;
		int leftHeight = checkHeight(root.left);
		if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		int rightHeight = checkHeight(root.right);
		if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		int heightDiff = Math.abs(leftHeight - rightHeight);
		if (heightDiff > 1) return Integer.MIN_VALUE;
		return Math.max(leftHeight, rightHeight) + 1;
	}
}
