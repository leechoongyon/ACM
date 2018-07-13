package test;

import java.util.Random;
import java.util.ArrayList;

public class BitOpertaionSubset
{
	public static void main(String [] ar)
	{
		BitOpertaionSubset ex = new BitOpertaionSubset();
		Random rand = new Random();

		int arrayLength = 3;
		int [] intArray = new int [arrayLength];

		int temp;
		/*boolean dupCheck = false;
		for (int index = 0; index < arrayLength; index++)
		{
			do
			{
				temp = rand.nextInt(21) - 10;
				// 중복된 숫자 있는지 체크
				dupCheck = false;
				for (int index2 = 0; index2 < index; index2++)
				{
					if (intArray[index2] == temp)
					{
						dupCheck = true;
						break;
					}
				}
			}
			while (dupCheck);

			intArray[index] = temp;
		}*/

		intArray[0] = -1; intArray[1] = -2 ; intArray[2] = 3;
		
		System.out.print("intArray => ");
		ex.printArray(intArray);
		ex.calcSumZero(intArray, arrayLength);
	}

	public void calcSumZero(int [] inputArray, int inputArrayLength)
	{
		int sum;
		ArrayList<Integer> subset = new ArrayList();
		int numSubset = 1 << inputArrayLength;
		
		/**
		 * 공집합은 제외
		 * numSubset 이 의미하는 바는 부분집합의 개수를 의미하며,
		 * i = 1 이라면 0001 이며, 이는 data[3] 을 뜻함.
		 */
		for (int i = 1; i < numSubset; i++)
		{
			sum = 0;
			subset.clear();
			for (int j = 0; j < inputArrayLength; j++)
			{
				/**
				 * numSubset 은 모든 부분집합의 개수를 의미
				 * numSubset 을 for 문으로 돌리며, 비트연산자가 일치하는 부분이있으면
				 * 부분집합에 해당 원소가 포함이 된다는 의미이다.
				 * i = 001 이고, 1 << 0 = 1 이라면 ( i & ( 1 << j ) ) != 0 조건을 만족하는 것이고,
				 * 이는 i = 001 은 inputArray[length - 1 - j] 를 포함한다는 것이다.     
				 */
				if (( i & ( 1 << j ) ) != 0)
				{
					sum += inputArray[inputArrayLength - 1 - j];
					subset.add(inputArray[inputArrayLength - 1 - j]);
				}
			}

			if (sum == 0)
			{
				System.out.println(subset);
			}
		}
	}

	public void printArray(int [] array)
	{
		for (int item : array)
		{
			System.out.print(item + " ");
		}
		System.out.println();
	}
}
