package codingInterview.TreesAndGraphs;

import datastructure.BinaryTree;
import datastructure.BinaryTree.Node;

public class Question4e
{
	public static void main(String[] args)
	{
		BinaryTree<Object> bt = new BinaryTree<Object>();
		Node n1 = bt.makeBT(7, null, null);
		Node n2 = bt.makeBT(5, null, null);
		Node n3 = bt.makeBT(3, null, null);
		Node n4 = bt.makeBT(1, null, null);
		Node n5 = bt.makeBT(6, n2, n1);
		Node n6 = bt.makeBT(2, n4, n3);
		Node n7 = bt.makeBT(4, n6, n5);
		
		System.out.println(isBST(n7, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}
	
	public static boolean isBST(Node<Integer> node, int min, int max)
	{
		/** 초기 사례 */
		if (node == null) return true;
		
		/** min < node.item < max 확인 */
		
		if ( !(min < node.item && node.item < max))
			return false;
		
		return isBST(node.left, min, node.item) && isBST(node.right, node.item, max); 
	}
}
