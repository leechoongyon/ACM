package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.eclipsesource.json.JsonArray;

public class LongestSubstring
{
	@SuppressWarnings("deprecation")
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
	
	public static class Solution 
	{
		public int lengthOfLongestSubstring(String s) 
		{
			/**
			 * 	Sol1. brute-force
			 * 	1. 문자열의 시작점을 지정
			 * 	2. 시작 지점부터 순회하며, 문자를 버퍼에 집어넣음.
			 * 	3. 같은 문자가 버퍼에 들어있다면 멈춘 후, maxLLongestLength 와 값 비교
			 * 	4. 시간복잡도 O(n제곱)
			 * 
			 * 	Sol2. 시작점 각각에 대해서 longestLength 를 관리
			 * 	1. 순회하며 각 자릿수에 대해 버퍼에 집어넣음.
			 * 	2. 이 버퍼는 각 자릿수의 알파벳과 logestLength 를 가지고 있으며
			 * 	3. 같은 문자가 들어왔을 때, 멈추는 기능도 있어야 함.
			 * 	4. 즉, 누적적으로 쌓으며 진행
			 * 	5. 시간복잡도 O(n)
			 */
			
			List<CharacterStrcture> list = new ArrayList<>();
			for (char c : s.toCharArray())
			{
				if (list.)
				list.add(new Character)
			}
			
			return 0;
		}
	}
	
	public static class CharacterStrcture
	{
		int length;
		char c;
	}
}

