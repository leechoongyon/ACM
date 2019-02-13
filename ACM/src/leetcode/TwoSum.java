package leetcode;

import java.util.ArrayList;
import java.util.List;

public class TwoSum
{
	public static void main(String [] args)
	{
		int[] nums = {2,7,11,15};
		int target = 9;
		
		int[] res = twoSum(nums, target);
		System.out.println(res[0] + " " + res[1]);
	}
	
	public static int[] twoSum(int[] nums, int target)
	{
		int[] res; 
		/** 필요없는 값 잘라내기. */
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0 ; i < nums.length ; i++)
		{
			if (target >= nums[i])
				list.add(nums[i]);
		}
		
		for (int i = 0 ; i < list.size() ; i++)
		{
			res = twoSum(i, list, target);
			if (res != null) return res;
		}
		return null;
	}
	
	public static int[] twoSum(int start, List<Integer> list, int target)
	{
		int startVal = list.get(start);
		for (int i = start + 1 ; i < list.size() ; i++)
		{
			if ( (startVal + list.get(i)) == target)
				return new int[] {start, i};
		}
		return null;
	}
}
