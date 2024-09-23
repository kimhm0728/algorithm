package java.dp;

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

		dp[0][0] = dp[0][1] = 0;
		dp[1][0] = dp[1][1] = energy[0][0];
		dp[2][0] = dp[2][1] = Math.min(energy[0][0] + energy[1][0], energy[0][1]);
		
		for(int i=3;i<N;i++) {
			dp[i][0] = Math.min(dp[i - 1][0] + energy[i - 1][0], dp[i - 2][0] + energy[i - 2][1]);
			dp[i][1] = Math.min(Math.min(dp[i - 1][1] + energy[i - 1][0], dp[i - 2][1] + energy[i - 2][1]), dp[i - 3][0] + K);
		}
		
		System.out.println(Math.min(dp[N - 1][0], dp[N - 1][1]));
	}

}
