package algorithm;

 
 

/**
 * @author lee
 * @desc
 * 
 * 	1. Pivot이 num[Right] 보다 크면 right를 Pivot과 교체
	2. Pivot이 num[left] 보다 작으면 left를 pivot과 교체
	3. 교체된 left 자리에 pivot을 놓고
	4. 다시 재귀 호출
 */

public class QuickSort
{
    final static int itemSize = 6;
    public static void main(String [] args)
    {
        
        int num[] = { 3, 8, 0, 2, 1, 4 };
        
        System.out.println("Before sorting");
        print(num, 0, 0);
        quickSort(num, itemSize);
        System.out.println("After sorting");
        
    }
    public static void quickSort(int num[], int array_size)
    {
        q_sort(num, 0, array_size - 1);
    }
    public static void q_sort(int num[], int left, int right)
    {
        int pivot, l_hold, r_hold;
        l_hold = left;
        r_hold = right;
        pivot = num[left]; // 0번째 원소를 피봇으로 선택
        while (left < right)
        {
            // 값이 선택한 피봇과 같거나 크다면, 이동할 필요가 없다
            while (( num[right] >= pivot ) && ( left < right ))
                right--;
            // 그렇지 않고 값이 피봇보다 작다면,
            // 피봇의 위치에 현재 값을 넣는다.
            if (left != right)
            {
                num[left] = num[right];
            }
            // 왼쪽부터 현재 위치까지 값을 읽어들이면서
            // 피봇보다 큰 값이 있다면, 값을 이동한다.
            while (( num[left] <= pivot ) && ( left < right ))
                left++;
            if (left != right)
            {
                num[right] = num[left];
                right--;
            }
            
            print(num, left, right);
        }
        System.out.println();
        System.out.println("loop end");
        
        // 모든 스캔이 끝났다면, 피봇값을 현재 위치에 입력한다.
        // 이제 피봇을 기준으로 왼쪽에는 피봇보다 작거나 같은 값만 남았다.
        num[left] = pivot;
        pivot = left;
        left = l_hold;
        right = r_hold;
        
        System.out.println();
        System.out.println("before recursive call");
        print(num, left, right);
        
        // 재귀호출을 수행한다.
        if (left < pivot)
            q_sort(num, left, pivot - 1);
        if (right > pivot)
            q_sort(num, pivot + 1, right);
    }
    
    public static void print(int num[], int left, int right)
    {
        System.out.println();
//        System.out.println("left : " + left + " / right : " + right);
        
        for (int n : num)
            System.out.print(n +" ");
        
        System.out.println();
    }
}
