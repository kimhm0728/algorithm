package skt;

import java.io.*;

public class B_2156 {
	static int[] grape;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		grape = new int[n];
		dp = new int[2][n];
		
		for (int i=0;i<n;i++) {
			grape[i] = Integer.parseInt(br.readLine());
			dp[0][i] = dp[1][i] = -1;
		}
		
		System.out.println(Math.max(solution(0, n - 1), solution(0, n - 2)));
	}
	
	static int solution(int cnt, int n) {
		if (n < 0) return 0;
		if (dp[cnt][n] != -1) return dp[cnt][n];
		
		int temp = Math.max(solution(0, n - 2), solution(0, n - 3));
		if (cnt != 1) temp = Math.max(solution(1, n - 1), temp);
		
		return dp[cnt][n] = temp + grape[n];
	}

}
