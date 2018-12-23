package codingInterview.bitOperation.Q5_02;

public class Question
{
	public static void main(String[] args)
	{
		double num = 0.72;
		System.out.println(convertBinaryToString(num));
	}
	
	public static String convertBinaryToString(double num)
	{
		/**
		 * 	1. num * 2 를 함. 
		 * 	2. 정수부를 제외 하고, 다시  곱하기 2를 함.
		 * 	3. 0이 될 때까지 곱하기 2를 함.
		 * 	
		 * 	* 문자열의 길이가 32 를 초과하면 return ERROR
		 */
		
		num = num * 2;
		System.out.println(num);
		return null;
	}
}
