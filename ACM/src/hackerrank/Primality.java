package hackerrank;

import java.util.Scanner;

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
