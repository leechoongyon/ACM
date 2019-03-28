package hackerrank;

import java.util.Scanner;

/**
 * @author USER
 *
 *	input : fvincndjrurfh
 *	output : fvincndjrurhf
 */


public class BiggerIsGreater
{
	private static StringBuilder rightAddition;
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		String[] w = new String[T];
		String result;
		for (int i = 0 ; i < T ; i++)
		{
			w[i] = scan.next();
		}
		
		for (String s : w)
		{
			rightAddition = new StringBuilder();
			System.out.println(solve(s));
		}
	}
	
	public static String solve(String s)
	{
		/**
		 *  문제의 의미 : 
		 *  - 다음 순으로 큰 알파벳을 구하라.
		 *  - 다음으로 큰게 없으면 no answer
		 *  
		 *  경우의 수 조사
		 *  1. 끝에서부터 앞의 문자랑 비교해 나감.
		 *     앞의 문자가 더 작다면 swap
		 *     abdc --> acbd 가 되야 하는데 swap 한 후에 뒤에거를 재 정비해줘야 함.
		 *     adcb --> bacd
		 *     abcde --> abced --> abdce --> abdec --> acbde --> acbed --> adbce -->
		 *     adbec --> adcbe
		 *  
		 *  
		 *  
		 *  Sol1. 있는 그대로 풀기
		 *  1. 마지막 문자 부터 -1 씩 위치의 문자와 비교하면서 swap 함.
		 *  2. swap 을 할 때, 일단 교체한 것이 가장 먼저 오고 그 뒤로 역순으로 배치 시킴.
		 *  - 이 방법으로 안 풀림.
		 *  
		 *  Sol2. 마지막 문자부터 시작해 작은 것과의 거리 체크.
		 *  
		 */
		String result;
		for (int i = s.length() - 1 ; i > 0 ; i--)
		{
			result = solve(s, i);
			if ( !result.equals("")) return result;
		}
		return "no answer";  
	}
	
	public static String solve(String s, int charPos)
	{
		StringBuilder result = new StringBuilder();
		StringBuilder leftAddition = new StringBuilder();
		if (charPos != s.length() -1) rightAddition.append(s.charAt(charPos + 1));
		char lastChar = s.charAt(charPos);
		char currChar;
		for (int i = charPos - 1 ; i >= 0 ; i--)
		{
			currChar = s.charAt(i);
			if (lastChar > currChar)
			{
				// swap 이 이루어진 후, 나머지 문자 배치
				result.append(s.substring(0, i));
				result.append(lastChar);
				result.append(rightAddition);
				result.append(currChar);
				result.append(leftAddition);
				break;
			}
			leftAddition.append(currChar);
		}
		return result.toString();
	}
}
