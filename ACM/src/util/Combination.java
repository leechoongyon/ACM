package util;

import java.util.Arrays;

public class Combination {

	public static void main(String[] args) { 
	    
		int n = 4; 
	    // nCr 이면 r이 2
	    /*int r = 2; */
		int[] ptrList;
		
	    for (int r = 1 ; r < 6; r++) {
	    	
	    	ptrList = createPointerList(r); 
	    	do { 
	    		/* ↓↓ DO WHAT YOU WANT ↓↓ */ 
	    		System.out.println(Arrays.toString(ptrList)); 
	    		/* ↑↑ DO WHAT YOU WANT ↑↑ */ 
	    	} while (next(n, ptrList)); 
	    }
	    
	} 

	public static int[] createPointerList(int n) { 
	    int[] ptrList = new int[n];
	    for(int i = 0; i < n; i++) 
	        ptrList[i] = n - 1 - i; 
	    return ptrList; 
	} 

	public static boolean next(int N, int[] ptrList) {  
	    for(int i = 0; i < ptrList.length; i++) {  
	        if(ptrList[i] < N - 1 - i) {  
	            ptrList[i]++;  
	            for(int j = i - 1; j >= 0; j--)  
	                ptrList[j] = ptrList[i] + (i - j);  
	            return true;  
	        }                  
	    } 
	    return false;
	}
}
