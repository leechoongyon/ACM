package hackerrank;

import java.util.Scanner;

public class BiggerIsGreater
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String str[] = new String[n];
		for (int i = 0 ; i < n ; i++)
			str[i] = in.next();
		
		solve(str);
	}
	
	public static void solve(String str[])
	{
		/**
		 * 	맨 뒤에서부터 크기 비교해서 뒤에 알파벳이 앞에 것보다 크면 swap
		 * 	while 문 걸어서 하기
		 */
	}
}
