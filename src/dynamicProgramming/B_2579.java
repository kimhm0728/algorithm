package dynamicProgramming;

import java.io.*;

public class B_2579 {
	static int N;
	static int[] score;
	static Integer[][] dp;

	public static void main(String[] args) throws IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		score = new int[N];
		dp = new Integer[N][2];

		for(int i=0;i<N;i++) 
			score[i] = Integer.parseInt(br.readLine());

		// 연속된 계단을 밟을 수 있는 경우 1, 없는 경우 0
		System.out.println(stairs(N - 1, 1));
	}

	static int stairs(int n, int next) {
		if(n == 0)
			return score[0];
		if(n == 1)
			return next == 1 ? score[0] + score[1] : score[1];

			if(dp[n][next] == null) {
				if(next == 1)
					return dp[n][1] = score[n] + Math.max(stairs(n - 2, 1), stairs(n - 1, 0));
				return dp[n][0] = score[n] + stairs(n - 2, 1);
			}

			return dp[n][next];
	}

}
