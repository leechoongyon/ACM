package hackerrank;

import java.util.Scanner;

/**
 * @author lee
 *
 *	1. 부분집합 2개의 합은 k로 나뉘어선 안된다.
 *	2. 부분집합 최대 개수
 */
public class NonDivisibleSubset
{ 
	private static int arr[];
	private static boolean visited[]; 
	
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		
		arr = new int[n];
		visited = new boolean[n];
		for (int i = 0 ; i < n ; i++)
			arr[i] = in.nextInt();

		subSet(n, 0);
	}
	
	public static void subSet(int n, int depth)
	{
		if (n == depth)
		{
			for (int i = 0 ; i < n ; i++)
			{
				if (visited[i] == true) 
				{
					System.out.print(arr[i] + " ");
					// res 에 집어넣고
				}
			}
			// 여기서 res 검증해야겠네
			System.out.println();
			return ;
		}
		visited[depth] = true;
		subSet(n, depth + 1);
		visited[depth] = false;
		subSet(n, depth + 1);
	}
}
