package codility;

public class OddOccurrencesInArray
{
	 public int solution(int[] A) 
	 {
	        /**
	         *  sol1. xor 이용
	         *  1. array 순회하며, result ^ array[i]  비교.
	         *  2. 짝수라면 0이 되고, 홀수만 비트가 1로 찍혀서 답이 나옴.
	         * 
	         *  시간복잡도 : O(n)
	         *  공간복잡도 : O(1)
	         *  
	         *  case
	         *  1. N = 1 (7)
	         *  2. N = 1,000,000 (너무 많아서 입력 어렵네)
	         *  3. element 가 1,000,000,000 일 때
	         *
	         *  validation 은 따로 걸지 않는다. 문제에 명시됐으니
	         */
	         
		 int res = 0;
	         
	     for (int i = 0 ; i < A.length ; i++)
	     {
	    	 res = res ^ A[i];    
	     }
	         
	     return res;
	 }
}
