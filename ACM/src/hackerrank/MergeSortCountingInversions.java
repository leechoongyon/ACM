package hackerrank;

import java.util.Scanner;

/**
 * @author lee
 *
 *         문제 : arr 가 주어졌을 때, 오름차순 정렬하기 위해 몇 번의 swap 이 필요한지?
 *
 *         1 5 2 1 3 1 2
 */
public class MergeSortCountingInversions
{
	private static long solve(int [] arr)
	{
		int copy[] = arr.clone();
		return solve(arr, 0, arr.length - 1, copy);
	}

	private static long solve(int [] arr, int lo, int hi, int [] copy)
	{
		if (lo >= hi)
			return 0;

		int mid = lo + ( hi - lo ) / 2;

		long count = 0;
		count += solve(copy, lo, mid, arr);
		count += solve(copy, mid + 1, hi, arr);
		count += merge(arr, lo, mid, hi, copy);

		return count;
	}

	private static long merge(int [] arr, int lo, int mid, int hi, int [] copy)
	{
		long count = 0;
		int i = lo, j = mid + 1, k = lo;
		while (i <= mid || j <= hi)
		{
			if (i > mid)
			{
				arr[k++] = copy[j++];
			}
			else if (j > hi)
			{
				arr[k++] = copy[i++];
			}
			else if (copy[i] <= copy[j])
			{
				arr[k++] = copy[i++];
			}
			else
			{
				arr[k++] = copy[j++];
				count += mid + 1 - i;
			}
		}

		return count;
	}

	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int d = in.nextInt();
		for (int i = 0; i < d; i++)
		{
			int n = in.nextInt();
			int arr[] = new int [n];
			for (int j = 0; j < n; j++)
			{
				arr[j] = in.nextInt();
			}
			System.out.println(solve(arr));
		}
	}
}
