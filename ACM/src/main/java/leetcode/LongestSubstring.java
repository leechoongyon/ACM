package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

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
			 * 	Sol2. Map 활용
			 * 	1. 순회하며 맵에 하나씩 집어넣기.
			 * 	2. Map 의 key : 문자, value 는 숫자 (문자의 위치)
			 * 	3. 순회하면서 Map 에 들어있나 확인. 존재한다면, key 를 가지고 뺸 후에 index 비교.
			 */
			int max = 0;
			int length = 0;
			int diff = 0;
			int abandon = -1;
			String buffer;
			/** 문자열 길이 0 일 때 */
			if (s.length() == 0) return 0;
			else if (s.length() == 1) return 1;
			else 
			{
				Map<Character, Integer> map = new HashMap<>();
				for (int i = 0 ; i < s.length() ; i++)
				{
					if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) > abandon)
					{
						diff = i - map.get(s.charAt(i));
						max = Math.max(max, length);
						if (diff == 1) 
						{
							map.clear();
							length = 1;
						}
						else 
						{
							length = diff;
							abandon = map.get(s.charAt(i));
						}
						map.put(s.charAt(i), i);
					}
					else
					{
						map.put(s.charAt(i), i);
						length++;
					}
				}
				return Math.max(length, max);
			}
		}
	}
}