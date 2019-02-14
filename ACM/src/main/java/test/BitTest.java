package test;

public class BitTest
{

	/**
	 * 옵션상태중 특정 옵션을 활성화시킵니다.
	 * 
	 * @param options
	 *            옵션상태
	 * @param enable
	 *            활성화할 옵션
	 * @return 활성화 적용된 옵션상태
	 * @category
	  
	  */
	public static int optionEnable(int options, int enable)
	{
		return options | enable;
	}// method

	/**
	 * 옵션상태중 특정 옵션을 비활성화시킵니다.
	 * 
	 * @param options
	 *            옵션상태
	 * @param disable
	 *            비활성화할 옵션
	 * @return 비활성화 적용된 옵션상태
	 * @category
	  
	  */
	public static int optionDisable(int options, int disable)
	{
		return options & ~disable;
	}// method

	/**
	 * 옵션상태에 대해 해당 옵션이 활성화되어있는지 확인합니다.
	 * 
	 * @param options
	 *            옵션상태
	 * @param check
	 *            체크할 옵션
	 * @return 활성화 여부
	 * @category
	  
	  */
	public static boolean isOptionEnabled(int options, int check)
	{
		return ( options & check ) != 0;
	}// method

	public static final int option1 = 0x00000001;
	public static final int option2 = 0x00000002;
	public static final int option3 = 0x00000004;
	public static final int option4 = 0x00000008;
	public static final int option5 = 0x00000010;
	public static final int option6 = 0x00000020;
	public static final int option7 = 0x00000040;
	public static final int option8 = 0x00000080;
	public static final int option9 = 0x00000100;

	public static void main(String [] args)
	{

		// 각 비트가 1로 셋팅된 상태가
		// 해당 옵션의 활성화 상태를 의미합니다.
		// 라는걸 보여주기 위한 출력코드

		System.out.println(Integer.toBinaryString(option1)); // output : 1
		System.out.println(Integer.toBinaryString(option2)); // output : 10
		System.out.println(Integer.toBinaryString(option3)); // output : 100
		System.out.println(Integer.toBinaryString(option4)); // output : 1000
		System.out.println(Integer.toBinaryString(option5)); // output : 10000
		System.out.println(Integer.toBinaryString(option6)); // output : 100000
		System.out.println(Integer.toBinaryString(option7)); // output : 1000000
		System.out.println(Integer.toBinaryString(option8)); // output :
																// 10000000
		System.out.println(Integer.toBinaryString(option9)); // output :
																// 100000000

		// 아래처럼 사용합니다.

		int options = option1 | option3;
		
		System.out.println(isOptionEnabled(options, option1)); // output : true
		System.out.println(isOptionEnabled(options, option3)); // output : true
		System.out.println(isOptionEnabled(options, option7)); // output : false

		options = optionEnable(options, option7);

		System.out.println(isOptionEnabled(options, option7)); // output : true

		options = optionDisable(options, option1);

		System.out.println(isOptionEnabled(options, option1)); // output : false

	}// method
}// class

