package test;

import java.util.HashSet;
import java.util.Set;

public class SetTest
{
	public static void main(String [] args)
	{
		Set<Integer> set = new HashSet<Integer>();
		System.out.println(set.add(1));
		System.out.println(set.add(1));
		System.out.println(set.add(1));
		System.out.println(set.add(1));
		System.out.println(set.size());
	}
}
