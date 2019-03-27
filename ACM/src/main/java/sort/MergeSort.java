package sort;

public class MergeSort
{
	public static int [] sorted = new int [30];

	public static void mergeSort(int[] arr, int start, int end)
	{
		int middle;
		if (start < end)
		{
			middle = ( start + end ) / 2;
			mergeSort(arr, start, middle);
			mergeSort(arr, middle + 1, end);
			merge(arr, start, middle, end);
		}
	}

	public static void merge(int [] arr, int m, int middle, int n)
	{
		int i, j, k, t;

		i = m;
		j = middle + 1;
		k = m;

		while (i <= middle && j <= n)
		{
			if (arr[i] <= arr[j])
				sorted[k] = arr[i++];
			else
				sorted[k] = arr[j++];
			k++;
		}

		if (i > middle)
		{
			for (t = j; t <= n; t++, k++)
				sorted[k] = arr[t];
		}
		else
		{
			for (t = i; t <= middle; t++, k++)
				sorted[k] = arr[t];
		}

		for (t = m; t <= n; t++)
			arr[t] = sorted[t];
	}

	public static void main(String [] args)
	{
		int [] arr = { 69, 10, 30, 2, 16, 8, 31, 22 };
		MergeSort.mergeSort(arr, 0, arr.length - 1);
		for (int i : arr)
			System.out.print(i + " ");
	}

}
