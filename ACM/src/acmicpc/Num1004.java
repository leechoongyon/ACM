package acmicpc;

import java.util.Scanner;

public class Num1004
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int x1, y1, x2, y2, n;
		Planet planet;
		for (int i = 0 ; i < T ; i++)
		{
			x1 = sc.nextInt();
			y1 = sc.nextInt();
			x2 = sc.nextInt();
			y2 = sc.nextInt();
			
			n = sc.nextInt();
			
			planet = new Planet(sc.nextInt(), sc.nextInt(), sc.nextInt());
			
		}
	}
}

class Planet
{
	int cx;
	int cy;
	int r;
	
	public Planet(int cx, int cy, int r)
	{
		this.cx = cx;
		this.cy = cy;
		this.r = r;
	}
}
