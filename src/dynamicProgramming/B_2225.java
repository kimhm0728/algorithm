package dynamicProgramming;

import java.util.*;
import java.io.*;

public class B_2225 {
	static final int INF = Integer.MAX_VALUE;
	static final int div = 1000000000;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		dp = new int[N + 1][K + 1];
		
		for(int i=0;i<=N;i++) {
			Arrays.fill(dp[i], INF);
			dp[i][0] = 0;
		}
		
		dp[0][0] = 1;
		System.out.println(sumCount(N, K));
	}
	
	static int sumCount(int n, int k) {
		if(dp[n][k] == INF) {
			int temp = 0;
			for(int i=n;i>=0;i--) 
				temp = (temp + sumCount(n - i, k - 1)) % div;
			
			dp[n][k] = temp % div;
		}
		
		return dp[n][k];
	}
    
}