package algospot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * @author lee
 *
 *	1. 친구 쌍을 어떤 자료구조를 사용할까?
 *	2. 어떻게 풀까?
 */
public class PICNIC
{
	public static void main(String [] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int testCaseNum = Integer.parseInt(br.readLine().trim());
        int n, m;
        String [] pairs;
        for (int i = 0 ; i < testCaseNum ; i++)
        {
        	st = new StringTokenizer(br.readLine().trim(), " ");
        	n = Integer.parseInt(st.nextToken());
        	m = Integer.parseInt(st.nextToken());
        	pairs = new String[m];
        	for (int j = 0 ; j < m ; j++)
        	{
        		pairs[j] = br.readLine();
        	}
        	
        	System.out.println(pairs);
        }
    	
	} 
	
}