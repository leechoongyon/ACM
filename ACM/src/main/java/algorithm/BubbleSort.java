package algorithm;

public class BubbleSort
{
	public static String BubbleSorting(String str, int size)
	{
		char cArray[];
		cArray = str.toCharArray();

		for(int i = 0 ; i < size - 1 ; i++)
		{
			for(int j = 1 ; j < size -1 ; j++)
			{
				if(cArray[j-1] > cArray[j])
				{
					char temp;
					temp = cArray[j-1];
					cArray[j-1] = cArray[j];
					cArray[j] = temp;
				}
			}
		}

		String sortedStr = new String(cArray);
		
		return sortedStr;
	}

	
	
	public static int[] BubbleSorting(int number[], String option) {
		
	if(option == "desc") {

		for (int i=0; i< number.length ; i++) {
			   boolean changed = false;
			    
			   for (int j=0; j< number.length-1-i ; j++) {
			    if (number[j] > number[j+1]) { //버블정렬이 적용되는 조건문
			     int temp = number[j];
			     number[j] = number[j+1];
			     number[j+1] = temp;
			     changed = true;
			    } //end if
			   } // end for j
			    
			   if (!changed) break; // 자리바꿈이 없으면 반복문을 벗어난다.
			    
			  } //end for i
			return number;
		
	} else if(option == "asc") {
		
		for (int i=0; i< number.length ; i++) {
			boolean changed = false;
			
			for (int j=0; j< number.length-1-i ; j++) {
				if (number[j] < number[j+1]) { //버블정렬이 적용되는 조건문
					int temp = number[j];
					number[j] = number[j+1];
					number[j+1] = temp;
					changed = true;
				} //end if
			} // end for j
			
			if (!changed) break; // 자리바꿈이 없으면 반복문을 벗어난다.
			
		} //end for i
		return number;
	}
	return number;
	}
		
}

