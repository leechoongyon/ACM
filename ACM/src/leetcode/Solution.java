package leetcode;

class Solution 
{
    public int[] twoSum(int[] nums, int target) 
    {
        
        /**
            1. brute-forces
                - O(n제곱)
            2. Hash
        */
        int[] res;
        for (int i = 0 ; i < nums.length ; i++)
        {
            res = internalTwoSum(i, nums, target);    
            if (res != null) return res;
        }
        return null;
    }
    public int[] internalTwoSum(int start, int[] nums, int target)
    {
        int startVal = nums[start];
        for (int i = start + 1 ; i < nums.length ; i++)
        {
            if ( (startVal + nums[i]) == target)
            {
                return new int[]{start, i};
            }
        }
        return null;
    }
    

}
