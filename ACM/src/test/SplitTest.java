package test;

public class SplitTest {
	
	public static void main(String[] args) {
		
		String str = "xxwwwwwwxwwbb";
		
		for (String s : split(str))
			System.out.println(s);
	}
	
	public static String[] split(String in)
	{
		String quardrant[] = new String[4];
		String input = in.substring(1, in.length());
		
		System.out.println("input : " + input);
		
		int cnt = 1;
		StringBuilder strBuilder = new StringBuilder();
		int k = 0;
		
		for (int i = 0 ; i <= 3 ; i++)
		{
				do {
					char c = input.charAt(k++);
					if (c == 'x')
					{
						cnt += 4;
						strBuilder.append(c);
						cnt--;
					}
					else
					{	cnt--;
						strBuilder.append(c);
					}
					System.out.println("strBuilder : " + strBuilder.toString());
				} while(cnt != 0);
			cnt = 1;
			quardrant[i] = strBuilder.toString();
			strBuilder.delete(0, strBuilder.length());
			/*if (input.contains("x"))
			{
				do {
					if (c == 'x')
						cnt += 4;
					strBuilder.append(c);
					cnt--;
				} while(cnt != 0);
				quardrant[i] = strBuilder.toString();
				strBuilder.delete(0, strBuilder.length());
			}
			else
				quardrant[i] = input.substring(i, i+1);*/
				
		}
		return quardrant;
	}
}
