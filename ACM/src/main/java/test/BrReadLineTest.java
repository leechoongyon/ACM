package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BrReadLineTest {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        String s = br.readLine();
        String ss = br.readLine();
        System.out.println("s : " + s);
        System.out.println("ss : " + ss);
	}
}
