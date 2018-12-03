package codingInterview.treeAndGraph;

/**
 *
 * 오름차순으로 정렬된 배열이 있다. 이 배열 안에 들어 있는 원소는 정수이며 중복된 값이 없다고 했을 때, 
 * 높이가 최소가 되는 이진 탐색 트리를 만드는 알고리즘 작성
 *
 *	1. 이진 탐색 트리란?
 *		- 모든 왼쪽 자식들 <= n < 모든 오른쪽 자식들

 */
public class Question4b
{
	private static Tree root = null;
	
	public static class Tree
	{
		int item;
		Tree left;
		Tree right;
		
		public Tree(int item)
		{
			this.item = item;
		}
		
		public void addChild(Tree tree, int item)
		{
			if (tree == null)
			{
				tree = new Tree(item);
				return ;
			}
			
			if (tree.item >= item)
			{
				if (tree.left == null)
				{
					Tree leftTree = new Tree(item);
					tree.left = leftTree;
					return ;
				}
				else
				{
					addChild(tree.left, item);
					return ;
				}
			}
			else if (tree.item < item)
			{
				if (tree.right == null)
				{
					Tree rightTree = new Tree(item);
					tree.right = rightTree;
					return ;
				}
				else
				{
					addChild(tree.right, item);
					return ;
				}
			}
		}

		@Override
		public String toString()
		{
			return "Tree [item=" + item + ", left=" + left + ", right=" + right + "]";
		}
		
		
	}
	
	public static void main(String [] args)
	{
		int arr[] = new int[] {1, 2, 3, 5, 7, 9, 11};
		solve(arr);
	}
	
	public static void solve(int arr[])
	{
		root = new Tree(1);
		for (int i = 1 ; i < arr.length ; i++)
		{
			root.addChild(root, arr[i]);
		}
		System.out.println(root);
	}
}
