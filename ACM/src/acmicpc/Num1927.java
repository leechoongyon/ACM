package acmicpc;

import java.util.Scanner;

/**
 * @author USER
 *
 *	x 가 0이면 배열에서 가장 작은 값을 출력하고 그 값을 배열에서 제거
 *	x 가 자연수라면 배열에 x라는 값을 넣는 연산
 */
public class Num1927
{
	public static void main(String[] args)
	{
		/*Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0 ; i < N ; i++)
		{
			
		}*/
		
		HeapStructure heap = new HeapStructure(8);
		heap.insert(2);
		heap.insert(5);
		heap.insert(1);
		heap.insert(3);
		heap.insert(7);
		heap.insert(4);
		heap.insert(8);
		heap.insert(6);
		for (int num : heap.arr)
		{
			System.out.print(num + " ");
		}
	}
}

/**
 * @author USER
 *
 *	최소 힙
 *	1. 루트는 가장 작은 수여야 한다.
 *	2. 완전이진트리 조건을 만족한다.
 *	3. 부모는 자식보다 작아야 한다.
 */
class HeapStructure
{
	int arr[];
	int point = 0; 
	
	public HeapStructure(int size)
	{
		arr = new int[size];
	}
	
	public void insert(int x)
	{
		arr[point] = x;
		/**
		 * 부모 노드 비교
		 * 짝수면 point/2 - 1, 홀수면 point/2 
		 */
		if (point == 0)
		{
			point++;
			return;
		}
		else
		{
			// 홀수
			if (point % 2 == 1)
			{
				// 자식이 부모보다 작으면 교체
				if (arr[point/2] > arr[point])
				{
					int temp = arr[point];
					arr[point] = arr[point/2];
					arr[point/2] = temp;
				}
			}
			// 짝수
			else
			{
				if (arr[(point/2) - 1] > arr[point])
				{
					int temp = arr[point];
					arr[point] = arr[point/2 - 1];
					arr[point/2 - 1] = temp;
				}
			}
			point++;
		}
	}
}
