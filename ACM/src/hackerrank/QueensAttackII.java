package hackerrank;

import java.util.Scanner;

/**
 * @author lee
 *
 *
 *	1. Queen 이 공격할 수 있는 위치가 몇 개 인지?
 *	2. 장애물이 존재하며, Queen 은 장애물이 있으면 해당 장소와 그 외 영역을 공격 못함.
 */
public class QueensAttackII
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int k = in.nextInt();
		
		int board[][] = new int[n][n];
		int rq = in.nextInt() - 1;
		int cq = in.nextInt() - 1;
		
		int mid = n/2;
		if (rq > mid)
			rq = rq - Math.abs(rq-mid) * 2;
		else if (rq < mid)
			rq = rq + Math.abs(rq-mid) * 2;
		
		for (int i = 0 ; i < k ; i++)
		{
			int row = in.nextInt() - 1;
			int col = in.nextInt() - 1;
			
			if (row > mid)
				row = row - Math.abs(row-mid) * 2;
			else if (row < mid)
				row = row + Math.abs(row-mid) * 2;
			
			board[row][col] = 1;
		}
		int result = solve(board, rq, cq);
		System.out.println(result);
	}
	
	public static int solve(int board[][], int rq, int cq)
	{
		/**
		 * 1. 여왕의 포지션 파악
		 * 2. 여왕의 포지션부터 각 케이스별로 공격가능한 위치 count 하기.
		 * 3. 장애물이 있으면 장애물이 있기전까지만 count
		 * 
		 * 5,5 --> 0,5 / 4,2 --> 1,1 / 2,3 --> 3,2 
		 * 
		 */
		
		int attackCount = 0;
		int rowMax = board.length - 1;
		int colMax = board[0].length - 1;
		
		// 왼쪽 위 대각선
		int rowAttackPos = rq;
		int colAttackPos = cq;
		rowAttackPos--; colAttackPos--;
		while(rowAttackPos >= 0 && colAttackPos >= 0)
		{
			if (board[rowAttackPos][colAttackPos] == 1)
				break;
			rowAttackPos--; colAttackPos--;
			attackCount++;
		}
		
		// 위쪽
		rowAttackPos = rq;
		colAttackPos = cq;
		rowAttackPos--;
		while (rowAttackPos >= 0)
		{
			if (board[rowAttackPos][colAttackPos] == 1)
				break;
			rowAttackPos--;
			attackCount++;
		}
		
		
		// 오른쪽 위 대각선
		rowAttackPos = rq;
		colAttackPos = cq;
		rowAttackPos--; colAttackPos++;
		while(rowAttackPos >= 0 && colAttackPos <= colMax)
		{
			if (board[rowAttackPos][colAttackPos] == 1)
				break;
			rowAttackPos--; colAttackPos++;
			attackCount++;
		}
		
		// 오른쪽
		rowAttackPos = rq;
		colAttackPos = cq;
		colAttackPos++;
		while(colAttackPos <= colMax)
		{
			if (board[rowAttackPos][colAttackPos] == 1)
				break;
			colAttackPos++;
			attackCount++;
		}
		
		// 오른쪽 아래 대각선
		rowAttackPos = rq;
		colAttackPos = cq;
		rowAttackPos++; colAttackPos++;
		while(rowAttackPos <= rowMax && colAttackPos <= colMax)
		{
			if (board[rowAttackPos][colAttackPos] == 1)
				break;
			rowAttackPos++; colAttackPos++;
			attackCount++;
		}
		
		// 아래
		rowAttackPos = rq;
		colAttackPos = cq;
		rowAttackPos++;
		while(rowAttackPos <= rowMax)
		{
			if (board[rowAttackPos][colAttackPos] == 1)
				break;
			rowAttackPos++;
			attackCount++;
		}
		
		// 왼쪽 아래 대각선
		rowAttackPos = rq;
		colAttackPos = cq;
		rowAttackPos++; colAttackPos--;
		while (rowAttackPos <= rowMax && colAttackPos >= 0)
		{
			if (board[rowAttackPos][colAttackPos] == 1)
				break;
			rowAttackPos++; colAttackPos--;
			attackCount++;
		}
		
		// 왼쪽
		rowAttackPos = rq;
		colAttackPos = cq;
		colAttackPos--;
		while (colAttackPos >= 0)
		{
			if (board[rowAttackPos][colAttackPos] == 1)
				break;
			colAttackPos--;
			attackCount++;
		}
		return attackCount;
	}
	
	public static void print(int board[][])
	{
		for (int r = 0 ; r < board.length ; r++)
		{
			for (int c = 0 ; c < board[0].length ; c++)
			{
				System.out.print(board[r][c] + " ");
			}
			System.out.println();
		}
	}
}
