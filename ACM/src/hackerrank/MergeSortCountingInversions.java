package hackerrank;

import java.util.Scanner;

/**
 * @author lee
 *
 *	문제 : arr 가 주어졌을 때, 오름차순 정렬하기 위해 몇 번의 swap 이 필요한지?
 */
public class MergeSortCountingInversions
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int d = in.nextInt();
		int arr[];
		for (int i = 0 ; i < d ; i++)
		{
			int n = in.nextInt();
			arr = new int[n];
			for (int j = 0 ; j < n ; j++)
			{
				arr[j] = in.nextInt();
			}
			System.out.println(solve(arr));
		}
	}
	
	/**
	 * @param arr
	 * @return
	 * @desc 
	 * 	1. brute-force
	 * 	   index = 0 부터 시작해서 이전 것보다 작다면 swap
	 * 	   5 4 3 2 1 일 경우 (1 * 2 * 3 .. n-1 * n ) n  = O(n제곱)
	 * 	
	 */
	public static int solve(int arr[])
	{
		return 0;
	}
}
