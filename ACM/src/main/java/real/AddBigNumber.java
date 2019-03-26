package real;

import java.util.Scanner;

/**
 * @author lee
 *
 *	큰 수 더하기
 *	
 */
public class AddBigNumber
{
	public static void main(String [] args)
	{
		Scanner scan = new Scanner(System.in);
		String a = scan.next();
		String b = scan.next();
		
		System.out.println(solve(a,b));
	}
	
	private static String solve(String a, String b)
	{
		String reverseA = reverse(a);
		String reverseB = reverse(b);
		StringBuilder result = new StringBuilder();
		int aLen = a.length();
		int bLen = b.length();
		int len = aLen > bLen ? aLen : bLen;
		int sum = 0;
		int up = 0;
		/**
		 * 	
		 * 	case by case
		 * 	1. 각각의 자리수가 틀릴 때
		 * 	2. 각각의 자리수가 같을 때
		 * 
		 */
		for (int i = 0 ; i < len ; i++)
		{
			if (aLen > i)
				sum += Character.getNumericValue(reverseA.charAt(i));
			if (bLen > i)
				sum += Character.getNumericValue(reverseB.charAt(i));
			if (up == 1)
			{
				sum += 1;
				up = 0;
			}
			if (sum >= 10)
			{
				sum %= 10;
				up += 1;
			}
			result.append(String.valueOf(sum));
			sum = 0;
		}
		
		if (up == 1)
			result.append(1);
		
		return result.reverse().toString();
	}
	
	private static String reverse(String str)
	{
		StringBuilder sb = new StringBuilder();
		for (int i = str.length() - 1 ; i >= 0 ; i--)
			sb.append(str.charAt(i));
		return sb.toString();
	}
}
