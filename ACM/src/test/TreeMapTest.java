package test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author lee
 * 
10
f
h
a
a
h
d
c
f
b
i
 */
public class TreeMapTest
{

	public static void main(String... args)
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		String votes [] = new String [n];

		for (int i = 0; i < n; i++)
		{
			votes[i] = scan.next();
		}

		solve(votes, n);
	}

	public static String solve(String votes [], int n)
	{
		Map<String, Integer> map = new HashMap<String, Integer>();
		int value = 0;
		for (String vote : votes)
		{
			if (map.containsKey(vote))
			{
				value = map.get(vote);
				map.put(vote, value + 1);
			}
			else
				map.put(vote, 1);
		}

		
		Map sortedMap = sortByValues(map);
		System.out.println(sortedMap);
		
		return null;
	}

	public class ValueComparator implements Comparator<String>
	{

		private Map<String, Integer> map;

		public ValueComparator(Map<String, Integer> map)
		{
			this.map = map;
		}

		@Override
		public int compare(String o1, String o2)
		{
			System.out.println("compare");
			if (o1 != o2)
				return map.get(o1) - map.get(o2);
			return o1.compareTo(o2);
		}
	}

	public static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map)
	{
		Comparator<K> valueComparator = new Comparator<K>()
		{
			public int compare(K k1, K k2)
			{
				return map.get(k2).compareTo(map.get(k1));
				/*int compare = map.get(k1).compareTo(map.get(k2));
				if (compare == 0)
					return 1;
				else
					return compare;*/
			}
		};

		Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
		sortedByValues.putAll(map);
		return sortedByValues;
	}
}
