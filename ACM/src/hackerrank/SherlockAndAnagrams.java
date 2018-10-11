package hackerrank;

import java.util.Scanner;

/**
 * @author lee
 *
 *	- 하나의 단어를 재조립하여 2개의 단어를 추출한다. 아나그램의 조합을 구하라.
 *	- 연속적이여야 함.
 *	- 완전히 똑같은 단어만 아니면 됨.
 *

2
ifailuhkqq
kkkk

 */
public class SherlockAndAnagrams
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String strArr[] = new String[n];
		for (int i = 0 ; i < n ; i++)
			strArr[i] = in.next();
		System.out.println(solve(strArr));
	}
	
	/**
	 * * brute force
	 * 		- 부분집합을 뽑아서 비교.
	 * 		- 조합을 전부 만들어서 메모리에 저장.
	 * 		- 하나씩 뺀 다음에, 나머지와 비교한다? N제곱이네.
	 * 
	 * 		- 뽑아내는 방법, 뽑아낸 것을 비교하는 방법을 생각해야할 것 같음.		
	 * 		
	 * * optimize 
	 * 		- 재조립된 단어를 더했는데 값이 같아?
	 * 			- 재조립된 단어를 어떻게 구하는가?
	 * 				- 조합을 돌려서 단어를 구성?
	 * 				- for 문을 돌려서 1,2... 개의 알파벳을 집어서 단어를 조립
	 * 		- 위에 값 조건이 맞을 때, 각각의 단어가 같은지 확인?
	 * 
	 * @param strArr
	 * @return
	 */
	private static int solve(String strArr[])
	{
		
		return 0;
	}
}
