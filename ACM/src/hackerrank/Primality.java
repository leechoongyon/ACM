package hackerrank;

import java.util.Scanner;

/**
 * @author lee
 *	
 * @desc 1과 자기 자신으로 나뉘는 수를 Prime 이라 한다.
 * ex) 1 - 1 (Not prime)
 *     2 - 1,2 (Prime)
 *     6 - 1,2,3,6 (Not prime)			
 */

public class Primality
{
	public static void main(String [] args)
	{
		 Scanner in = new Scanner(System.in);
	     int p = in.nextInt();
	     for (int pItr = 0 ; pItr < p ; pItr++)
	     {
	    	 int n = in.nextInt();
	    	 String result = solve(n);
	    	 System.out.println(result);
	     }
	}
	
	public static String solve(int n)
	{
		// result : Not prime or Prime 
		return null;
	}
}
