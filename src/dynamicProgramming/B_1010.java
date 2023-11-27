package dynamicProgramming;

import java.util.*;
import java.io.*;

public class B_1010 {
	static Integer[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		dp = new Integer[30][30];
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			
			int R = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			sb.append(combi(N, R)).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static int combi(int n, int r) {
		if(n == r || r == 0)
			return dp[n][r] = 1;
		
		if(dp[n][r] == null)
			return dp[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
		
		return dp[n][r];
	}

}
