package test;

import java.util.ArrayList;
import java.util.List;

public class ListContainsTest2 {
	public static void main(String[] args) {

		List<FriendPair> list = new ArrayList<FriendPair>();
		
		FriendPair f = new FriendPair();
		f.pair = "0 1";
		list.add(f);
		
		for (FriendPair ff : list) {
			System.out.println(ff.pair.equals("0 1"));
		}
		
	}
}

class FriendPair
{
	String pair;
	boolean picked;
}
