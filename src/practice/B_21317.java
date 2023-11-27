package skt;

import java.io.*;
import java.util.*;

public class B_21317 {
	static int INF = 987654321;
	static int n, k;
	static int[][] energy;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine()) - 1;
		energy = new int[n][2];
		dp = new int[n][2]; // 0: 매우 큰 점프 x, 1: 매우 큰 점프 o
		
		StringTokenizer st;
		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			energy[i][0] = Integer.parseInt(st.nextToken());
			energy[i][1] = Integer.parseInt(st.nextToken());
		}
		
		k = Integer.parseInt(br.readLine());
		System.out.println(solution(0, 0));
	}
	
	static int solution(int i, int flag) {
		if (i == n) return 0;
		if (dp[i][flag] != 0) return dp[i][flag];
		
		dp[i][flag] = INF;
		if (flag == 0 && i + 3 <= n) dp[i][flag] = solution(i + 3, 1) + k;
		if (i + 2 <= n) dp[i][flag] = Math.min(dp[i][flag], solution(i + 2, flag) + energy[i][1]);
		dp[i][flag] = Math.min(dp[i][flag], solution(i + 1, flag) + energy[i][0]);
		
		return dp[i][flag];
	}

}
