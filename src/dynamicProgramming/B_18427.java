package dynamicProgramming;

import java.util.*;
import java.io.*;

public class B_18427 {
	static final int div = 10007;
	static int N, M, H;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		dp = new int[N + 1][H + 1];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			dp[i - 1][0] = 1;
			
			while(st.hasMoreTokens()) {
				int h = Integer.parseInt(st.nextToken());
				for(int j=h;j<=H;j++) 
					dp[i][j] += dp[i - 1][j - h];
			}
			
			for(int j=1;j<=H;j++) {
				dp[i][j] += dp[i - 1][j];
				dp[i][j] %= div;
			}
		}
		
		System.out.println(dp[N][H]);
	}

}
