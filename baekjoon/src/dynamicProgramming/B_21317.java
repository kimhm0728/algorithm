package dynamicProgramming;

import java.util.*;
import java.io.*;

public class B_21317 {
	static int N, K;
	static int[][] energy;
	static Integer[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		energy = new int[21][2];
		dp = new Integer[21][2];

		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());

			energy[i][0] = Integer.parseInt(st.nextToken());
			energy[i][1] = Integer.parseInt(st.nextToken());
		}

		K = Integer.parseInt(br.readLine());

		dp[0][0] = dp[0][1] = energy[0][0];
		dp[1][0] = dp[1][1] = Math.min(energy[0][0] + energy[1][0], energy[1][1]);

		System.out.println(getMin(N - 2, 1));
	}

	// 매우 큰 점프가 가능한 경우라면 jump가 1, 가능하지 않으면 0
	static int getMin(int n, int jump) {
		if(dp[n][jump] == null) {
			if(n < 3) {
				if(jump == 0)
					dp[n][jump] = Math.min(getMin(n - 1, 0) + energy[n][0], getMin(n - 2, 0) + energy[n][1]);
				else
					dp[n][jump] = Math.min(getMin(n - 1, 1) + energy[n][0], 
							Math.min(getMin(n - 2, 1) + energy[n][1], K));
			}
			else {
				if(jump == 0)
					dp[n][jump] = Math.min(getMin(n - 1, 0) + energy[n][0], getMin(n - 2, 0) + energy[n][1]);
				else
					dp[n][jump] = Math.min(getMin(n - 1, 1) + energy[n][0], 
							Math.min(getMin(n - 2, 1) + energy[n][1], getMin(n - 3, 0) + K));
			}
		}

		return dp[n][jump];
	}

}
