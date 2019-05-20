package codility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.Map;
import java.util.TreeMap;


/**

A = [4,2,1], B = [2,5,3], F = 2

[input]
3 2
4
2
1
2
5
3

[output]
10

 */
public class MaxSumContributions
{ 
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] temp = line.split(" ");
		int n = Integer.parseInt(temp[0]); 
		int F = Integer.parseInt(temp[1]);
		int[] A = new int[n];
		int[] B = new int[n];
		for (int i = 0 ; i < n ; i++)
		{
			A[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 0 ; i < n ; i++)
		{
			B[i] = Integer.parseInt(br.readLine());
		}
		
		System.out.println(solution(A, B, F));
	}
	
	public static int solution(int[] A, int[] B, int F)
	{
		/**
		 * 	문제 : n 명을 뽑고, 2팀으로 나눔. F 개발자 명수가 주어졌을 때,
         	어떻게 팀을 나눠야 가장 효율성있는 팀이 되는가?
         
	         sol1. brute-force
	         F 갯수만큼 모든 A 조합을 뽑는다. 그런 뒤, B 에 가서 구해서 모든 sum 을 구함.
	         O(조합갯수)
	
	         sol2. diff 로 처리
	         1. 두 배열의 diff 를 구함. O(n)
	         2. 구한 diff 를 TreeMap 에 집어넣음. O(logn) / 이 때, value 에 의한 정렬을 해야 함.
	         3. TreeMap 에서 F 만큼 값을 가져 옴.
	         4. 가져온 값들에 대해 bitset 을 킴.
	         5. bitset 이 켜진 값들에 대해 A 를 조회하고, bitset 이 안켜진 값들에 대해 B 를 조회함. 
		 */
		
		int n = A.length;
		int pos = 0;
		BitSet bit = new BitSet(n);
		Map<Integer, Integer> map = new TreeMap<>();
		int[] diff = new int[n];
		for (int i = 0 ; i < n ; i++)
			diff[i] = A[i] - B[i];
	
		for (int i = 0 ; i < n ; i++)
		{
			map.put(i,  diff[i]);
		}
		
		for (int key : map.keySet())
		{
			if (pos == F) break;
			bit.set(pos);
			pos++;
		}
		
		return 0;
	}
}
