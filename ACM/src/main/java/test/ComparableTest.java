package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableTest
{
	public static void main(String [] args)
	{
		Person p1 = new Person(20, "a");
		Person p2 = new Person(15, "b");
		Person p3 = new Person(100, "c");
		Person p4 = new Person(50, "d");
		
		List<Person> list = new ArrayList<>();
		list.add(p1); list.add(p2); list.add(p3); list.add(p4);
		Collections.sort(list);
		
		for (Person p : list)
			System.out.println(p);
	}
	
	public static class Person implements Comparable<Person>
	{
		int age;
		String name;
		public Person(int age, String name)
		{
			super();
			this.age = age;
			this.name = name;
		}
		@Override
		public String toString()
		{
			return "Person [age=" + age + ", name=" + name + "]";
		}

		@Override
		public int compareTo(Person o)
		{
			// 오름차순
			return Integer.compare(age, o.age);
			
//			 내림차순
//			return Integer.compare(o.age, age);
		}
	}
}
