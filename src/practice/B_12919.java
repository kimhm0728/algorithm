package skt;

import java.io.*;

public class B_12919 {
	static String s;
	static int s_len;
	
	public static void main(String[] args) throws IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	    s = br.readLine();
	    s_len = s.length();
		String t = br.readLine();
		
		DFS(t, t.length());
		
		System.out.println(0);
	}
	
	static void DFS(String t, int len) {
		if (len == s_len) {
			if (t.toString().equals(s)) {
				System.out.println(1);
				System.exit(0);
			}
			return;
		}
		
		if (t.charAt(len - 1) == 'A') DFS(t.substring(0, len - 1), len - 1);
		if (t.charAt(0) == 'B') DFS(new StringBuilder(t).reverse().substring(0, len - 1), len - 1);
	}

}
