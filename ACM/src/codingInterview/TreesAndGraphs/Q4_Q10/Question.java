package codingInterview.TreesAndGraphs.Q4_Q10;

import datastructure.BinaryTree;
import datastructure.BinaryTree.Node;

public class Question
{
	public static void main(String [] args)
	{
		BinaryTree<String> tree = new BinaryTree<String>();
		Node n1 = tree.makeBT("7", null, null);
		Node n2 = tree.makeBT("6", null, null);
		Node n3 = tree.makeBT("5", null, null);
		Node n4 = tree.makeBT("4", null, null);
		Node n5 = tree.makeBT("3", n2, n1);
		Node n6 = tree.makeBT("2", n4, n3);
		Node n7 = tree.makeBT("1", n6, n5);
		Node n8 = tree.makeBT("0", null, null);
		System.out.println(isSubTree(n7, n1)); // true
		System.out.println(isSubTree(n7, n8)); // false
	}
	
	public static boolean isSubTree(Node t1, Node t2)
	{
		StringBuilder s1 = new StringBuilder();
		StringBuilder s2 = new StringBuilder();
		
		preOrder(s1, t1);
		preOrder(s2, t2);
		
		return (s1.indexOf(s2.toString()) != -1);
	}
	
	public static void preOrder(StringBuilder sb, Node tree)
	{
		if (tree == null)
		{
			sb.append("X");
			return ; 
		}
		
		sb.append(tree.item);
		preOrder(sb, tree.left);
		preOrder(sb, tree.right);
	}
}
