package programmers;

/**
 * @author lee
 * 
 * CBD [BACDE, CBADF, AECB, BDA] 2
 * 
 */

public class PrecedingSkill
{
	public static void main(String [] args)
	{
		String skill = "CBD";
//		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		String[] skill_trees = {"AECB"};
		int answer = new PrecedingSkill().solution1(skill, skill_trees);
		System.out.println(answer);
	}

	public int solution1(String skill, String[] skill_trees)
	{
		/** 
		 *	1. 선행트리 한 글자씩 순회
		 *	2. 한 글자씩 스킬트리와 비교.
		 *		1) 처음부터 글자가 일치하는 경우
		 *			- 일치할 경우 일치하는 인덱스 번호를 기록해두기.
		 *			- 다음 선행트리 한 글자를 비교해 나감. 
		 *				- 같은게 나왔다? 
		 *					- 그런데 이전 인덱스 번호보다 작다? 그러면 에러다.
		 *					- 이전 인덱스 번호보다 크면 인덱스 번호 변경
		 *				- 같은게 없음?
		 *					- 이후부터 선행트리의 글자가 스킬트리에 있는 경우 에러 
		 *		2) 처음부터 글자가 일치하지 않는 경우
		 *			- 뒤에 선행트리가 단 하나라도 나오면 안됨. (스킬트리를 bit 시켜놓고 bit 계산 하면 될듯)
		 *
		 *	시간복잡도 O(n)
		 */
		int markIndex = 0;
		int temp;
		char cc;
		int answer = 0;
		boolean isNotExistPrecedingSkill = false;
		for (String s : skill_trees)
		{
			markIndex = Integer.MIN_VALUE;
			for (int i = 0 ; i < skill.length() ; i++)
			{
				cc = skill.charAt(i);
				temp = s.indexOf(cc);
				if (temp != -1)
				{
					if (markIndex < temp)
					{
						markIndex = temp;
						if (i == skill.length() - 1) answer++;
					}
					else
					{
						break;
					}
				}
				else if (isNotExistPrecedingSkill)
				{
					break;
				}
				else
				{
					if (i == skill.length() - 1) answer++;
					isNotExistPrecedingSkill = true;
				}
			}
		}
		return answer;
	}
	
	public int solution(String skill, String [] skill_trees)
	{
		/**
		 * 	스킬트리가 주어졌을 때, 순서대로 진행하면 배울 수 있는지 체크
		 * 	단, 스킬트리에는 선행 스킬이 있어 선행스킬을 배우지 않았으면 못배움.
		 * 	선행스킬, 스킬트리 중복 안되고 대문자임. (26자)
		 *
		 *
		 *	Sol1
		 * 	1. 스킬트리 순회 O(n)
		 * 	2. 선행트리에 있는지 확인 
		 * 		- 선행 트리에 있음.
		 * 			- 있는데 이전 선행 스킬을 안 배움 (불가능)
		 * 			- 있는데 이전 선행 스킬을 배움 (가능)
		 * 		- 선행 트리에 없음. (가능)
		 * 
		 *	선행트리에 대해서 비트를 다 on 시킨 후, 
		 *	스킬트리를 순회하며 해당 스킬이 선행 트리에 있는지 확인. O(1)
		 *	있으면 이전 bit 가 켜진 것이 있는지 확인. 만약 켜져있다면, 배울 수 없음. 
		 *		- 해당 position 이하의 비트를 모두 on 시킨 후, 선행 트리랑 비교. 값이 1이상이면, 못 배움.
		 *		- 2의 i 승을 한 후, -1 을 해 줌. 
		 *	 
		 * 
		 * 	Sol2
		 * 	1. 선행트리 순회
		 * 	
		 * 
		 */
		
		int answer = 0;
		int skillBit = 0;
		int tempBit = 0;
		char c;
		for (char cc : skill.toCharArray())
		{
			skillBit = skillBit | 1 << (cc - 'A');
		}
		
		for (String s : skill_trees)
		{
			tempBit = skillBit;
			for (int i = 0 ; i < s.length() ; i++)
			{
				c = s.charAt(i);
				/** 선행 트리에 있음. */
				if (isOnBit(tempBit, c - 'A'))
				{
					/** 이전 스킬 트리를 다 배웠는지 확인 */
					if (isOnPrecedingBit(tempBit, (c - 'A')))
					{
						tempBit = clearBit(tempBit, i);
						if (i == s.length() - 1) answer++;
					}
					else
					{
						/** 이전 스킬 트리를 못배웠으면 break. */
						break;
					}
				}
				else
				{
					/** 선행 트리에 없으면 넘어 감. */
				}
			}
		}
		
		return answer;
	}
	
	private boolean isOnBit(int num, int i)
	{
		return ((num & (1 << i)) != 0);
	}
	
	private boolean isOnPrecedingBit(int num, int i)
	{
		System.out.println("num : " + num);
		int temp = (int) Math.pow(2, i) - 1;
		System.out.println("tepm : " + temp);
		System.out.println(num & temp);
		return (temp & num) != 0; 
	}
	
	private int clearBit(int num, int i)
	{
		int mask = ~(1 << i);
		return num & mask;
	}
	
}
