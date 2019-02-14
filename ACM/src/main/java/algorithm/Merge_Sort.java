package algorithm;

public class Merge_Sort 
{
	public static void main(String[] args) 
	{
	
		 int[] arr = { 31, 8, 48, 74, 4, 75, 20, 29, 11, 15 };

		  mergeSort(arr, 0, arr.length - 1);

		  for (int o : arr) 
		  {
			  System.out.print(o);
			  System.out.print(" ");
		  }
	}//main
	
	 // 병합정렬
	public static void mergeSort(int[] arr, int p, int r) 
	{
	  if (p < r) 
	  {
	   int q = (p + r) / 2; // p와 r의 중간지점.
	   mergeSort(arr, p, q);// 중간지점까지 정렬.
	   mergeSort(arr, q + 1, r);// 후반부정렬
	   merge(arr, p, q, r);//병합
	  }
	}

	public static void merge(int[] arr, int p, int q, int r) 
	{
	  int i = p, j = q + 1, t = 1;
	  /*
	   * i = 배열의 시작
	   * j = 중간지점
	   * r = 끝
	   */
	  
	  //새로운 배열을 생성
	  int tmp[] = new int[arr.length + 1];
	  
	  //시작이 끝보다 작거나 같고 중간지점보다 끝이 작거나 같다면 
	  while (i <= q && j <= r) 
	  {
		System.out.println("Before i : " + i + " // j : " + j);
		 
		  
	   //배열의 시작 원소가 배열의 끝보다 작거나 같다면
	   if (arr[i] <= arr[j]) 
	   {
	    //tmp[t]에 arr[i]원소를 집어넣고 ++; 
	    tmp[t++] = arr[i++];
	   } else 
	   {
	    //아니라면 끝원소를 넣고 j를 ++;
	    tmp[t++] = arr[j++];
	   }
	   
	   System.out.println("After i :" +
	   		" " + i + " // j : " + j + " // t : " + t);
	  }
	  
	  
	  /* 이게 왜 남냐하면 i부터 q는 중간선 왼쪽 (이건 작으니까 그대로 넣으면 되고)  
	   * q부터 r은 중간선 오른쪽을 의미하고 (이건 작으니까 그대로 넣으면 되고)
	   * */
	  //왼쪽 부분 배열이 남은경우
	  while (i <= q)
	   tmp[t++] = arr[i++];

	  //오른쪽 부분이 남은 경우	, 위에꺼랑 동일
	  while (j <= r)
	   tmp[t++] = arr[j++];

	  i = p;
	  t = 1;

	  //결과를 arr에 저장
	  while (i <= r)
	   arr[i++] = tmp[t++];
	 }
	}