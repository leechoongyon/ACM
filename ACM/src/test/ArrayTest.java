package test;

public class ArrayTest {
	static int [] watch = {12, 6, 6, 6, 6, 6, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};
	static int [][] switchList = {{0,1,2}, {3,7,9,11}, {4, 10, 14, 15}, {0, 4, 5, 6, 7}, {6, 7, 8, 10, 12}, {0, 2, 14, 15}, {3, 14, 15}, {4, 5, 7, 14, 15}, {1, 2, 3, 4, 5}, {3, 4, 5, 9, 13}}; 
	static int [] tempWatch = watch.clone();
	
	public static void main(String[] args) {
		
	System.out.println(tempWatch[1]);
	tempWatch[1] = 66;
	System.out.println(tempWatch[1]);
	System.out.println(watch[1]);	
	}
}
