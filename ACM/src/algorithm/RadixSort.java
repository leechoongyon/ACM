package algorithm;

import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

public class RadixSort
{
	public static void main(String [] args)
	{
		Queue<Integer> bucket[] = new SynchronousQueue[9];
		bucket[0] = new SynchronousQueue<Integer>();
		bucket[1] = new SynchronousQueue<Integer>();
		bucket[2] = new SynchronousQueue<Integer>();
		bucket[3] = new SynchronousQueue<Integer>();
		bucket[4] = new SynchronousQueue<Integer>();
		bucket[5] = new SynchronousQueue<Integer>();
		bucket[6] = new SynchronousQueue<Integer>();
		bucket[7] = new SynchronousQueue<Integer>();
		bucket[8] = new SynchronousQueue<Integer>();
		
		int arr[] = new int[] {15,27,64,25,50,17,39,28};
		
		solve(bucket, arr, 2);
	}
	
	
	/**
	 * 	1. 버킷을 9개 만듬.
	 * 	2. 배열 중 가장 자릿수가 큰 것을 구함.
	 * 	3. 일의 자리부터 비교해서 버킷에 집어넣음.
	 * 	4. 버킷에 집어넣은 것을 0~9부터 순서대로 빼서 배열에 집어넣음.
	 * 	5. 십의 자리를 비교. 위에 반복.
	 * 	6. 배열 출력
	 */	
	public static void solve(Queue<Integer> bucket[], int arr[], int maxDigit)
	{
		int temp[] = new int[arr.length];
		int digit = 0;
		for (int i = 0 ; i < arr.length ; i++)
		{
			arr[i] 
		}
	}
}
