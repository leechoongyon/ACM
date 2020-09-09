package test;

import java.util.Arrays;

public class StringCompareTest {
    public static void main(String[] args) {
        char[] chars = new char[] {'a','d', 'c', 'b'};
        System.out.println(new String(chars));
        Arrays.sort(chars, 0,2);
        System.out.println(new String(chars));
    }
}
