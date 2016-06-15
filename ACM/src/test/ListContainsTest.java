package test;

import java.util.Scanner;

public class ListContainsTest {
	public static void main(String[] args) {

		
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		String temp[] = str.split(" ");
		System.out.println("temp : " + temp[0]);
		System.out.println("temp : " + temp[1]);
		System.out.println("temp : " + temp[2]);
		
		/*System.out.println("str : " + str);
		
		String str1 = scan.next(); 
		System.out.println("str : " + str1);
		str1 = scan.next();
		System.out.println("str : " + str1);
		str1 = scan.next();
		System.out.println("str : " + str1);
		str1 = scan.next();
		System.out.println("str : " + str1);*/
		
		/*System.out.println(BigInteger.ZERO);
	
		Data d = new Data();
		d.name = "ddd"; d.num = 111;
		List<Data> list = new ArrayList<Data>();
		list.add(d);
		d = new Data();
		d.name = "eee"; d.num = 222;
		list.add(d);
		
		for (Data ddd : list) {
			System.out.println("ddd.name : " + ddd.name);
			System.out.println("ddd.num : " + ddd.num);
		}*/
		
		
		/*List<StringBuilder> list = new ArrayList<StringBuilder>();
		StringBuilder s =  new StringBuilder();
		s.append("a"); s.append("b");
		list.add(s);
		s.delete(0, s.length());
		System.out.println("list : " + list);*/
		
		/*String a = "a";
		List<String> list = new ArrayList<String> ();
		list.add(a);
		a = "b";
		list.add(a);
		System.out.println("list : " + list);*/
	}
}


class Data {
	int num;
	String name;
}