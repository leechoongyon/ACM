package solveProblemsExample;

import java.util.LinkedList;

/**
 * @author	: 2013BWG-02
 * @date	: 2014. 6. 22.
 * @desc	: TSP - Optimization Question
 * 
 * 
 * 자료구조 : LinkedList를 선택한 이유는 list안에서 특정 단어를 검색하는게 아니라 경로를 저장하는 자료구조로 사용되므로
 * 
 * 경로가 지워졌다 삽입됬다 반복되므로 LinkedList를 선택했다. LinkedList는 내부정보만을 가지고 있음. 내부 인덱스 정보가 없어서 데이터 검색하는데는 잘 안쓰임.
 * 
 * 만약 대량의 데이터에서 특정 단어를 검색하는거라면 ArrayList를 사용하자.
 * 
 * 
 * 
 * 변경 내용
 * 
 * 1. 휴리스틱 가지치기 이용
 * 
 * 2. best < currentLength라면 뒤에 남아있는 계산을 진행할 필요가 없다.
 * 
 * 3. 경로까지 구하고 싶으면 if ( best < currentLength ) 부분에 List.clone() 사용  
 * 
 */
public class Q3_TSP 
{
	static int n = 4;
	static int distance[][] = new int[n][n];
	
	static int best = Integer.MAX_VALUE;
	
	
	public static void main(String[] args) 
	{
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		boolean taken[] = new boolean[n];
		
		int currentLength = 0;

		// 0번째 도시부터 시작
		list.add(0); taken[0] = true;
		
		setUp();
		
		recursiveTSP(taken, list, currentLength);
		
		System.out.println("best : " + best);
	}
	
	public static void recursiveTSP(boolean taken[], LinkedList<Integer> list, int currentLength)
	{
		
		if ( best < currentLength ) 
			return;
		
		if ( list.size() == n) {
			best = Math.min(best, currentLength);
		}
		
		int here = list.getLast();
		
		for ( int next = 0 ; next < taken.length ; next++) {
			
			if (!taken[next]) {
				list.add(next);
				taken[next] = true;
				recursiveTSP(taken, list,  currentLength + distance[here][list.getLast()]);
				list.removeLast();
				taken[next] = false;
			}
		}
	}
			
			
	
	public static void setUp()
	{
		distance[0][1] = 1; distance[0][2] = 2; distance[0][3] = 3;
		distance[1][0] = 1; distance[1][2] = 5; distance[1][3] = 6;
		distance[2][0] = 2; distance[2][1] = 5; distance[2][3] = 7;
		distance[3][0] = 3; distance[3][1] = 6; distance[3][2] = 7;
	}
}
