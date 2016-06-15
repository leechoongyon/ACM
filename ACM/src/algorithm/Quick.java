package algorithm;



/**
 * @author lee
 *
 *	3 8 0 2 1 4
 *  
 * 	1 8 0 2 1 4
 *  1 8 0 2 8 4
 *  1 2 0 2 8 4
 *  
 */
public class Quick
{
	public static void main(String [] args)
	{
		int num[] = { 3, 8, 0, 2, 1, 4 };
		quickSort(num, 0, num.length - 1);
	}
	
	public static void quickSort(int num[], int left, int right)
	{
		int pivot = 0;
		
		while (left < right)
		{
			pivot = num[0];
			
			while (num[right] > pivot && left < right)
				right--;
			
			num[left] = num[right];
			
			while (num[left] < pivot && left < right)
				left++;
			
			num[right] = num[left]; 
		}
		
	}
}
