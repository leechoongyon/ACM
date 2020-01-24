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
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine();

    }

    /**
     *
     * 1. brute-force
     *  - for 문 돌림.
     *  - 0~n 까지 i 와 n 을 차츰 비교해 나감.
     *  - 이게 O(n제곱)
     *
     * 2. 
     *
     * @param s
     * @return
     */
    /*public String longestPalindrome(String s) {

    }*/
}
