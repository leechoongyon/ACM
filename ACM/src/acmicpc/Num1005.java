package acmicpc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lee
 *
 * @desc
 * 	1. 건설순서 X Y 는 자료구조 어떤 것을 사용해야하는가?
 * 		- String
 * 		- Map
 * 		- 객체안에 담아두고 객체를 List 에 담기
 */
public class Num1005
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int D[];
		int W;
		List<BuildingOrder> list;
		BuildingOrder buildingOrder = null;
		for (int i = 0 ; i < T ; i++)
		{
			int N = sc.nextInt();
			int K = sc.nextInt();

			// 건설에 걸리는 시간 D
			for (int j = 0 ; j < N ; j++)
			{
				D = new int[N];
				D[j] = sc.nextInt();
			}
			
			// 건설순서 X Y
			list = new ArrayList<BuildingOrder>();
			
			for (int z = 0 ; z < K ; z++)
			{
				buildingOrder = new BuildingOrder(sc.nextInt(), sc.nextInt());
				list.add(buildingOrder);
			}
			
			W = sc.nextInt();

		}
	}
	
	public static int solve(int W, int D[], List<BuildingOrder> list)
	{
		int time = 0;
		
		for (BuildingOrder buildingOrder : list)
		{
			if (W == buildingOrder.Y)
			{
				time += D[buildingOrder.Y] + solve(buildingOrder.X, D, list);
			}
		}
		// 1. W 조건으로 앞의 순서 건물명 가져오기.
		// 2. 가져온 건물명의 소요시간 +
		// 3. 1~2번 반복
		
		return time;
	}
	
	public static void print(List<BuildingOrder> list)
	{
		for (BuildingOrder buildingOrder : list)
		{
			System.out.println(buildingOrder.X + " " + buildingOrder.Y);
		}
	}
}



class BuildingOrder
{
	int X;
	int Y;
	
	public BuildingOrder(int x, int y)
	{
		X = x;
		Y = y;
	}
}