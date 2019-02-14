package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestSubstring
{
	public static String stringToString(String input)
	{
		return JsonArray.readFrom("[" + input + "]").get(0).asString();
	}

	public static void main(String [] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while (( line = in.readLine() ) != null)
		{
			String s = stringToString(line);

			int ret = new Solution().lengthOfLongestSubstring(s);

			String out = String.valueOf(ret);

			System.out.print(out);
		}
	}
}

class Solution 
{
    public int lengthOfLongestSubstring(String s) 
    {
        
    }
}
