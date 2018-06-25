package test;

import java.util.Hashtable;

public class HashtableTest
{
	public static void main(String [] args)
	{
		Hashtable<Integer, Integer> hashtable = new Hashtable<Integer, Integer>();
		hashtable.put(1, 1);
		hashtable.put(1, 1);
		System.out.println(hashtable);
	}
}
