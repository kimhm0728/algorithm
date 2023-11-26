package skt;

import java.util.*;
import java.io.*;

public class B_1010 {
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		dp = new int[30][30];
		
		StringTokenizer st;
		for (int i=0;i<t;i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			sb.append(combi(m, n)).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static int combi(int n, int r) {
		if (r == 0 || n == r) return dp[n][r] = 1;
		if (dp[n][r] != 0) return dp[n][r];
		
		return dp[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
	}

}
