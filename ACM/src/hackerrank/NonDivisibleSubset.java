package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author lee
 *
 *         1. 부분집합 2개의 합은 k로 나뉘어선 안된다. 2. 부분집합 최대 개수를 구하고자 함. 3. 부분집합을 모두 구해서
 *         계산할려고 했는데 그렇게 되면 개수가 n 이라면 2의 n 승 -1 번을 계산해야하는 것이다. 이는 너무 비효율적이기에 비트
 *         연산자를 통해 부분집합을 구함이다.
 */
public class NonDivisibleSubset
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int [] arr = new int [k];

		for (int i = 0; i < n; i++)
			arr[sc.nextInt() % k]++;

		int result = 0;
		if (k % 2 == 0)
			result++; // it will not have any conjugate pair
		result = result + Math.min(arr[0], 1);// If no number wholly divisible dont add it to pair else add once
		for (int j = 1; j <= k / 2; j++)
			if (j != k - j)
				result += Math.max(arr[j], arr[k - j]);
		System.out.println(result);
	}

}
