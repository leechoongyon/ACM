package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author USER
 * <p>
 * input : fvincndjrurfh
 * output : fvincndjrurhf
 */


public class BiggerIsGreater {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        solve(s);
    }

    /**
     * 1. brute-force
     *  - X
     *
     * 2. 규칙으로 풀기.
     *  - 일단 맨 끝 알파벳에서 for 문 돌려서 줄어드는 구간을 찾는다.
     *  - abdec 라면, c < e, e > d 이니 d 가 줄어드는 구간임.
     *  - d 보다 크지만 가장 작은 수를 찾아보자. e 임.
     *  - 그럼 e 랑 d 를 바꿈. abedc
     *  - 그런 뒤, d 의 위치부터 sorting 한다.
     *  - abecd 가 된다.
     * @return
     */
    public static String solve(String s) {
        char[] chars = s.toCharArray();
        int lastIdx = chars.length - 1;
        int minVal = Integer.MAX_VALUE;
        int minIdx = Integer.MAX_VALUE;
        int turningPoint = 0;
        for (int i = lastIdx ; i > 0 ; i--) {
            /** 작아지는 구간을 찾는다. */
            if (chars[i] > chars[i-1]) {
                turningPoint = i-1;
                for (int k = i ; k <= lastIdx ; k++) {
                    if (chars[turningPoint] < chars[k] && minVal > chars[k]) {
                        minVal = chars[k];
                        minIdx = k;
                    }
                }
                swap(chars, turningPoint, minIdx);
                Arrays.sort(chars, minIdx, lastIdx + 1);
                System.out.println(new String(chars));
                break;
            }

        }

        return "";
    }

    private static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
