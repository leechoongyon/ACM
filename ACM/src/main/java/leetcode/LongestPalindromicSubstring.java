package leetcode;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * s 가 주어졌을 때 가장 긴 palindrome 를 찾아라.
 * 최대 길이는 1000
 * <p>
 * Example 1:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * <p>
 * Example 2:
 * Input: "cbbd"
 * Output: "bb"
 */

public class LongestPalindromicSubstring {

    private static char[] c1;
    private static char[] c2;
    private static int[][] cache;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        System.out.println(new LongestPalindromicSubstring().longestPalindrome(s));
    }

    /**
     *
     * 1. brute-force
     *  - for 문 돌림.
     *  - 0~n 까지 i 와 n 을 차츰 비교해 나감.
     *  - 이게 O(n제곱)
     *
     * 2. LCS 이용
     *  1) 주어진 s 를 뒤집어도 LCS 는 같아야 함.
     *  2)
     *
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String reverse = reverse(s);
        for (int i = 0 ; i < s.length() ; i++) {
            for (int j = 0 ; j < reverse.length() ; j++) {
                lcs(i, j);
            }
        }
        return "";
    }

    public String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    public String lcs(int i, int j) {
        if (i < 0 || j < 0) {
            return "";
        }

        if (c1[i] == c2[j]) {{

        }}
        return "";
    }
}
