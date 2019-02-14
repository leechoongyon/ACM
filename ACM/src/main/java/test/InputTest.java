package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InputTest 
{
	static int watch[] = new int[16];
	
	public static void main(String[] args) throws IOException 
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int cNum = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < cNum; i++) {
        	st = new StringTokenizer(br.readLine().trim(), " ");
        	for (int j = 0 ; j < 16 ; j++)
        		watch[j] = Integer.parseInt(st.nextToken());
        	for (int k = 0 ; k < watch.length ; k++)
        		System.out.print(watch[k] +" ");
        	System.out.println();
        }
        br.close();
        
	} 
	
	
	public static void print(char [][]board, int width, int height)
	{
		System.out.println("---print start---");
		for (int i = 0 ; i < width ; i++)
		{
			for (int j = 0 ; j < height ; j++)
				System.out.print(board[i][j]);
			System.out.println();
		}
		System.out.println("---print end---");
		System.out.println();
	}
}
