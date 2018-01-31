package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lee
 * @point & feedback
 * 	1. Node 로 해서 풀려고 함. 근데 Node Insert 할 때 막힘. 골고루 넣어줄수 없기에
 * 	2. 힌트 봄. 기가막힘.
 * 	3. startWith 라는건 결국 앞에 같은 글자로 시작하는지 체크.
 * 	4. add 할 때 같은 글자 패턴이 나오면 occurences 에만 체크하고 등록은 안함.
 * 	5. 다른 글자 패턴이 나오면 더 해줌.
 * 
8
add hacb
add haca
add hacd
add hacc
add hace
add hacf
find hac
find hak
 */
public class Contacts 
{
    private static List<String> list = new ArrayList<String>();
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++)
        {
            String op = in.next();
            String contact = in.next();
            
            solve(op, contact);
        }
    }
    
    public static void solve(String op, String contact)
    {
    	if ("add".equals(op))
    	{
    		
    	}
    	else if ("find".equals(op))
    	{
    		
    	}
    	else
    		throw new IllegalArgumentException("Invalid args...");
    }
}

class NodeDataStructure
{
	String data;
	Node left;
	Node right;
}
