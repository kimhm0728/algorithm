package dynamicProgramming;

import java.util.*;
import java.io.*;

public class B_21923 {
	static int N, M;
	static int[][] score;
	static Integer[][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		score = new int[N][M];
		dp = new Integer[2][N][M];

		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++)
				score[i][j] = Integer.parseInt(st.nextToken());
		}

		for(int i=N-1;i>=0;i--) {
			for(int j=0;j<M;j++) {
				if(i == N - 1 && j == 0) 
					dp[0][i][j] = score[i][j];
				else if(i == N - 1) 
					dp[0][i][j] = score[i][j] + dp[0][i][j - 1];
				else if(j == 0)
					dp[0][i][j] = score[i][j] + dp[0][i + 1][j];
				else
					dp[0][i][j] = score[i][j] + Math.max(dp[0][i][j - 1], dp[0][i + 1][j]);
			}
		}

		for(int i=N-1;i>=0;i--) {
			for(int j=M-1;j>=0;j--) {
				if(i == N - 1 && j == M - 1) 
					dp[1][i][j] = score[i][j];
				else if(i == N - 1) 
					dp[1][i][j] = score[i][j] + dp[1][i][j + 1];
				else if(j == M - 1)
					dp[1][i][j] = score[i][j] + dp[1][i + 1][j];
				else
					dp[1][i][j] = score[i][j] + Math.max(dp[1][i][j + 1], dp[1][i + 1][j]);
			}
		}

		int answer = Integer.MIN_VALUE;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++)
				answer = Math.max(dp[0][i][j] + dp[1][i][j], answer);
		}
		
		System.out.println(answer);
	}

}
